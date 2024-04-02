package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.kata.helpDesk.domain.dtos.ProdutoCosifDTO;
import com.kata.helpDesk.domain.enums.Classificacao;
import com.kata.helpDesk.domain.enums.SituacaoStatus;

@Entity()
@Table(name = "PRODUTO_COSIF")
public class ProdutoCosif implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProdutoCosifID produtoCosifID; 
	
	@Column(name = "COD_CLASSIFICACAO", length = 6)
	@NotNull
	private String codClassificacao;
	
	@Column(name = "STA_STATUS", length = 1)
	@NotNull
	private char situacaoStatus;

	public ProdutoCosif() {
		super();
	}

	public ProdutoCosif(ProdutoCosifID produtoCosifID, @NotNull Classificacao classificacao, @NotNull SituacaoStatus situacaoStatus) {
		super();
		this.produtoCosifID = produtoCosifID;
		this.codClassificacao = classificacao.getDescricao();
		this.situacaoStatus = situacaoStatus.getCodigo();
		
	}
	
	public ProdutoCosif(ProdutoCosifDTO objDto) {
		super();
		ModelMapper modelMapper = new ModelMapper();
		this.produtoCosifID = modelMapper.map(objDto.getProdutoCosifID(), ProdutoCosifID.class);
		this.produtoCosifID.setProduto(modelMapper.map(objDto.getProdutoCosifID().getProdutoDTO(), Produto.class));
		this.codClassificacao = objDto.getCodClassificacao();
		this.situacaoStatus = SituacaoStatus.NOVO.getCodigo();
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

	public char getSituacaoStatus() {
		return situacaoStatus;
	}

	public void setSituacaoStatus(char situacaoStatus) {
		this.situacaoStatus = situacaoStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codClassificacao, produtoCosifID, situacaoStatus);
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
				&& Objects.equals(produtoCosifID, other.produtoCosifID) && situacaoStatus == other.situacaoStatus;
	}
	
}
