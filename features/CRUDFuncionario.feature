#language: pt
Funcionalidade: CRUD de Funcionario

	Contexto: 
    Dado que um usuario esteja logado na plataforma inmrobo
	
	@funcionario @cadastrar
  Cenario: Cadastrar funcionario
    Quando cadastrar um novo funcionario
    Entao sera exibida uma mensagem de cadastrado com sucesso
   
	@funcionario @pesquisar
  Cenario: Pesquisar funcionario
    Quando pesquisar um funcionario existente
    Entao sera exibido o registro do funcionario
  
	@funcionario @editar    
  Cenario: Editar funcionario
    Quando editar um funcionario
    Entao sera exibida uma mensagem de atualizacao com sucesso
  
  @funcionario @excluir
  Cenario: Excluir funcionario
    Quando excluir um funcionario
    Entao sera exibida uma mensagem de excluido com sucesso