package utilities;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if(driver==null) {
			switch(BaseClass.getProperty("browser")) { 
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				PageInitializer.initialize();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				PageInitializer.initialize();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				PageInitializer.initialize();
				break;
				
			}
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@AfterMethod
	public static void tearDown() {
		if(driver !=null) {
			driver.close();
		}
	}
	
	private static Properties configFile;
	static {
		try {
			String filePath= "src/test/resources/dataFolder/config.properties";
			FileInputStream input = new FileInputStream(filePath);
			configFile = new Properties();
			configFile.load(input);
			input.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	
	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
}
