package module.test.framework;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions( 
		features = {"src/test/resources/features"},
        glue = {"test.framework.glue"},
        //tags = {"@smoketesting"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
        strict = true,
    	dryRun = false 
)

public class Runner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("output/TestAutomationReport.html");
	}

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/main/resources/config/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}
