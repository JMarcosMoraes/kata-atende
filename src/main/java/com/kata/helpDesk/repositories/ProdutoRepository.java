package com.kata.helpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.helpDesk.domain.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	Produto findTopByOrderByCodDesc();
	
	
}
