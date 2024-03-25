package com.kata.helpDesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.helpDesk.domain.Pessoa;
import com.kata.helpDesk.domain.Tecnico;
import com.kata.helpDesk.domain.dtos.TecnicoDTO;
import com.kata.helpDesk.repositories.PessoaRepository;
import com.kata.helpDesk.repositories.TecnicoRepository;
import com.kata.helpDesk.services.exceptions.DataIntegrityViolationException;
import com.kata.helpDesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDto) {
		objDto.setId(null);
		validarPorCPfEmail(objDto);
		Tecnico newObj = new Tecnico(objDto);
		return repository.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDto) {
		objDto.setId(id);
		Tecnico oldObj = findById(id);
		validarPorCPfEmail(objDto);
		oldObj = new Tecnico(objDto);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Tecnico possui ordens de serviço e não pode ser deletado !");
		}
		repository.delete(obj);
	}

	private void validarPorCPfEmail(TecnicoDTO objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("CPF Já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDto.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("E-mail Já cadastrado no sistema!");
		}

	}

}
