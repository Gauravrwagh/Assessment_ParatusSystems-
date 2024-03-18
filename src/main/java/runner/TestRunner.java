package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {
				"src/main/resources/Features/Compose_and_send_email.feature"
		},
		glue="stepDefination",
		monochrome = true,
	    dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports.html", 
			        		"json:target/cucumber.json"
			        
				}   
		)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
