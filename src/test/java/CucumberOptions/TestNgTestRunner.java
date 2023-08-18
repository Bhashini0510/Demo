package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= { "C:\\Manju\\SDET\\ElearningProject\\src\\test\\resources\\features\\Register.feature"},
		monochrome= true,
				plugin= { "html: target/cucumber.html", "json: target/cucumber.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
				tags="@register",
		glue={"StepDefinitions"}
		)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel =false)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
