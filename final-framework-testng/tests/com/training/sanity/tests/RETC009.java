package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.searchApartmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC009 {
	
	private WebDriver driver;
	private String baseUrl;
	private searchApartmentPOM searchaptmtpom;
	private static Properties properties;
	private ScreenShot screenShot;
	
  @Test
  public void ApartmentSearchTest() {
	 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait
		searchaptmtpom.clickOnPlotsLink();
		searchaptmtpom.enterKeyword("Electronic City, Bengaluru, Karnataka, India");
		searchaptmtpom.clickOnSearchBtn();
		WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[2]/div/div/div[2]/div"));
		assertTrue(searchResult.isDisplayed());
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
			searchaptmtpom = new searchApartmentPOM(driver); 
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
