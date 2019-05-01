package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Address extends Utils {

	public WebElement labelNomeEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(2)"));
	}

	public WebElement labelEmpresaEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(3)"));
	}

	public WebElement labelEnderecoEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(4)"));
	}

	public WebElement labelEstadoCidadeCodigoPostalEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(5)"));
	}

	public WebElement labelPaisEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(6)"));
	}

	public WebElement labelTelefoneEntrega() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(7)"));
	}

	public WebElement labelNomeFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_invoice > li:nth-child(2)"));
	}

	public WebElement labelEmpresaFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(3)"));
	}

	public WebElement labelEnderecoFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(4)"));
	}

	public WebElement labelEstadoCidadeCodigoPostalFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(5)"));
	}

	public WebElement labelPaisFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(6)"));
	}

	public WebElement labelTelefoneFaturamento() {
		return esperarSerClicavel(By.cssSelector("#address_delivery > li:nth-child(7)"));
	}

	public WebElement botaoProceedocheckout() {
		return esperarSerClicavel(By.cssSelector("button.button:nth-child(4)"));
	}

}
