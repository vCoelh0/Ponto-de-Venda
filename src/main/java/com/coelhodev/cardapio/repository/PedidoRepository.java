package com.coelhodev.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coelhodev.cardapio.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
