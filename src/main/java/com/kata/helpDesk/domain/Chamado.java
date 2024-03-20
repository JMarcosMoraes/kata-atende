package com.kata.helpDesk.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.kata.helpDesk.domain.enums.Prioridade;
import com.kata.helpDesk.domain.enums.Status;

public class Chamado {
	
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento = LocalDate.now();
	private Prioridade prioridade;
	private Status status;
	private String tirulos;
	private String observacoes;
	
	private Tecnico tecnico;
	private Cliente cliente;
	public Chamado(Integer id, Prioridade prioridade, Status status, String tirulos, String observacoes,
			Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.tirulos = tirulos;
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
	public String getTirulos() {
		return tirulos;
	}
	public void setTirulos(String tirulos) {
		this.tirulos = tirulos;
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
				tirulos);
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
				&& Objects.equals(tirulos, other.tirulos);
	}
	
	
	
}
