package br.com.web.steps;

import br.com.web.pages.LogarPage;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LogarSteps {

	private LogarPage page = new LogarPage();

	@Quando("^realizar o login de um usuario cadastrado$")
	public void realizar_o_login_de_um_usuario_cadastrado() throws Throwable {
		page.preencherDadosDeLogin();
	}

	@Entao("^sera exibida a pagina de registro de funcionarios$")
	public void sera_exibida_a_pagina_de_registro_de_funcionarios() throws Throwable {
		page.validarLogin();
	}
}	