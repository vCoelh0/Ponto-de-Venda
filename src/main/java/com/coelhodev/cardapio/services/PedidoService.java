package com.coelhodev.cardapio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coelhodev.cardapio.dto.CardapioDTO;
import com.coelhodev.cardapio.dto.PedidoDTO;
import com.coelhodev.cardapio.entities.Pedido;
import com.coelhodev.cardapio.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Transactional
	public PedidoDTO adicionar (PedidoDTO dto) {
		
		Pedido pedido = new Pedido();
		
		pedido.setNumeroMesa(dto.getNumeroMesa());
		pedido.setDataHora(dto.getDataHora());
		pedido.setItens(dto.getItens());
		
		pedido = pedidoRepository.save(pedido);
		
		return new PedidoDTO(pedido);	
	}
	
	
}
