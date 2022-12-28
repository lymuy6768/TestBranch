package runners;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

			plugin = {"pretty", "json:target/JSON_Reports/Cucumber.json",
	                "junit:target/Cucumber_Reports/Cucumber.xml",
	        "html:target/HTML_Reports/index.html"}, 
			monochrome = true,
			features = "src/test/resources/features",
			glue = {"stepDef"}, 
			dryRun = false)
			
	public class SearchItemRunnerTest extends AbstractTestNGCucumberTests{

}

