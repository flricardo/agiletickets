package br.com.caelum.carrinho;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exemplo {

	@Test
	public void testa() throws Exception {
		WebDriver browser = new FirefoxDriver();
		browser.get("http://online.caelum.com.br");
		browser.findElement(By.name("email")).sendKeys("william.mizuta@caelum.com.br");
		browser.findElement(By.name("password")).sendKeys("1234567890");
		browser.findElement(By.className("form-login")).submit();
		WebElement e =browser.findElement(By.className("errors")).findElement(By.tagName("li"));
		Assert.assertTrue(e.getText().contains("inválida"));
	}
}