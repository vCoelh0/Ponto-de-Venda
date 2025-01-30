package com.coelhodev.cardapio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coelhodev.cardapio.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT p FROM Pedido p JOIN FETCH p.itens")
	List<Pedido> findAllWithItens();
}
