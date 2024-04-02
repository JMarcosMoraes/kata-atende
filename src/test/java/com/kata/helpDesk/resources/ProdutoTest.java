package com.kata.helpDesk.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.helpDesk.domain.Produto;
import com.kata.helpDesk.domain.ProdutoCosif;
import com.kata.helpDesk.domain.ProdutoCosifID;
import com.kata.helpDesk.domain.enums.Classificacao;
import com.kata.helpDesk.domain.enums.SituacaoStatus;
import com.kata.helpDesk.repositories.ProdutoCosifRepository;
import com.kata.helpDesk.services.ProdutoCosifService;

@SpringBootTest
@AutoConfigureMockMvc
class ProdutoTest {

	/*
	 * @Autowired private MockMvc mockMvc;
	 */

	@InjectMocks
	ProdutoCosifService produtoCosifService;
	
	@Mock
	ProdutoCosifRepository produtoCosifRepository;
	
	@Test
	public void testGetProdutosCosifByCodigo() throws Exception {

		List<ProdutoCosif> mockProdutosCosif = Arrays.asList(
				new ProdutoCosif(new ProdutoCosifID("1", new Produto("", "", SituacaoStatus.ATIVO)), Classificacao.A1,
						SituacaoStatus.ATIVO),
				new ProdutoCosif(new ProdutoCosifID("2", new Produto("", "", SituacaoStatus.ATIVO)), Classificacao.A1,
						SituacaoStatus.ATIVO));
		when(produtoCosifRepository.findAll()).thenReturn(mockProdutosCosif);

		
		assertNotNull(produtoCosifService.findAll() != null);
		assertEquals(produtoCosifService.findAll().size(), 2);
		
		
		// Realize a solicitação GET para /api/produtos-cosif/{codigo} e verifique a
		// resposta
//		mockMvc.perform(get("/produtosCosif"))
//				.andExpect(status().isOk())
//				.andExpect((ResultMatcher) jsonPath("$", 2))
//				.andExpect(jsonPath("$[0].codigoCosif", is("COSIF1")))
//				.andExpect(jsonPath("$[1].codigoCosif", is("COSIF2")));

	}

	
}
