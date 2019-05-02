package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Cart extends Utils {

	public WebElement labelProduto() {
		return esperarSerClicavel(
				By.cssSelector("#product_1_1_0_0 > td:nth-child(2) > p:nth-child(1) > a:nth-child(1)"));
	}

	public WebElement botaoProceedToCheckout() {
		return esperarSerClicavel(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]"));
	}

}
