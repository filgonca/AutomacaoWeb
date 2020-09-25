package br.com.web.pages;

import static br.com.web.core.DriverFactory.getDriver;
import static br.com.web.util.Parametros.criarNome;
import static br.com.web.util.Parametros.criarSenha;

import org.openqa.selenium.By;

import br.com.web.core.BasePage;

public class CadastrarUsuarioPage extends BasePage {

	// Elementos Web
	By linkCadastreSe = By.cssSelector("a[href*='signup']");
	By campoUsuario = By.cssSelector("input[name='username']");
	By campoSenha = By.cssSelector("input[name='pass']");
	By campoConfirmeSenha = By.cssSelector("input[name='confirmpass']");
	By botaoCadastrar = By.cssSelector("button[class*='login100']");
	By textoLogin = By.cssSelector("span[class*='login']");
	
	public void acessarSite() throws Exception {
		getDriver().get("http://www.inmrobo.tk/accounts/login/");
	}

	public void preencherDadosDeCadastro() {
		clicar(linkCadastreSe);
		escrever(campoUsuario, criarNome);
		escrever(campoSenha, criarSenha);
		escrever(campoConfirmeSenha, criarSenha);
		clicar(botaoCadastrar);
	}

	public void validarCadastroDeUsuario() {
		validarTexto("Login", textoLogin);
	}
}