package br.com.web.steps;

import br.com.web.pages.CadastrarUsuarioPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastrarUsuarioSteps {

	private CadastrarUsuarioPage page = new CadastrarUsuarioPage();

	@Dado("^que um usuario acesse a plataforma inmrobo$")
	public void que_um_usuario_acesse_a_plataforma_inmrobo() throws Throwable {
		page.acessarSite();
	}

	@Quando("^realizar o cadastro de um novo usuario$")
	public void realizar_o_cadastro_de_um_novo_usuario() throws Throwable {
		page.preencherDadosDeCadastro();
	}

	@Entao("^um novo usuario sera cadastrado$")
	public void umNovoUsuarioSeraCadastrado() throws Throwable {
		page.validarCadastroDeUsuario();
	}
}