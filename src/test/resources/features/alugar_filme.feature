# language: pt

Funcionalidade: Alugar Filme
	Como um usuário
	Eu quero cadastrar alugueis de filmes
	Para controlar preços e datas de entrega
	
Cenario: Deve alugar um filme com sucesso
	Dado um filme com estoque de 2 unidades
	E o preço do aluguel seja R$ 3
	Quando alugar
	Então o preço do aluguel será R$ 3
	E a data de entrega será no dia seguinte
	E o o estoque do final sejá 1 unidade
	
@teste	
Cenario: Não deve alugar final sem estoque
	Dado um file com o estoque de 0 unidades
	Quando alugar
	Então não será possivel por falta de estoque
	E o estoque do filme será 0 unidades