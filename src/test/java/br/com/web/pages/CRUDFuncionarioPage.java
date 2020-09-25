package br.com.web.pages;

import static br.com.web.util.Parametros.admissao;
import static br.com.web.util.Parametros.cargo;
import static br.com.web.util.Parametros.criarNome;
import static br.com.web.util.Parametros.salario;
import static br.com.web.util.Parametros.sexo;

import org.openqa.selenium.By;

import br.com.web.core.BasePage;
import br.com.web.util.GeradorCPF;

public class CRUDFuncionarioPage extends BasePage {
	
	private GeradorCPF page = new GeradorCPF();

	// Elementos Web
	// Cadastrar
	By linkNovoFuncionario = By.cssSelector("a[href*='new']");
	By campoNome = By.id("inputNome");
	By campoCPF = By.id("cpf");
	By campoSexo = By.id("slctSexo");
	By campoAdmissao = By.id("inputAdmissao");
	By campoCargo = By.id("inputCargo");
	By campoSalario = By.id("dinheiro");
	By radiobtnCLT = By.id("clt");
	By botaoEnviar = By.cssSelector("input[class*='cadastrar']");
	By textoCadastradoSucesso = By.cssSelector("div[class*='success']");
	// Pesquisar
	By campoPesquisar = By.cssSelector("input[type='search']");
	By textoRetornoPesquisa = By.cssSelector("td[class*='sorting_1']");
	// Editar
	By iconeLapis = By.cssSelector("span[class*='pencil']");
	By textoEdicaoSucesso = By.cssSelector("div[class*='success']");
	// Excluir
	By iconeExcluir = By.cssSelector("span[class*='trash']");
	By textoExclusaoSucesso = By.cssSelector("div[class*='success']");
	
	public void cadastrarFuncionario() throws Exception {
		clicar(linkNovoFuncionario);
		escrever(campoNome, criarNome);
		escrever(campoCPF, page.geraCPF());
		escrever(campoSexo, sexo);
		escrever(campoAdmissao, admissao);
		escrever(campoCargo, cargo);
		escrever(campoSalario, salario);
		clicar(radiobtnCLT);
		clicar(botaoEnviar);
	}

	public void validarCadastroDeFuncionario() {
		verificarElementoVisivel(textoCadastradoSucesso);
	}

	public void pesquisarFuncionario() {
		escrever(campoPesquisar, "paladino");
	}

	public void validarPesquisaDeFuncionario() {
		verificarElementoVisivel(textoRetornoPesquisa);
	}

	public void editarFuncionario() throws Exception {
		clicar(iconeLapis);
		limparCampo(campoNome);
		escrever(campoNome, criarNome);
		clicar(botaoEnviar);
	}

	public void validarEdicaoDeFuncionario() {
		verificarElementoVisivel(textoEdicaoSucesso);
		escrever(campoPesquisar, criarNome);
		validarTexto(criarNome, textoRetornoPesquisa);
	}

	public void excluirFuncionario() {
		clicar(iconeExcluir);
	}

	public void validarExclusaoDeFuncionario() {
		verificarElementoVisivel(textoExclusaoSucesso);
	}
}