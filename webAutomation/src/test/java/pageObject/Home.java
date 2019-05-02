package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Home extends Utils {

	public WebElement roupa() {
		return esperarSerClicavel(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div"));
	}

	public WebElement botaoAddToCart() {
		return esperarSerClicavel(
				By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]/span"));
	}

	public WebElement botaoProceedToCheckout() {
		return esperarSerClicavel(
				By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
	}

}
