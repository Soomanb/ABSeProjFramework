// To Verify whether application allows the user to logout from the application


package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UserLoginLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC006 
{
	private WebDriver driver;
	private String baseUrl;
	private UserLoginLogoutPOM loginoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;
		
	@Test
	  public void UserLoginLogoutTest() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait
		
		loginoutPOM.clickLoginRegisterLink(); // click on Login/Register Link
		loginoutPOM.sendUsername("abhidasa");  // enter Username
		loginoutPOM.sendPassword("real@1234");  // enter Password
		loginoutPOM.clickSignInBtn();  // click Sign In
		loginoutPOM.clickLogOut();   // Click Log out Hyperlink on the left side of the screen
		WebElement logintable = driver.findElement(By.xpath("//*[@id=\"post-133\"]/div/div/div/div"));
		assertTrue(logintable.isDisplayed()); // to check whether login screen is displayed
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page till the login table is found		
        js.executeScript("arguments[0].scrollIntoView();", logintable);
		screenShot.captureScreenShot("First_TC");
	  }
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		    // launch browser and open user URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginoutPOM = new UserLoginLogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	
  
  }
}
