package com.coelhodev.cardapio.dto;

import com.coelhodev.cardapio.entities.ItemPedido;

public class ItemPedidoDTO {

	private Long id;
	private int quantidade;
	private Long itemCardapioId;
	private Long pedidoId;  
	
	public ItemPedidoDTO() {
		
	}

	 public ItemPedidoDTO(ItemPedido entity) {
	        this.id = entity.getId();
	        this.quantidade = entity.getQuantidade();
	        this.itemCardapioId = entity.getItemCardapio().getId();
	        this.pedidoId = entity.getPedido().getId();
	    }

	public Long getId() {
		return id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Long getItemCardapioId() {
		return itemCardapioId;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	
	 
	


	
	
	
	
	
	
	
	
}
