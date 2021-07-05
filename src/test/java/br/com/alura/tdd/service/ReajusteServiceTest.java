package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("2000.00"));
	}

	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		inicializar();
		service.concederReajuste(funcionario,  Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
	}
	
}
