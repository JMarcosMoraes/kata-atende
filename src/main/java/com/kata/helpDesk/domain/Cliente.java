package com.kata.helpDesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kata.helpDesk.domain.dtos.ClienteDTO;
import com.kata.helpDesk.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(Perfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
