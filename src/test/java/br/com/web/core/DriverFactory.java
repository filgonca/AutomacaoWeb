package br.com.web.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.web.util.GeradorReport;
import br.com.web.util.ScreenShoter;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class DriverFactory {

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}
	
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	@After
	public static void tearDown(Scenario scenario) {
		ScreenShoter.takeScreenShot(scenario);
		GeradorReport.afterScenario(scenario);
		killDriver();
	}
}