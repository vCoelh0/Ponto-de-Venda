package com.coelhodev.cardapio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	            itemPedido.setQuantiedade(itemDto.getQuantidade());
	            itemPedido.setItemCardapio(itemCardapio);
	            itemPedido.setPedido(pedido); 
			  
	            itensPedido.add(itemPedido);
		  }
		  
		pedido.setItens(itensPedido);
		
		pedido = pedidoRepository.save(pedido);
		
		return new PedidoDTO(pedido);	
	}
	
	
}
