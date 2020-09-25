package br.com.web.util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class GeradorReport {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;

	public static void afterScenario(Scenario scenario) {
		if (!scenario.isFailed()) {
			extentTest.log(Status.PASS, "Cenário " + scenario.getName() + " executado com sucesso!");
		} else {
			extentTest.log(Status.FAIL, "Cenário " + scenario.getName() + " executado com falha!");
		}
		extentReport.flush();
	}

	@Before
	public static void takeReport(Scenario scenario) {
		if (extentReport == null) {
			criarDiretorioMacro();
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("./report/htmlReporter.html");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(scenario.getId());
	}
	
	public static void criarDiretorioMacro() {
        try {
            File diretorio = new File("./report");
            diretorio.mkdir();
            System.out.println("Diretorio report criado com sucesso na pasta raiz do projeto");
        } catch (Exception ex) {
        	System.out.println("Erro ao criar o diretorio report na pasta raiz do projeto");
            System.out.println(ex);
        }
    }
}