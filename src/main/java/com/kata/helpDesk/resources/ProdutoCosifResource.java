package com.kata.helpDesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kata.helpDesk.domain.Produto;
import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.ProdutoCosifID;
import com.kata.helpDesk.domain.dtos.ProdutoCosifDTO;
import com.kata.helpDesk.domain.dtos.ProdutoCosifIDDTO;
import com.kata.helpDesk.domain.dtos.ProdutoDTO;
import com.kata.helpDesk.domain.enums.SituacaoStatus;
import com.kata.helpDesk.services.ProdutoCosifService;

@RestController
@RequestMapping(value = "/produtosCosif")
public class ProdutoCosifResource {

	@Autowired
	private ProdutoCosifService service;

	@GetMapping(value = "/{idCosif}/{idProduto}")
	public ResponseEntity<ProdutoCosif> findById(
			@PathVariable(name = "idCosif") String idCosif,
			@PathVariable(name = "idProduto") String idProduto) {
		ProdutoCosifID id = new ProdutoCosifID(idCosif, new Produto(idProduto,null,SituacaoStatus.ATIVO) );
		ProdutoCosif obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoCosifDTO>> findAll(){
		List<ProdutoCosif> list = service.findAll();
		List<ProdutoCosifDTO> listDto = list.stream().map(obj -> new ProdutoCosifDTO(obj)).collect(Collectors.toList());
		return (ResponseEntity.ok().body(listDto));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoCosifDTO objDto ){
		ProdutoCosif newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getProdutoCosifID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoCosifDTO> update(@PathVariable ProdutoCosifIDDTO id, @Valid @RequestBody ProdutoCosifDTO objDto){
		
		ProdutoCosif obj = service.update(new ProdutoCosifID(id), objDto);
		return ResponseEntity.ok().body(new ProdutoCosifDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProdutoCosifDTO> delete(@PathVariable ProdutoCosifIDDTO id){
		service.delete(new ProdutoCosifID(id));
		return ResponseEntity.noContent().build();
	}
}
