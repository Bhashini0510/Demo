package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utilities.Textcontextclass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	Textcontextclass TextContext;
	public Hooks(Textcontextclass TextContext) {
		this.TextContext = TextContext;
	}
	@After
	public void after_scenario() throws IOException {
	TextContext.testbase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void Addscreeshot(Scenario scenario) throws IOException {
		
		WebDriver driver=TextContext.testbase.WebDriverManager();
		if(scenario.isFailed()) {
		File Sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] filecontent = FileUtils.readFileToByteArray(Sourcepath);
		scenario.attach(filecontent, "image/png", "image");
		
		}
		
	}


}
