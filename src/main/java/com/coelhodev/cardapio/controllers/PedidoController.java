package com.coelhodev.cardapio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}
