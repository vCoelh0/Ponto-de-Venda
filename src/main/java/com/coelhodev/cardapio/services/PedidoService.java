package com.coelhodev.cardapio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.coelhodev.cardapio.dto.ItemPedidoDTO;
import com.coelhodev.cardapio.dto.PedidoDTO;
import com.coelhodev.cardapio.entities.Cardapio;
import com.coelhodev.cardapio.entities.ItemPedido;
import com.coelhodev.cardapio.entities.Pedido;
import com.coelhodev.cardapio.repository.CardapioRepository;
import com.coelhodev.cardapio.repository.PedidoRepository;
import com.coelhodev.cardapio.services.exceptions.DatabaseException;
import com.coelhodev.cardapio.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	CardapioRepository cardapioRepository;
	
	@Transactional
	public PedidoDTO adicionar (PedidoDTO dto) {
		
		Pedido pedido = new Pedido();
		
		pedido.setNumeroMesa(dto.getNumeroMesa());
		pedido.setDataHora(dto.getDataHora());
		//pedido.setItens(dto.getItens());
		  List<ItemPedido> itensPedido = new ArrayList<>();
		  
		  for(ItemPedidoDTO itemDto : dto.getItens()) {
			  Cardapio itemCardapio = cardapioRepository.findById(itemDto.getItemCardapioId())
	                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do cardápio não encontrado!"));
		
			  	ItemPedido itemPedido = new ItemPedido();
	            itemPedido.setQuantidade(itemDto.getQuantidade());
	            itemPedido.setItemCardapio(itemCardapio);
	            itemPedido.setPedido(pedido); 
			  
	            itensPedido.add(itemPedido);
		  }
		  
		pedido.setItens(itensPedido);
		pedido.setTotalPrice(pedido.calcularTotal());
		
		pedido = pedidoRepository.save(pedido);
		
		return new PedidoDTO(pedido);	
	}
	
	
	public List<PedidoDTO> listar() {
		 List<Pedido> result = pedidoRepository.findAllWithItens();
		 return result.stream().map(x -> new PedidoDTO(x)).toList();
		 
	}
	
	@Transactional
	public void deletar(Long id) {
		if(!pedidoRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
			try {
				pedidoRepository.deleteById(id);
			}
			
			catch(DataIntegrityViolationException e) {
				throw new DatabaseException("Falha de integridade referencial");
			}
	}
	
	@Transactional
	public PedidoDTO atualizar (Long id, PedidoDTO dto) {	
		
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
				
		//atualizar dados do pedido
		pedido.setNumeroMesa(dto.getNumeroMesa());
		pedido.setDataHora(dto.getDataHora());
		
		 // Mapear os itens existentes para facilitar a atualização
		Map<Long, ItemPedido> mapaItens = pedido.getItens().stream()
				.collect(Collectors.toMap(item -> item.getItemCardapio().getId(), item -> item));
		
		for (ItemPedidoDTO itemDto : dto.getItens()) {
	        Cardapio itemCardapio = cardapioRepository.findById(itemDto.getItemCardapioId())
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do cardápio não encontrado!"));

	        if(mapaItens.containsKey(itemDto.getItemCardapioId())) {
	        	ItemPedido itemPedido = mapaItens.get(itemDto.getItemCardapioId());
	        	itemPedido.setQuantidade(itemDto.getQuantidade());
	        } else {
	        
	        ItemPedido novoItem = new ItemPedido();
	        
	        novoItem.setQuantidade(itemDto.getQuantidade());
	        novoItem.setItemCardapio(itemCardapio);
	        novoItem.setPedido(pedido);
        	
	        pedido.getItens().add(novoItem);
	        }
		}
		
		 pedido.setTotalPrice(pedido.calcularTotal());
		 pedido = pedidoRepository.save(pedido);	 	
	
	   	return new PedidoDTO(pedido);
		
	}
}
