package com.kata.helpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.helpDesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
