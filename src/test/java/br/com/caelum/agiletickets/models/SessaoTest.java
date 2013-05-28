package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {
	private Sessao sessao;

	@Before
	public void setup(){
		this.sessao= new Sessao();
	}

	@Test
	public void deveReservarIngressoSeHaVaga() throws Exception {
		sessao.setTotalIngressos(2);

		Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVenderIngressoSeNaoHaVagas() throws Exception {
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void deveDiminuirQuantidadeIngressosDisponiveisAposReserva() throws Exception {
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}

	@Test
	public void deveReservarMesmaQuantidadeIngressosDisponiveis() throws Exception {		
		sessao.setTotalIngressos(5);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}
}
