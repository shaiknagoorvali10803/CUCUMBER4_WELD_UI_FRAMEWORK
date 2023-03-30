package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
	             "html:target/cucumber-reports/cucumber-pretty.html",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "junit:target/cucumber-reports/report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				},
		monochrome = true,
		glue = {"StepDefinitions"}, 
		features = {"classpath:features/ui"}, 
		tags = "@Login",
		dryRun = false
		
		)
public class CucumberTest {
}
