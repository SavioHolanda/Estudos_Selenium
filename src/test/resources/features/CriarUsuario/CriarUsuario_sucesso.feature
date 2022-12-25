#language: pt

@criarUsuario
Funcionalidade: Realizar o cadastro do usuário com sucesso

Cenario: realizar cadastro com sucesso
Dado que estou na tela de cadastro de usuario
Quando preencho os campos Nome "Teste Cadastro ", Email "@teste.com " e Senha "123" corretamente
E clico em cadastrar
Então o usuário é cadastrado com sucesso sendo apresentando a mensagem "Usuário inserido com sucesso"