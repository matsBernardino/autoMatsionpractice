Feature: 001 - Realizar Compra com Sucesso 
	Pagamento via transferencia
Scenario: 001 - Realizar Compra com Sucesso 

	Given acesso o site 
	And escolho o produto 
	And adiciono o produto escolhido ao carrinho 
	And realizo o checkout 
	And valido se o produto foi corretamente adicionado ao carrinho 
	And realizo cadastro 
	And valido se o endereco esta correto 
	And aceito os termos de servico 
	And valido o valor total da compra 
	And seleciono o metodo de pagamento por transferencia 
	And confirmo a compra 
	Then valide se foi finalizada com sucesso via transferencia