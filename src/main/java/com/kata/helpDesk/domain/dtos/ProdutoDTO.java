package com.kata.helpDesk.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.kata.helpDesk.domain.Produto;
import com.kata.helpDesk.domain.enums.SituacaoStatus;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	protected String cod;
	
	@NotNull(message = "O campo Descrição é requerido")
	private String descricao;
	
	@NotNull(message = "O campo Status é requerido")
	private SituacaoStatus status;

	public ProdutoDTO() {
		super();
		this.status = SituacaoStatus.INATIVO;
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.cod = obj.getCod();
		this.descricao = obj.getDescricao();
		this.status = SituacaoStatus.toEnum(obj.getStatus());
	}

	public String getCod() {
		return cod;
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

	public SituacaoStatus getStatus() {
		return status;
	}

	public void setStatus(SituacaoStatus status) {
		this.status = status;
	}
	
	
	
}
