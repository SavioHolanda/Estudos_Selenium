#language: pt

@criarUsuario
Funcionalidade: Realizar o cadastro do usuário invalido

Esquema do Cenário:  Validar campos nome, email e senha obrigatórios
Dado que estou na tela de cadastro de usuario
Quando  não preencho os campos Nome "", Email "" e Senha ""
E clico em cadastrar
Então o sistema apresenta a mensagem "<campo>"" é um campo obrigatório"

Exemplos: 
| campo |
| Nome  |
| Email |
| Senha |

Cenario: Criar login com um email invalido
Dado que estou na tela de cadastro de usuario
Quando que informo o Nome "a", Email "a" e Senha "a"
E clico em cadastrar
Então recebo uma mensagem no campo de email invalido

Cenario: Cadastrar com um email já cadastrado
Dado que estou na tela de cadastro de usuario
Quando que informo o Nome "a@a", Email "a@a" e Senha "a"
E clico em cadastrar
Então recebo a mensagem "Endereço de email já utilizado"
