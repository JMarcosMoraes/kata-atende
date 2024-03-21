package com.kata.helpDesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.helpDesk.domain.enums.Prioridade;
import com.kata.helpDesk.domain.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity()
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento = LocalDate.now();

	private Prioridade prioridade;
	private Status status;

	private String titulos;
	private String observacoes;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Chamado(Integer id, Prioridade prioridade, Status status, String tirulos, String observacoes,
			Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulos = tirulos;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulos() {
		return titulos;
	}

	public void setTitulos(String titulos) {
		this.titulos = titulos;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataAbertura, dataFechamento, id, observacoes, prioridade, status, tecnico,
				titulos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataAbertura, other.dataAbertura)
				&& Objects.equals(dataFechamento, other.dataFechamento) && Objects.equals(id, other.id)
				&& Objects.equals(observacoes, other.observacoes) && prioridade == other.prioridade
				&& status == other.status && Objects.equals(tecnico, other.tecnico)
				&& Objects.equals(titulos, other.titulos);
	}

}
