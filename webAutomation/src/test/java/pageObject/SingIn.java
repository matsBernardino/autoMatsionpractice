package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Utils;

public class SingIn extends Utils {

	public WebElement campoEmail() {
		return esperarSerClicavel(By.id("email_create"));
	}

	public WebElement botaoCreateAnAccount() {
		return esperarSerClicavel(By.id("SubmitCreate"));
	}

	public WebElement radioMasculino() {
		return esperarSerClicavel(By.id("id_gender1"));
	}

	public WebElement radioFeminino() {
		return esperarSerClicavel(By.id("id_gender2"));
	}

	public WebElement nome() {
		return esperarSerClicavel(By.id("customer_firstname"));
	}

	public WebElement sobrenome() {
		return esperarSerClicavel(By.id("customer_lastname"));
	}

	public WebElement senha() {
		return esperarSerClicavel(By.id("passwd"));
	}

	public Select diaNascimento() {
		WebElement diaNascimento = esperarPresenca(By.id("days"));
		return new Select(diaNascimento);
	}

	public Select mesNascimento() {
		WebElement mesNascimento = esperarPresenca(By.id("months"));
		return new Select(mesNascimento);
	}

	public Select anoNascimento() {
		WebElement anoNascimento = esperarPresenca(By.id("years"));
		return new Select(anoNascimento);
	}

	public WebElement nomeEntrega() {
		return esperarSerClicavel(By.id("firstname"));
	}

	public WebElement sobrenomeEntrega() {
		return esperarSerClicavel(By.id("lastname"));
	}

	public WebElement empresa() {
		return esperarSerClicavel(By.id("company"));
	}

	public WebElement endereco() {
		return esperarSerClicavel(By.id("address1"));
	}

	public WebElement cidade() {
		return esperarSerClicavel(By.id("city"));
	}

	public Select estado() {
		WebElement estado = esperarPresenca(By.id("id_state"));
		return new Select(estado);
	}

	public WebElement codigoPostal() {
		return esperarSerClicavel(By.id("postcode"));
	}

	public Select pais() {
		WebElement pais = esperarPresenca(By.id("id_country"));
		return new Select(pais);
	}

	public WebElement informacaoAdicional() {
		return esperarSerClicavel(By.id("other"));
	}

	public WebElement telefone() {
		return esperarSerClicavel(By.id("phone"));
	}

	public WebElement enderecoReferencia() {
		return esperarSerClicavel(By.id("alias"));
	}

	public WebElement botaoSubmitAccount() {
		return esperarSerClicavel(By.id("submitAccount"));
	}

}
