package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProdutoCosifID  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "COD_COSIF")
	private String codCosif;
		
	@ManyToOne
	@JoinColumn(name = "COD_PRODUTO")
	private Produto produto;

	public ProdutoCosifID() {
		super();
	}

	public ProdutoCosifID(String codCosif, Produto produto) {
		super();
		this.codCosif = codCosif;
		this.produto = produto;
	}

	public String getCodCosif() {
		return codCosif;
	}

	public void setCodCosif(String codCosif) {
		this.codCosif = codCosif;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCosif, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCosifID other = (ProdutoCosifID) obj;
		return Objects.equals(codCosif, other.codCosif) && Objects.equals(produto, other.produto);
	}
	
	
	
	
}
