package com.kata.helpDesk.domain.enums;

public enum SituacaoStatus {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer codigo;
	private String descricao;


	private SituacaoStatus(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static SituacaoStatus toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (SituacaoStatus x : SituacaoStatus.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade Inválido !!");
	}

}
