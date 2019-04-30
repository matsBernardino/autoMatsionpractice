package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import excelManager.Excel;
import excelManager.TestData;

public class BeforeAfter {

	public static TestData activeData = null;
	public static WebDriver activeDriver = null;

	static final String GECKODRIVER = "C:\\DesenvolvimentoUra\\webAutomation\\src\\test\\resources\\Driver\\geckodriver.exe";

	@Before
	public void executedBefore(Scenario scenario) throws Throwable {
		activeData = new Excel().getTestData(scenario.getName());
		System.setProperty("webdriver.gecko.driver", GECKODRIVER);
		System.out.println("@Before: executedBefore " + activeData.getSite());
	}

	@After
	public void executedAfter(Scenario scenario) throws Throwable {
		System.out.println("@After: executedAfter ");
	}

}
