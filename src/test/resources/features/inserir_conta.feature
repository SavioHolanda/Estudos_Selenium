#language: pt
@esse
Funcionalidade: Cadastro de contas

	Como um usuário 
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Contexto:
  Dado que desejo adicionar uma conta

Cenário: Deve inserir uma conta com sucesso
	E informo a conta "conta3"
	Então a conta é inserida com sucesso

Cenário: Não deve inserir uma conta sem nome
  E informo a conta ""
	Então sou notificado que o nome da conta é obrigatório

Cenário: Não deve inserir uma conta com nome já existente
	E informo a conta "Conta para saldo"
	Então sou notificado que já existe uma conta com esse nome