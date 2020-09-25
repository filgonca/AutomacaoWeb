package br.com.web.core;

import static br.com.web.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static WebDriverWait wait;
	
	// Metodo para clicar
	public void clicar(By elemento) {
		wait = new WebDriverWait(getDriver(), 10); //espera por dez sengundos
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		getDriver().findElement(elemento).click();
	}

	// Metodo para clicar por texto xpath
	public void clicarPorTextoXpath(String texto) {
		clicar(By.xpath("//*[@text=' + texto + ']"));
	}
	
	// Metodo para clicar por texto css
		public void clicarPorTextoCss(String texto) {
			clicar(By.cssSelector("a[href*=' + texto + ']"));
		}

	// Metodo para escrever
	public void escrever(By elemento, String texto) {
		getDriver().findElement(elemento).sendKeys(texto);
	}
	
	// Metodo para limpar campo
		public void limparCampo(By elemento) {
			getDriver().findElement(elemento).clear();
		}

	// Metodo para ler texto
	public String lerTexto(By elemento) {
		return getDriver().findElement(elemento).getText().toString();
	}

	// Metodo de comparacao de texto
	public void validarTexto(String textoEsperado, By elemento) {
		Assert.assertEquals(textoEsperado, lerTexto(elemento));
	}
	
	// Ignorar elemento ausente
	public void ignorarElementoAusente(By elemento) {
		if (getDriver().findElements(elemento).size() != 0) {
			clicar(elemento);
			;
		} else {
			System.out.println("Elemento está ausente");
		}
	}

	// Verifica se elemento está visivel
	public void verificarElementoVisivel(By elemento) {
		if (getDriver().findElement(elemento).isDisplayed()) {
			System.out.println("Element is Visible");
		} else {
			System.out.println("Element is InVisible");
		}
	}
}
