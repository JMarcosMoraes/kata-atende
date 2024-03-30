package com.kata.helpDesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.helpDesk.domain.Produto;
import com.kata.helpDesk.domain.dtos.ProdutoDTO;
import com.kata.helpDesk.repositories.ProdutoRepository;
import com.kata.helpDesk.services.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto findById(String id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto create(ProdutoDTO objDto) {
		
		Produto newObj = new Produto(objDto);
		newObj.setCod(nextCode(repository.findTopByOrderByCodDesc().getCod()));
		return repository.save(newObj);
	}

	public Produto update(String cod, @Valid ProdutoDTO objDto) {
		objDto.setCod(cod);
		Produto oldObj = findById(cod);
		oldObj = new Produto(objDto);
		return repository.save(oldObj);
	}

	public void delete(String cod) {
		Produto obj = findById(cod);
		repository.delete(obj);
	}
	
	 private String nextCode(String code) {
		 Integer nextCode = (Integer.parseInt(code) + 1);
		 return nextCode.toString();
		 
	 }


}
