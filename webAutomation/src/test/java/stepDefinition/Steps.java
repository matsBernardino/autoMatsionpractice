package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excelManager.TestData;
import pageObject.Address;
import pageObject.Cart;
import pageObject.Home;
import pageObject.Payment;
import pageObject.Shipping;
import pageObject.SingIn;
import utilities.Utils;

public class Steps extends Utils {
	TestData data;
	Home home;
	Cart cart;
	SingIn singin;
	Address address;
	Shipping shipping;
	Payment payment = new Payment();

	public Steps() {
		data = BeforeAfter.activeData;
		home = new Home();
		cart = new Cart();
		singin = new SingIn();
		address = new Address();
		shipping = new Shipping();

	}

	@Given("^acesso o site$")
	public void acesso_o_site() throws Throwable {
		maximizar();
		acessar(data.getSite());
	}

	@When("^escolho o produto$")
	public void escolho_o_produto() throws Throwable {
		focar(home.roupa());
	}

	@When("^adiciono o produto escolhido ao carrinho$")
	public void adiciono_o_produto_escolhido_ao_carrinho() throws Throwable {
		clicar(home.botaoAddToCart());
	}

	@When("^realizo o checkout$")
	public void realizo_o_checkout() throws Throwable {
		clicar(home.botaoProceedToCheckout());
	}

	@When("^valido se o produto foi corretamente adicionado ao carrinho$")
	public void valido_se_o_produto_foi_corretamente_adicionado_ao_carrinho() throws Throwable {
		validar(cart.labelProduto(), data.getProduto());
		clicar(cart.botaoProceedToCheckout());
	}

	@When("^realizo cadastro$")
	public void realizo_cadastro() throws Throwable {
		preencher(singin.campoEmail(), data.getEmail());
		clicar(singin.botaoCreateAnAccount());

		if (data.getGenero().toLowerCase().contentEquals(("masculino"))) {
			clicar(singin.radioMasculino());
		} else if (data.getGenero().toLowerCase().contentEquals(("feminino"))) {
			clicar(singin.radioFeminino());
		}

		preencher(singin.nome(), data.getNome());
		preencher(singin.sobrenome(), data.getSobrenome());
		preencher(singin.senha(), data.getSenha());

		selecionar(singin.diaNascimento(), getStringDia(data.getDataNascimento()));
		selecionar(singin.mesNascimento(), getStringMes(data.getDataNascimento()));
		selecionar(singin.anoNascimento(), getStringAno(data.getDataNascimento()));

		preencher(singin.nomeEntrega(), data.getNomeEntrega());
		preencher(singin.sobrenomeEntrega(), data.getSobrenomeEntrega());
		preencher(singin.empresa(), data.getEmpresa());
		preencher(singin.endereco(), data.getEndereco());
		preencher(singin.cidade(), data.getCidade());

		selecionar(singin.estado(), data.getEstado());

		preencher(singin.codigoPostal(), data.getCodigoPostal());

		selecionar(singin.pais(), data.getPais());

		preencher(singin.informacaoAdicional(), data.getInformacaoAdicional());
		preencher(singin.telefone(), data.getTelefone());
		preencher(singin.enderecoReferencia(), data.getEndereçoReferencia());

		clicar(singin.botaoSubmitAccount());

	}

	@When("^valido se o endereco esta correto$")
	public void valido_se_o_endereco_esta_correto() throws Throwable {

		validar(address.labelNomeEntrega(), data.getNomeEntrega() + " " + data.getSobrenomeEntrega());
		validar(address.labelEmpresaEntrega(), data.getEmpresa());
		validar(address.labelEnderecoEntrega(), data.getEndereco());
		validar(address.labelEstadoCidadeCodigoPostalEntrega(),
				data.getCidade() + ", " + data.getEstado() + " " + data.getCodigoPostal());

		validar(address.labelPaisEntrega(), data.getPais());
		validar(address.labelTelefoneEntrega(), data.getTelefone());

		validar(address.labelNomeFaturamento(), data.getNomeEntrega() + " " + data.getSobrenomeEntrega());
		validar(address.labelEmpresaFaturamento(), data.getEmpresa());
		validar(address.labelEnderecoFaturamento(), data.getEndereçoReferencia());
		validar(address.labelEstadoCidadeCodigoPostalFaturamento(),
				data.getCidade() + ", " + data.getEstado() + " " + data.getCodigoPostal());

		validar(address.labelPaisFaturamento(), data.getPais());
		validar(address.labelTelefoneFaturamento(), data.getTelefone());

		clicar(address.botaoProceedocheckout());

	}

	@When("^aceito os termos de servico$")
	public void aceito_os_termos_de_servico() throws Throwable {
		marcar(shipping.checkBoxTermsOfService());
		clicar(shipping.botaoProceedocheckout());
	}

	@When("^valido o valor total da compra$")
	public void valido_o_valor_total_da_compra() throws Throwable {
		validar(payment.labelValorTotal(), data.getValorTotal());
	}

	@When("^seleciono o metodo de pagamento por transferencia$")
	public void seleciono_o_metodo_de_pagamento_por_transferencia() throws Throwable {
		clicar(payment.botaoBankWire());
	}

	@When("^seleciono o metodo de pagamento por cheque$")
	public void seleciono_o_metodo_de_pagamento_por_cheque() throws Throwable {
		clicar(payment.botaoCheck());
	}

	@When("^confirmo a compra$")
	public void confirmo_a_compra() throws Throwable {
		clicar(payment.botaoConfirmMyOrder());
	}

	@Then("^valide se foi finalizada com sucesso via transferencia$")
	public void valide_se_foi_finalizada_com_sucesso_via_transferencia() throws Throwable {

		validar(payment.labelStatusCompraBankWire(), "Your order on My Store is complete.");
	}

	@Then("^valide se foi finalizada com sucesso via check$")
	public void valide_se_foi_finalizada_com_sucesso_via_check() throws Throwable {

		validar(payment.labelStatusCompraCheck(), "Your order on My Store is complete.");
	}

}
