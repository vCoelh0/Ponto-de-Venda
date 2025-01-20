package com.coelhodev.cardapio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantiedade;
	
	@ManyToOne
	private Cardapio itemCardapio;
	
	public ItemPedido() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantiedade() {
		return quantiedade;
	}

	public void setQuantiedade(int quantiedade) {
		this.quantiedade = quantiedade;
	}

	public Cardapio getItemCardapio() {
		return itemCardapio;
	}

	public void setItemCardapio(Cardapio itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	
	
}
