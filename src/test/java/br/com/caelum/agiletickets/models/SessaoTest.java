package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveReservarIngressoSeHaVaga() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVenderIngressoSeNaoHaVagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void deveDiminuirQuantidadeIngressosDisponiveisAposReserva() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveReservarMesmaQuantidadeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		
		sessao.setTotalIngressos(5);
		Assert.assertTrue(sessao.podeReservar(5));
	}
}
