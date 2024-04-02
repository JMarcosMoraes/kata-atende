package com.kata.helpDesk.domain.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.enums.SituacaoStatus;

public class ProdutoCosifDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private ProdutoCosifIDDTO produtoCosifIDDTO;
	
	@NotNull(message = "O campo Cod Classificação é requerido")
	private String codClassificacao;
	
	//@NotNull(message = "O campo Situação Status é requerido")
	private SituacaoStatus situacaoStatus;

	public ProdutoCosifDTO() {
		super();
	}
	
	public ProdutoCosifDTO(ProdutoCosifIDDTO produtoCosifID,
			String codClassificacao) {
		super();
		this.produtoCosifIDDTO = produtoCosifID;
		this.codClassificacao = codClassificacao;
		this.situacaoStatus = SituacaoStatus.NOVO;
	}
	
	public ProdutoCosifDTO(ProdutoCosif obj) {
		super();
		this.produtoCosifIDDTO = new ProdutoCosifIDDTO();
		this.produtoCosifIDDTO.setCodCosif(obj.getProdutoCosifID().getCodCosif());
		this.produtoCosifIDDTO.setProduto(new ProdutoDTO(obj.getProdutoCosifID().getProduto()));
		this.codClassificacao = obj.getCodClassificacao();
		this.situacaoStatus = SituacaoStatus.toEnum(obj.getSituacaoStatus());
	}

	public ProdutoCosifIDDTO getProdutoCosifID() {
		return produtoCosifIDDTO;
	}

	public void setProdutoCosifID(ProdutoCosifIDDTO produtoCosifID) {
		this.produtoCosifIDDTO = produtoCosifID;
	}

	public String getCodClassificacao() {
		return codClassificacao;
	}

	public void setCodClassificacao(String codClassificacao) {
		this.codClassificacao = codClassificacao;
	}

	public SituacaoStatus getSituacaoStatus() {
		return situacaoStatus;
	}

	public void setSituacaoStatus(SituacaoStatus situacaoStatus) {
		this.situacaoStatus = situacaoStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codClassificacao, produtoCosifIDDTO, situacaoStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCosifDTO other = (ProdutoCosifDTO) obj;
		return Objects.equals(codClassificacao, other.codClassificacao)
				&& Objects.equals(produtoCosifIDDTO, other.produtoCosifIDDTO) && situacaoStatus == other.situacaoStatus;
	}
	
	
}
