package com.coelhodev.cardapio.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coelhodev.cardapio.dto.CardapioDTO;
import com.coelhodev.cardapio.services.CardapioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService service;	
	
	@PostMapping
	public ResponseEntity <CardapioDTO> adicionar (@Valid @RequestBody  CardapioDTO dto) {
			dto = service.adicionar(dto);	
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CardapioDTO> atualizar (@PathVariable Long id, @Valid @RequestBody CardapioDTO dto) {
		dto = service.atualizar(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<CardapioDTO>> listar() {
		List<CardapioDTO> dto =  service.listar();
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
