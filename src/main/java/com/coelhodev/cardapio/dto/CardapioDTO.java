package com.coelhodev.cardapio.dto;

import com.coelhodev.cardapio.entities.Cardapio;

public class CardapioDTO {

	private Long id;
	private String name;
	private Double price;
	private String description;

	
	public CardapioDTO(Long id, String name, Double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public CardapioDTO(Cardapio entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.description = entity.getDescription();
	
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}


	
	
	
	
	
	
}
