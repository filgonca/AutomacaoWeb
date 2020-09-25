package br.com.web.steps;

import br.com.web.pages.CRUDFuncionarioPage;
import br.com.web.pages.LogarPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CRUDFuncionarioSteps {

	private CRUDFuncionarioPage page = new CRUDFuncionarioPage();
	private LogarPage log = new LogarPage();

	@Dado("^que um usuario esteja logado na plataforma inmrobo$")
	public void que_um_usuario_esteja_logado_na_plataforma_inmrobo() throws Throwable {
		log.acessarSite();
		log.preencherDadosDeLogin();
	}

	@Quando("^cadastrar um novo funcionario$")
	public void cadastrar_um_novo_funcionario() throws Throwable {
		page.cadastrarFuncionario();
	}

	@Entao("^sera exibida uma mensagem de cadastrado com sucesso$")
	public void sera_exibida_uma_mensagem_de_cadastrado_com_sucesso() throws Throwable {
		page.validarCadastroDeFuncionario();
	}

	@Quando("^pesquisar um funcionario existente$")
	public void pesquisar_um_funcionario_existente() throws Throwable {
		page.pesquisarFuncionario();
	}

	@Entao("^sera exibido o registro do funcionario$")
	public void sera_exibido_o_registro_do_funcionario() throws Throwable {
		page.validarPesquisaDeFuncionario();
	}

	@Quando("^editar um funcionario$")
	public void editar_um_funcionario() throws Throwable {
		page.editarFuncionario();
	}

	@Entao("^sera exibida uma mensagem de atualizacao com sucesso$")
	public void sera_exibida_uma_mensagem_de_atualizacao_com_sucesso() throws Throwable {
		page.validarEdicaoDeFuncionario();
	}

	@Quando("^excluir um funcionario$")
	public void excluir_um_funcionario() throws Throwable {
		page.excluirFuncionario();
	}

	@Entao("^sera exibida uma mensagem de excluido com sucesso$")
	public void sera_exibida_uma_mensagem_de_excluido_com_sucesso() throws Throwable {
		page.validarExclusaoDeFuncionario();
	}
}		