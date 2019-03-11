package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchApartmentPOM {

private WebDriver driver; 
	
	public searchApartmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="PLOTS")
	private WebElement Plotslink;
	
	@FindBy(id="keyword_search")
	private WebElement addrbox; 
	
	@FindBy(xpath="//*[@id=\"realteo-search-form\"]/div[3]/div/button")
	private WebElement searchbtn;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[3]/div[2]/div/div")
	private WebElement searchoutput;
	
	public void clickOnPlotsLink() {
		this.Plotslink.click();
	}
	
	public void enterKeyword(String addr) {
		this.addrbox.clear();
		this.addrbox.sendKeys(addr);
	}
	
	public void clickOnSearchBtn() {
		this.searchbtn.click();
	}
}
