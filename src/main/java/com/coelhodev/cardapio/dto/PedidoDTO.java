package com.coelhodev.cardapio.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.coelhodev.cardapio.entities.ItemPedido;
import com.coelhodev.cardapio.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoDTO {

	private Long id;
	private int numeroMesa;
	private	LocalDateTime dataHora;
	private List<ItemPedido> itens;
	
	
	public PedidoDTO() {
		
	}
	
	
	
	public PedidoDTO(Long id, int numeroMesa, LocalDateTime dataHora, List<ItemPedido> itens) {
		this.id = id;
		this.numeroMesa = numeroMesa;
		this.dataHora = dataHora;
		this.itens = itens;
	}


	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		numeroMesa = entity.getNumeroMesa();
		dataHora = entity.getDataHora();
		itens = entity.getItens();
	}


	public Long getId() {
		return id;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
	
	
	
	
	
}
