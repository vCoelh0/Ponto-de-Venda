package com.coelhodev.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coelhodev.cardapio.entities.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
