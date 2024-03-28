package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class MovimentoManualID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DAT_MES")
	@NotNull
	private Integer dataMes;

	@Column(name = "DAT_ANO")
	@NotNull
	private Integer dataAno;

	@Column(name = "NUM_LANCAMENTO")
	@NotNull
	private Integer numeroLancamento;

	@OneToOne
	@JoinColumn(name = "COD_PRODUTO")
	@NotNull
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "COD_COSIF", insertable = false, updatable = false)
	@JoinColumn(name = "COD_PROD", insertable = false, updatable = false)
	@NotNull
	private ProdutoCosif produtoCosif;

	public MovimentoManualID() {
		super();
	}

	public MovimentoManualID(@NotNull Integer dataMes, @NotNull Integer dataAno, @NotNull Integer numeroLancamento,
			@NotNull Produto produto, @NotNull ProdutoCosif produtoCosif) {
		super();
		this.dataMes = dataMes;
		this.dataAno = dataAno;
		this.numeroLancamento = numeroLancamento;
		this.produto = produto;
		this.produtoCosif = produtoCosif;
	}

	public Integer getDataMes() {
		return dataMes;
	}

	public void setDataMes(Integer dataMes) {
		this.dataMes = dataMes;
	}

	public Integer getDataAno() {
		return dataAno;
	}

	public void setDataAno(Integer dataAno) {
		this.dataAno = dataAno;
	}

	public Integer getNumeroLancamento() {
		return numeroLancamento;
	}

	public void setNumeroLancamento(Integer numeroLancamento) {
		this.numeroLancamento = numeroLancamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoCosif getProdutoCosif() {
		return produtoCosif;
	}

	public void setProdutoCosif(ProdutoCosif produtoCosif) {
		this.produtoCosif = produtoCosif;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAno, dataMes, numeroLancamento, produtoCosif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoManualID other = (MovimentoManualID) obj;
		return Objects.equals(dataAno, other.dataAno) && Objects.equals(dataMes, other.dataMes)
				&& Objects.equals(numeroLancamento, other.numeroLancamento)
				&& Objects.equals(produtoCosif, other.produtoCosif);
	}
	
}
