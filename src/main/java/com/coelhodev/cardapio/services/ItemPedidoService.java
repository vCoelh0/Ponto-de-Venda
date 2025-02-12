package com.coelhodev.cardapio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.coelhodev.cardapio.dto.ItemPedidoDTO;
import com.coelhodev.cardapio.entities.Cardapio;
import com.coelhodev.cardapio.entities.ItemPedido;
import com.coelhodev.cardapio.entities.Pedido;
import com.coelhodev.cardapio.repository.CardapioRepository;
import com.coelhodev.cardapio.repository.ItemPedidoRepository;
import com.coelhodev.cardapio.repository.PedidoRepository;

public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository repository;
	
	@Autowired
	CardapioRepository cardapioRepository;
	
	@Autowired 
	PedidoRepository pedidoRepository;
	
	public ItemPedidoDTO adicionar (ItemPedidoDTO dto) {
		
		Pedido pedido = pedidoRepository.findById(dto.getPedidoId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
		
		
		
		Optional<Cardapio> itemCardapio = cardapioRepository.findById(dto.getItemCardapioId());
	    if (itemCardapio.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item do cardápio não encontrado!");
	    }
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setQuantidade(dto.getQuantidade());
		
		System.out.println("ItemCardapio encontrado: " + itemCardapio.get());
		itemPedido.setItemCardapio(itemCardapio.get());
		itemPedido.setPedido(pedido);
		
		
		itemPedido = repository.save(itemPedido);
		
		return new ItemPedidoDTO(itemPedido);	
	}
	
}
