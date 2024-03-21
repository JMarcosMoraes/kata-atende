package com.kata.helpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.helpDesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
