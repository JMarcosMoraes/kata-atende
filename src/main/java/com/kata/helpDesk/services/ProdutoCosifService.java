package com.kata.helpDesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.ProdutoCosifID;
import com.kata.helpDesk.domain.dtos.ProdutoCosifDTO;
import com.kata.helpDesk.repositories.ProdutoCosifRepository;
import com.kata.helpDesk.services.exceptions.ObjectnotFoundException;

@Service
public class ProdutoCosifService {

	@Autowired
	private ProdutoCosifRepository repository;

	public ProdutoCosif findById(ProdutoCosifID id) {
		Optional<ProdutoCosif> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<ProdutoCosif> findAll() {
		return repository.findAll();
	}

	public ProdutoCosif create(ProdutoCosifDTO objDto) {
		ProdutoCosif newObj = new ProdutoCosif(objDto);
		newObj.getProdutoCosifID().setCodCosif(nextCode(repository.findTopByOrderByProdutoCosifIDCodCosifDesc().getProdutoCosifID().getCodCosif()));
		return repository.save(newObj);
	}

	public ProdutoCosif update(ProdutoCosifID cod, @Valid ProdutoCosifDTO objDto) {
		objDto.setProdutoCosifID(null);

		ProdutoCosif oldObj = findById(cod);
		oldObj = new ProdutoCosif(objDto);
		return repository.save(oldObj);
	}

	public void delete(ProdutoCosifID cod) {
		ProdutoCosif obj = findById(cod);
		repository.delete(obj);
	}

	private String nextCode(String code) {
		Integer nextCode = (Integer.parseInt(code) + 1);
		return nextCode.toString();

	}
}
