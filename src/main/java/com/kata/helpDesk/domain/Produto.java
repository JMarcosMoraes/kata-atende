package com.kata.helpDesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.kata.helpDesk.domain.dtos.ProdutoDTO;
import com.kata.helpDesk.domain.enums.SituacaoStatus;

@Entity
public class Produto {

	@Id
	@Column(name = "COD_PRODUTO", length = 4)
	private String cod;

	@Column(name = "DES_PRODUTO", length = 30)
	@NotNull
	private String descricao;

	@Column(name = "STA_STATUS", length = 1)
	@NotNull
	private char status;

	public String getCod() {
		return cod;
	}

	public Produto() {
		super();
	}

	public Produto(ProdutoDTO objDto) {
		this.cod = objDto.getCod();
		this.descricao = objDto.getDescricao();
		this.status = objDto.getStatus().getCodigo();
	}

	public Produto(String cod, String descricao, SituacaoStatus status) {
		super();
		this.cod = cod;
		this.descricao = descricao;
		this.status = status.getCodigo();
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}
