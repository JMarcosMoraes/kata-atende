package com.kata.helpDesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kata.helpDesk.domain.Chamado;
import com.kata.helpDesk.domain.Cliente;
import com.kata.helpDesk.domain.Produto;
import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.ProdutoCosifID;
import com.kata.helpDesk.domain.Tecnico;
import com.kata.helpDesk.domain.enums.Classificacao;
import com.kata.helpDesk.domain.enums.Perfil;
import com.kata.helpDesk.domain.enums.Prioridade;
import com.kata.helpDesk.domain.enums.SituacaoStatus;
import com.kata.helpDesk.domain.enums.Status;
import com.kata.helpDesk.repositories.ChamadoRepository;
import com.kata.helpDesk.repositories.PessoaRepository;
import com.kata.helpDesk.repositories.ProdutoCosifRepository;
import com.kata.helpDesk.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoCosifRepository produtoCosifRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;


	public void instanciaDB() {
		Tecnico tech1 = new Tecnico(null,"Marcos", "123.456.789-09", "teste@teste.com", encoder.encode("123"));
		tech1.addPerfil(Perfil.ADMIN);
		tech1.addPerfil(Perfil.CLIENTE);

		Cliente cli1 = new Cliente(null,"Linux", "123.456.789-10", "teste@teste", encoder.encode("123"));

		Chamado c1 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "Primeiro chamado", tech1,
				cli1);

		pessoaRepository.saveAll(Arrays.asList(tech1));
		pessoaRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		Tecnico tec1 = new Tecnico(null,"Valdir Cezar", "550.482.150-95", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null,"Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null,"Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null,"Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null,"Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

		Cliente cli6 = new Cliente(null,"Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null,"Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null,"Charles Darwin", "792.043.830-62", "darwin@mail.com",encoder.encode("123"));
		Cliente cli4 = new Cliente(null,"Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null,"Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
 
		Chamado c7 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO, "chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null,Prioridade.ALTA, Status.ABERTO, "chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null,Prioridade.BAIXA, Status.ENCERRADO, "chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null,Prioridade.ALTA, Status.ABERTO, "chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO, "chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null,Prioridade.BAIXA, Status.ENCERRADO, "chamado 7", "Teste chamado 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6,c7));
		
		Produto prod1 = new Produto("1","Credito Pessoal", SituacaoStatus.ATIVO);
		Produto prod2 = new Produto("2","Financiamento Imobiliario", SituacaoStatus.ATIVO);
		Produto prod3 = new Produto("3","Financiamento Auto", SituacaoStatus.ATIVO);
		Produto prod4 = new Produto("4","Financiamento Agricula", SituacaoStatus.INATIVO);
		Produto prod5 = new Produto("5","Crédito FGTS", SituacaoStatus.INATIVO);
		Produto prod6 = new Produto("6","PIX Parcelado", SituacaoStatus.INATIVO);
		Produto prod7 = new Produto("7","Cadstro Positivo", SituacaoStatus.EM_REVISAO);
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7));
		
		ProdutoCosifID cosifID_1 = new ProdutoCosifID("1", prod1);
		ProdutoCosif prodCosif1 = new ProdutoCosif(cosifID_1,Classificacao.A1,SituacaoStatus.ATIVO);
		
		ProdutoCosifID cosifID_2 = new ProdutoCosifID("2", prod1);
		ProdutoCosif prodCosif2 = new ProdutoCosif(cosifID_2,Classificacao.B1,SituacaoStatus.INATIVO);
		
		ProdutoCosifID cosifID_3 = new ProdutoCosifID("2", prod2);
		ProdutoCosif prodCosif3 = new ProdutoCosif(cosifID_3,Classificacao.C1,SituacaoStatus.EM_REVISAO);
		
		
		produtoCosifRepository.saveAll(Arrays.asList(prodCosif1,prodCosif2,prodCosif3));
		
		
	}

}
