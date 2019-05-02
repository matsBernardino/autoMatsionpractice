package stepDefinition;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import excelManager.Excel;
import excelManager.TestData;

public class BeforeAfter {

	public static TestData activeData = null;
	public static WebDriver activeDriver = null;
	public static Scenario activeScenario = null;

	static final String GECKODRIVER = new File(".").getAbsolutePath()
			+ "\\src\\test\\resources\\Driver\\geckodriver.exe";

	@Before
	public void executedBefore(Scenario scenario) throws Throwable {
		System.out.println("\nIniciando Teste");

		System.setProperty("webdriver.gecko.driver", GECKODRIVER);

		activeData = new Excel().getTestData(scenario.getName());

		activeScenario = scenario;

		activeDriver = new FirefoxDriver();
	}

	@After
	public void executedAfter(Scenario scenario) throws Throwable {
		System.out.println("\nFinalizando Teste\n");
		activeDriver.close();
	}

}
