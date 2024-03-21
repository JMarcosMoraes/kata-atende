package com.kata.helpDesk.domain.enums;

public enum Prioridade {
	BAIXA(0, "BAIXA"), MEDIO(1, "MEDIO"), ENCERRADO(2, "ALTA");
	

	private Integer codigo;
	private String descricao;

	Prioridade(int i, String string) {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status Inválido !!");
	}

}
