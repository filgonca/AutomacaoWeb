package br.com.web.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./features",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		glue = {"br.com.web.steps", "br.com.web.util", "br.com.web.core"},
		//tags = {"@logar"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner {
	
}