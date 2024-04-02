package com.kata.helpDesk.domain.enums;

public enum SituacaoStatus {
	ATIVO('A'),
	INATIVO('I'),
	EM_REVISAO('R'),
	NOVO('N');

	private char codigo;

	private SituacaoStatus(char codigo) {
		this.codigo = codigo;
	}

	public char getCodigo() {
		return codigo;
	}

	public static SituacaoStatus toEnum(char cod) {
		for (SituacaoStatus x : SituacaoStatus.values()) {
			if (cod == x.getCodigo()) {
				return x;
			}
		}
		throw new IllegalArgumentException("Situação Status Inválido !!");
	}

}
