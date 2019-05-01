package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Payment extends Utils {

	public WebElement labelValorTotal() {
		return esperarSerClicavel(By.id("total_price"));
	}

	public WebElement botaoBankWire() {
		return esperarSerClicavel(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div:nth-child(1)"));
	}

	public WebElement botaoCheck() {
		return esperarSerClicavel(By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div:nth-child(1)"));
	}

	public WebElement botaoConfirmMyOrder() {
		return esperarSerClicavel(By.cssSelector("button.button-medium"));
	}

	public WebElement labelStatusCompraBankWire() {
		return esperarSerClicavel(By.cssSelector(".cheque-indent > strong:nth-child(1)"));
	}

	public WebElement labelStatusCompraCheck() {
		return esperarSerClicavel(By.cssSelector(".alert"));
	}

}
