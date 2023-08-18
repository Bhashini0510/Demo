package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseDriver {
public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop =new Properties();
		prop.load(fis);
		//String URL = prop.getProperty("QAUrl");
		
		if(driver==null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe");
				driver= new ChromeDriver();	
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get(URL);
		}
		return driver;
		
	}

}
