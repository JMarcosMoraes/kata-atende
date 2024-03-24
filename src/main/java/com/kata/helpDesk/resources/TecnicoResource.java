package com.kata.helpDesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.helpDesk.domain.Tecnico;
import com.kata.helpDesk.domain.dtos.TecnicoDTO;
import com.kata.helpDesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDto = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return (ResponseEntity.ok().body(listDto));
		
	}

	

}
