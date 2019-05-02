package utilities;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinition.BeforeAfter;

public abstract class Utils {

	public final int TIMEOUT = 30;

	public WebDriver driver = BeforeAfter.activeDriver;
	public Actions actions = new Actions(driver);

	/**
	 * Envia comando click no elemento
	 * 
	 * @param elemento WebElement
	 */
	public void clicar(WebElement elemento) {
		log("Clico em " + elemento.getText());
		elemento.click();
	}

	public void focar(WebElement elemento) {
		actions.moveToElement(elemento).build().perform();
	}

	/**
	 * Envia texto para o elemento
	 * 
	 * @param elemento WebElement
	 * @param texto    String
	 */
	public void preencher(WebElement elemento, String texto) {
		log("Escreve: " + texto);
		elemento.clear();
		elemento.sendKeys(texto);
	}

	/**
	 * Seleciona item de uma lista
	 * 
	 * @param elemento Select
	 * @param texto    String
	 */
	public void selecionar(Select elemento, String texto) {
		log("Seleciono: " + texto);
		elemento.selectByValue(Busca(elemento, texto));
	}

	/**
	 * Busca item de uma lista
	 * 
	 * @param elemento    Select
	 * @param textoString
	 * @return
	 */
	public String Busca(Select elemento, String texto) {
		List<WebElement> lista = elemento.getOptions();
		String resultado = null;
		for (WebElement webElement : lista) {

			if (f(webElement.getText()).equals(f(texto))) {
				resultado = webElement.getAttribute("value");
				break;
			}

		}
		return resultado;
	}

	/**
	 * Le o texto de um elemento
	 * 
	 * @param elemento WebElement
	 * @return String
	 */
	public String ler(WebElement elemento) {
		return elemento.getText();
	}

	/**
	 * Maximiza tela do Navegador
	 */
	public void maximizar() {
		log("Maximiza Browser");
		driver.manage().window().maximize();
	}

	/**
	 * Acessa o link
	 * 
	 * @param link String
	 */
	public void acessar(String link) {
		log("Acessa o link: " + link);
		driver.get(link);
	}

	/**
	 * Fecha navegador
	 */
	public void fechar() {
		log("Fecha Browser");
		driver.close();
	}

	/**
	 * Retorna o elemento se ele for clicavel dentro de um tempo padrao
	 * 
	 * @param by By
	 * @return WebElement
	 */
	public WebElement esperarSerClicavel(By by) {
		WebElement element = (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.elementToBeClickable(by));
		return element;
	}

	/**
	 * Retorna o elemento se ele for clicavel dentro de um tempo definindo
	 * 
	 * @param by      By
	 * @param timeout int
	 * @return WebElement
	 */
	public WebElement esperarSerClicavel(By by, int timeout) {
		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(by));
		return element;
	}

	/**
	 * Retorna o elemento se ele estiver presente dentro de um tempo padrao
	 * 
	 * @param by By
	 * @return WebElement
	 */
	public WebElement esperarPresenca(By by) {
		WebElement element = (new WebDriverWait(driver, TIMEOUT))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return element;
	}

	/**
	 * Retorna o elemento se ele estiver presente dentro de um tempo definindo
	 * 
	 * @param by      By
	 * @param timeout int
	 * @return WebElement
	 */
	public WebElement esperarPresenca(By by, int timeout) {
		WebElement element = (new WebDriverWait(driver, timeout))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return element;
	}

	/**
	 * Espera ate decorrer o tempo padrao
	 * 
	 * @throws InterruptedException Exception
	 */
	public void esperar() throws InterruptedException {
		Thread.sleep(TIMEOUT * 1000);
	}

	/**
	 * Espera ate decorrer o tempo definido
	 * 
	 * @throws InterruptedException Exception
	 */
	public void esperar(int time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}

	/**
	 * Valida texto de um elemento
	 * 
	 * @param elemento WebElement
	 * @param texto    String
	 */
	public void validar(WebElement elemento, String texto) {
//		System.out.println(ler(elemento));
//		System.out.println(texto);
		if (ler(elemento).equals(texto)) {
			log("Validado texto: " + texto);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Escreve no console
	 * 
	 * @param string String
	 */
	private void log(String string) {
		System.out.println(BeforeAfter.activeScenario.getName() + "\t>>\t" + string);
	}

	public void marcar(WebElement elemento) {
		if (!elemento.isSelected())
			clicar(elemento);
	}

	public String getStringDia(Date date) {
		SimpleDateFormat mes = new java.text.SimpleDateFormat("dd");
		return "" + Integer.parseInt(mes.format(date));
	}

	public String getStringMes(Date date) {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		SimpleDateFormat mes = new java.text.SimpleDateFormat("MM");
		return monthName[Integer.parseInt(mes.format(date)) - 1];
	}

	public String getStringAno(Date date) {
		SimpleDateFormat mes = new java.text.SimpleDateFormat("yyyy");
		return "" + Integer.parseInt(mes.format(date));
	}

	public String f(String texto) {
		return texto.toLowerCase().trim();
	}

}
