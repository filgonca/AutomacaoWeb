package br.com.web.pages;

import static br.com.web.core.DriverFactory.getDriver;
import static br.com.web.util.Parametros.senhaCadastrada;
import static br.com.web.util.Parametros.usuarioCadastrado;

import org.openqa.selenium.By;

import br.com.web.core.BasePage;

public class LogarPage extends BasePage {
	
	// Elementos Web
	By campoUsuario = By.cssSelector("input[name='username']");
	By campoSenha = By.cssSelector("input[name='pass']");
	By botaoEntre = By.cssSelector("button[class*='login100']");
	By textoSair = By.cssSelector("a[href*='logout']");
	
	public void acessarSite() throws Exception {
		getDriver().get("http://www.inmrobo.tk/accounts/login/");
	}

	public void preencherDadosDeLogin() throws Exception {
		escrever(campoUsuario, usuarioCadastrado);
		escrever(campoSenha, senhaCadastrada);
		clicar(botaoEntre);
	}

	public void validarLogin() {
		validarTexto("SAIR", textoSair);
	}
}