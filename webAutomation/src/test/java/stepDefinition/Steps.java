package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excelManager.TestData;

public class Steps {
	WebDriver driver;
	TestData data;

	public Steps() {
		data = BeforeAfter.activeData;
		driver = BeforeAfter.activeDriver;
	}

	@Given("^inicio navegador com as configuracoes$")
	public void inicio_navegador_com_as_configuracoes() throws Throwable {
		driver = new FirefoxDriver();
	}

	@When("^entro no site$")
	public void entro_no_site() throws Throwable {
		driver.get(data.getSite());
	}

	@When("^digito login$")
	public void digito_login() throws Throwable {
		String xpathExpression = "//*[@id=\"block_top_menu\"]/ul/li[3]";
		driver.findElement(By.xpath(xpathExpression)).click();;
	}

	@Then("^valida se esta logado$")
	public void valida_se_esta_logado() throws Throwable {
		driver.quit();
	}

}
