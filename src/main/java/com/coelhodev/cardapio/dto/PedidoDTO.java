package com.coelhodev.cardapio.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.coelhodev.cardapio.entities.Pedido;


public class PedidoDTO {

	private Long id;
	private int numeroMesa;
	private	LocalDateTime dataHora;
	private Double totalPrice;
	private List<ItemPedidoDTO> itens;
	
	
	public PedidoDTO() {
		
	}
		
	
	public PedidoDTO(Long id, int numeroMesa, LocalDateTime dataHora, Double totalPrice, List<ItemPedidoDTO> itens) {
		this.id = id;
		this.numeroMesa = numeroMesa;
		this.dataHora = dataHora;
		this.totalPrice = totalPrice;
		this.itens = itens;
	}


	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		numeroMesa = entity.getNumeroMesa();
		dataHora = entity.getDataHora();
		totalPrice = entity.getTotalPrice();
		this.itens = entity.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumeroMesa() {
		return numeroMesa;
	}


	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}


	
	
	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public LocalDateTime getDataHora() {
		return dataHora;
	}


	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}


	public List<ItemPedidoDTO> getItens() {
		return itens;
	}


	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}
	
	
	
}
