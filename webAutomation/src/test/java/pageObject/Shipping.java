package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Shipping extends Utils {

	public WebElement checkBoxTermsOfService() {
		return esperarSerClicavel(By.id("uniform-cgv"));
	}

	public WebElement botaoProceedocheckout() {
		return esperarSerClicavel(By.cssSelector("button.button:nth-child(4)"));
	}

}
