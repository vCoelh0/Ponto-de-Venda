package com.coelhodev.cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelhodev.cardapio.dto.CardapioDTO;
import com.coelhodev.cardapio.services.CardapioService;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService service;	
	
	@PostMapping
	public CardapioDTO adicionar (@RequestBody  CardapioDTO dto) {
		return service.adicionar(dto);	
	}
	
	@PutMapping(value = "/{id}")
	public CardapioDTO atualizar (@PathVariable Long id,@RequestBody CardapioDTO dto) {
		dto = service.atualizar(id, dto);
		return dto;
	}
	
	@GetMapping
	public List<CardapioDTO> listar() {
		return service.listar();
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
	
	
	
}
