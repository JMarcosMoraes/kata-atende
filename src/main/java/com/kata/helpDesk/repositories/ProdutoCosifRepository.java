package com.kata.helpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.ProdutoCosifID;

public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, ProdutoCosifID>{
	ProdutoCosif findTopByOrderByProdutoCosifIDCodCosifDesc();
}