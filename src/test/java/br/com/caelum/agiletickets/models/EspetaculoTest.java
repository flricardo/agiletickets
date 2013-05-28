package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.joda.time.DateTimeField;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void deveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void deveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void insereUmaSessaoEspetaculoDiario() throws Exception {		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2013,6,1);
		LocalDate termino = new LocalDate(2013,6,1);
		LocalTime horario = new LocalTime(21,0);
		
		List<Sessao> listaSessoes = espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.DIARIA);
		Assert.assertEquals(listaSessoes.size(), 1);
		
	}
	
	@Test
	public void testaQuantidadeSessoesPeriodicidadeDiario() throws Exception {		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate().minusDays(2);
		LocalDate termino = new LocalDate();
		LocalTime horario = new LocalTime(21,0);
		
		List<Sessao> listaSessoes = espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.DIARIA);
		Assert.assertEquals(3, listaSessoes.size());
		
	}
	
	@Test
	public void testaSessoesDataCorretaPeriodicidadeDiario() throws Exception {		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate().minusDays(1);
		LocalDate termino = new LocalDate();
		LocalTime horario = new LocalTime(21,0);
		
		List<Sessao> listaSessoes = espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.DIARIA);
		Sessao sessao1 = listaSessoes.get(0);
		Sessao sessao2 = listaSessoes.get(1);
		
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
		Assert.assertEquals(termino.toDateTime(horario), sessao2.getInicio());
	}
	
	@Test
	public void testaQuantidadeSessoesPeriodicidadeSemanal() throws Exception {		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate().minusDays(14);
		LocalDate termino = new LocalDate();
		LocalTime horario = new LocalTime(21,0);
		
		List<Sessao> listaSessoes = espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.SEMANAL);
		Assert.assertEquals(3, listaSessoes.size());
		
	}
	
	@Test
	public void testaSessoesDataCorretaPeriodicidadeSemanal() throws Exception {		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate().minusDays(7);
		LocalDate termino = new LocalDate();
		LocalTime horario = new LocalTime(21,0);
		
		List<Sessao> listaSessoes = espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.SEMANAL);
		Sessao sessao1 = listaSessoes.get(0);
		Sessao sessao2 = listaSessoes.get(1);
		
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
		Assert.assertEquals(termino.toDateTime(horario), sessao2.getInicio());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testaSeDataInicioAnteriorDataFim() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate().plusDays(1);
		LocalDate termino = new LocalDate();
		LocalTime horario = new LocalTime(21,0);

		espetaculo.criaSessoes(inicio, termino, horario, Periodicidade.DIARIA);
	}
}
