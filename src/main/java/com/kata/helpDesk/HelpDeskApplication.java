package com.kata.helpDesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kata.helpDesk.domain.Chamado;
import com.kata.helpDesk.domain.Cliente;
import com.kata.helpDesk.domain.Tecnico;
import com.kata.helpDesk.domain.enums.Perfil;
import com.kata.helpDesk.domain.enums.Prioridade;
import com.kata.helpDesk.domain.enums.Status;
import com.kata.helpDesk.repositories.ChamadoRepository;
import com.kata.helpDesk.repositories.ClienteRepository;
import com.kata.helpDesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpDeskApplication implements CommandLineRunner{

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tech1 = new Tecnico(null, "Marcos", "03648469681", "teste@teste.com", "123");
		tech1.addPerfi(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linux", "03648469682", "teste@teste", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIO, Status.ANDAMENTO, "chamado 01", "Primeiro Chamado", tech1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tech1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
