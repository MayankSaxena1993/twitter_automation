package Twitter_core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TwitterCoreQA {
	
	public WebDriver driver;
	public Properties prop;
	
	public TwitterCoreQA() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\JAVA_PRACTICE\\TwitterQAAutomationProject\\src\\Twitter_config\\config.properties");
		prop.load(fis);
	}
	
	public void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome")) {
			String chromepath = "C:\\Users\\lenovo\\Desktop\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenovo\\Desktop\\geckodriver-win64");
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	

}
