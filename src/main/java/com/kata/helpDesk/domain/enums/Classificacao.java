package com.kata.helpDesk.domain.enums;

public enum Classificacao {
	A1(1,"ALTA"),
    B1(2,"MEDIA"),
    C1(3,"BAIXA");
	
	private Integer codigo;
	private String descricao;

	private Classificacao(Integer codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Classificacao toEnum(char cod) {
		for (Classificacao x : Classificacao.values()) {
			if (cod == x.getCodigo()) {
				return x;
			}
		}
		throw new IllegalArgumentException("Classificação Inválido !!");
	}
	
}
