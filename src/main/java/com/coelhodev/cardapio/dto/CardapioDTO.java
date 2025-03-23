package com.coelhodev.cardapio.dto;

import com.coelhodev.cardapio.entities.Cardapio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CardapioDTO {

	private Long id;
	
	@Size(min = 3, max = 50, message = "O nome do produto precisa ter de 3 a 50 caracteres")
	@NotBlank(message = "Campo requerido")
	private String name;
	
	@Positive(message = "O preço do produto deve ser positivo")
	private Double price;
	
	@Size(min = 10, message = "A descrição do produto precisa ter no minimo 10 caracteres")
	@NotBlank(message = "Campo requerido")
	private String description;

	
	public CardapioDTO(Long id, String name, Double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public CardapioDTO(Cardapio entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		description = entity.getDescription();
	
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
