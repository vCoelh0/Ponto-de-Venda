package com.coelhodev.cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelhodev.cardapio.dto.PedidoDTO;
import com.coelhodev.cardapio.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService service;
	
	@PostMapping
	public PedidoDTO adicionar (@RequestBody  PedidoDTO dto) {
		return service.adicionar(dto);	
	}
	
	
	@GetMapping
	public List<PedidoDTO> listar() {
		return service.listar();
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
	

}
