package com.kata.helpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.helpDesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
