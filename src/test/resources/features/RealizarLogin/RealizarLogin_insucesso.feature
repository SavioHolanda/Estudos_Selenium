#language: pt
@RealizarLogin
Funcionalidade: Realizar login invalido

	Como um usuário 
	Gostaria de realizar login
	Com intuído de acessar a pagina principal.

Cenario: Realizar login com usuário invalido
Dado que informo o "b@bxxx" e "b"
Quando clico no botão entrar
Então recebo uma critica de login invalido

Cenario: Realizar login sem login e senha
Dado que informo o "" e ""
Quando clico no botão entrar
Então recebo uma critica de campos obrigatórios

Cenario: Realizar login com um email invalido
Dado que informo o "a" e "a"
Quando clico no botão entrar
Então recebo uma critica no campo de email invalido