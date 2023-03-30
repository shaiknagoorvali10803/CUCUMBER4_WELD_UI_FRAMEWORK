package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
	             "rerun:target/failedRerun.txt"
		},
		monochrome = true,
		glue = {"StepDefinitions"}, 
		features = {"@target/failedRerun.txt"}, 
		tags = {},
		dryRun = false
		
		)

public class FailedRerunTest {
	

}
