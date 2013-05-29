package br.com.caelum.carrinho;

import junit.framework.Assert;

import org.junit.Test;

public class CarrinhoTest {
	@Test
	public void devolveMaiorValorComUmProduto() throws Exception {
		Carrinho c = new Carrinho(new Produto(10.0));
		double v = c.maisCaro();
		Assert.assertEquals(10.0, v, 0.001);
	}
	
	@Test
	public void devolveMaiorValorComMaisDeUmProduto() throws Exception {
		Carrinho c = new Carrinho(new Produto(10.0));
		c.insere(new Produto(20.0));
		c.insere(new Produto(5.0));
		double v = c.maisCaro();
		Assert.assertEquals(20.0, v, 0.001);
	}
}
