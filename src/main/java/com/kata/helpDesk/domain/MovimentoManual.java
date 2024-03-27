package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
public class MovimentoManual implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MovimentoManualID MovimentoManualID;
	
	@Column(name = "DES_DESCRICAO")
	private String descricao;
	
	@Column(name = "DAT_MOVIMENTO")
	private LocalDate dataMovimento;
	
	@Column(name = "COD_USUARIO")
	private String cod_usuario;
	
	@Column(name = "VAL_VALOR")
	private Long valor;
	
	public MovimentoManual() {
		super();
	}
	
	public MovimentoManual(com.kata.helpDesk.domain.MovimentoManualID movimentoManualID, String descricao,
			LocalDate dataMovimento, Long valor) {
		super();
		MovimentoManualID = movimentoManualID;
		this.descricao = descricao;
		this.dataMovimento = dataMovimento;
		this.valor = valor;
	}



	public MovimentoManualID getMovimentoManualID() {
		return MovimentoManualID;
	}

	public void setMovimentoManualID(MovimentoManualID movimentoManualID) {
		MovimentoManualID = movimentoManualID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MovimentoManualID, dataMovimento, descricao, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoManual other = (MovimentoManual) obj;
		return Objects.equals(MovimentoManualID, other.MovimentoManualID)
				&& Objects.equals(dataMovimento, other.dataMovimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(valor, other.valor);
	}
	
}
