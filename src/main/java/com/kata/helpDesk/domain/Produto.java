package com.kata.helpDesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	
	@Id
	@Column(name = "COD_PRODUTO")
	private String cod;
	
	@Column(name = "DES_PRODUTO")
	@NotNull
	private String descricao;
	
	@Column(name = "STA_STATUS")
	@NotNull
	private char status;

	public String getCod() {
		return cod;
	}
	
	public Produto() {
		super();
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
