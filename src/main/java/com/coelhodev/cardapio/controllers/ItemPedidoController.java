package com.coelhodev.cardapio.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelhodev.cardapio.dto.ItemPedidoDTO;
import com.coelhodev.cardapio.services.ItemPedidoService;


@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

	ItemPedidoService service;
	
	@PostMapping
	public ItemPedidoDTO adicionar (@RequestBody  ItemPedidoDTO dto) {
		return service.adicionar(dto);	
	}
	
}
