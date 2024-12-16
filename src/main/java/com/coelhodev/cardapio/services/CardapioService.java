package com.coelhodev.cardapio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coelhodev.cardapio.dto.CardapioDTO;
import com.coelhodev.cardapio.entities.Cardapio;
import com.coelhodev.cardapio.repository.CardapioRepository;

import jakarta.transaction.Transactional;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository repository;
	
	@Transactional
	public CardapioDTO adicionar (CardapioDTO dto) {
		
		Cardapio cardapio = new Cardapio();
		
		cardapio.setName(dto.getName());
		cardapio.setPrice(dto.getPrice());
		cardapio.setDescription(dto.getDescription());
	
		
		cardapio = repository.save(cardapio);
		
		return new CardapioDTO(cardapio);	
	}
	
	@Transactional
	public CardapioDTO atualizar (Long id, CardapioDTO dto) {
		
		Cardapio cardapio = repository.getReferenceById(id);		
		
		cardapio.setName(dto.getName());
		cardapio.setPrice(dto.getPrice());
		cardapio.setDescription(dto.getDescription());
		
		
		 cardapio = repository.save(cardapio);
		
		 return new CardapioDTO(cardapio);	
	}
	
	
	public List<CardapioDTO> listar() {
		 List<Cardapio> result = repository.findAll();
		 return result.stream().map(x -> new CardapioDTO(x)).toList();
		 
	}
	
	@Transactional
	public void deletar(Long id) {
		repository.deleteById(id);
		
	}
	
	
	
	
	
}
