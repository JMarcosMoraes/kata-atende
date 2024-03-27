package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "PRODUTO_COSIF")
public class ProdutoCosif implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoCosifID produtoCosifID; 
	
	@Column(name = "COD_CLASSIFICACAO")
	@NotNull
	private String codClassificacao;
	
	@Column(name = "STA_STATUS")
	@NotNull
	private char status;

	public ProdutoCosif() {
		super();
	}

	public ProdutoCosif(ProdutoCosifID produtoCosifID, @NotNull String codClassificacao, @NotNull char status) {
		super();
		this.produtoCosifID = produtoCosifID;
		this.codClassificacao = codClassificacao;
		this.status = status;
	}

	public ProdutoCosifID getProdutoCosifID() {
		return produtoCosifID;
	}

	public void setProdutoCosifID(ProdutoCosifID produtoCosifID) {
		this.produtoCosifID = produtoCosifID;
	}

	public String getCodClassificacao() {
		return codClassificacao;
	}

	public void setCodClassificacao(String codClassificacao) {
		this.codClassificacao = codClassificacao;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codClassificacao, produtoCosifID, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCosif other = (ProdutoCosif) obj;
		return Objects.equals(codClassificacao, other.codClassificacao)
				&& Objects.equals(produtoCosifID, other.produtoCosifID) && status == other.status;
	}
	
	
	
	
	
}
