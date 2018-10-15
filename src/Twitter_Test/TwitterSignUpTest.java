package Twitter_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Twitter_core.TwitterCoreQA;

public class TwitterSignUpTest extends TwitterCoreQA{

	public TwitterSignUpTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
	public void signuptest() {
		driver.findElement(By.linkText("Sign Up")).click();
		try {
			 driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys(prop.getProperty("usrname"));
		}catch(Exception t) {
			driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys(prop.getProperty("usrname"));
		}
		driver.findElement(By.xpath("//input[contains(@name, 'phone_number')]")).sendKeys(prop.getProperty("phnnumber"));
		try {
			WebElement nxt = driver.findElement(By.xpath("//*[text()='Next']"));
			nxt.click();			
		}catch(Exception t) {
			WebElement nxt = driver.findElement(By.xpath("//*[text()='Next']"));
			nxt.click();
			
		}
		
		
		String signuptxt = driver.findElement(By.xpath("(//span[contains(text(), 'Sign up')])[2]")).getText();
		Assert.assertEquals(signuptxt, "Sign up");	
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
