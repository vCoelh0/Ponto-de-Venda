package com.coelhodev.cardapio.services;

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
		
		
		//verificar se o item existe no cardapio.
		Cardapio itemCardapio = cardapioRepository.findById(dto.getItemCardapioId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado no cardapio!"));
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setQuantiedade(dto.getQuantidade());
		itemPedido.setItemCardapio(itemCardapio);
		itemPedido.setPedido(pedido);
		
		
		itemPedido = repository.save(itemPedido);
		
		return new ItemPedidoDTO(itemPedido);	
	}
	
}
