package com.kata.helpDesk.domain.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ProdutoCosifIDDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	private String codCosif;
	private ProdutoDTO produtoDTO;

	public ProdutoCosifIDDTO() {
		super();
	}

	public ProdutoCosifIDDTO(String codCosif, ProdutoDTO produtoDTO) {
		super();
		this.codCosif = codCosif;
		this.produtoDTO = produtoDTO;
	}

	public String getCodCosif() {
		return codCosif;
	}

	public void setCodCosif(String codCosif) {
		this.codCosif = codCosif;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}

	public void setProduto(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCosif, produtoDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCosifIDDTO other = (ProdutoCosifIDDTO) obj;
		return Objects.equals(codCosif, other.codCosif) && Objects.equals(produtoDTO, other.produtoDTO);
	}
	
	
	
	
}
