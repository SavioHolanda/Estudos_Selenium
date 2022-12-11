#language: pt

Funcionalidade: Cadastro de contas

	Como um usuário 
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada
	
Contexto:
  Dado que desejo logar no sistema
  
Cenário: Deve inserir uma conta com sucesso
	E informo a conta "conta5"
	Então a conta é inserida com sucesso
@Essa
Cenário: Não deve inserir uma conta sem nome
  E informo a conta " "
	Então sou notificado que o nome da conta é obrigatório

Cenário: Não deve inserir uma conta com nome já existente
	E informo a conta "Conta para saldo"
	Então sou notificado que já existe uma conta com esse nome