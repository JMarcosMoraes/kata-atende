package com.kata.helpDesk.domain.enums;

public enum Status {
	BAIXA(0, "BAIXA"), MEDIO(1, "MEDIO"), ENCERRADO(2, "ALTA");

	private Integer codigo;
	private String descricao;

	Status(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade Inválido !!");
	}

}
