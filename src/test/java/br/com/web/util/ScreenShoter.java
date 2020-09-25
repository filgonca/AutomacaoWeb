package br.com.web.util;

import static br.com.web.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;

public class ScreenShoter {

	public static String timestamp() {
		return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	}

	public static void takeScreenShot(Scenario scenario) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			if (!scenario.isFailed()) {
				FileUtils.copyFile(srcFile,
						(new File("./screenshots/passed/", scenario.getName() + " - " + timestamp() + ".jpg")));
			} else {
				FileUtils.copyFile(srcFile,
						(new File("./screenshots/failed", scenario.getName() + " - " + timestamp() + ".jpg")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}