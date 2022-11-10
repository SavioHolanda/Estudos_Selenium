#language: pt

@esse
Funcionalidade: Aprender cucumber
	Como um aluno
	Eu quero aprender a utilizar Cucumber
	Para que eu possa automatizar creitérios de aceitação

Cenario: Deve executara especificação
	Dado que criei o arquivo corretamente
	Quando executá-lo
	Então a especificação deve finalizar com sucesso
	
Cenario: Deve incrementar contador
	Dado que o valor do contator é 15
	Quando eu incrementar em 5
	Então o valor do contador será 20

Cenario: Deve calcular atraso na entrega
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 dias
	Então a entrega será efetuada dia "07/04/2018"
	
Cenario: Deve calcular atraso na entrega da china
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 meses
	Então a entrega será efetuada dia "05/06/2018"