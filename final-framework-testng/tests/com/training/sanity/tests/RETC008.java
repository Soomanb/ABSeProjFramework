package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.pom.MortgageeCalculatorPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC008 {
	
	private WebDriver driver;
	private String baseUrl;
	private MortgageeCalculatorPOM mortgcalcpom;
	private static Properties properties;
	private ScreenShot screenShot;
	private String expected = "Monthly Payment: 3003.43 Rs.";
	private String actual;
	
	
  @Test
  public void validMortgageeCalculator() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait
	  
	  mortgcalcpom.mouseOverToApartmentsLink();
	  mortgcalcpom.clickOnPrestigeLink();
	  mortgcalcpom.enterMortagageeCalcValues("400000", "20000", "20", "7.25");
	  mortgcalcpom.clickOnCalculateButton();
	  actual = mortgcalcpom.getMonthlyPaymentAmt();
	  WebElement confirmationmsg = driver.findElement(By.className("calc-output-container"));
	  assertEquals(actual, expected);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page till the login table is found		
      js.executeScript("arguments[0].scrollIntoView();",confirmationmsg );
		screenShot.captureScreenShot("Third_TC");
	  
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
		mortgcalcpom = new MortgageeCalculatorPOM(driver); 
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
