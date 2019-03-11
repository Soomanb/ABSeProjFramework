package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgageeCalculatorPOM {
	
private WebDriver driver; 
	
	public MortgageeCalculatorPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(linkText="APARTMENTS")
	private WebElement Apartmentslink;
	
	@FindBy(xpath="//*[@id=\"wpmm-megamenu\"]/div[2]/div[2]/div[1]/a/img")
	private WebElement prestigelink; 
	
	@FindBy(id="amount")
	private WebElement saleprice;
	
	@FindBy(id="downpayment")
	private WebElement downpaymnt; 
	
	@FindBy(id="years")
	private WebElement loanterm;
	
	@FindBy(id="interest")
	private WebElement interestrate;
	
	@FindBy(xpath="//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button")
	private WebElement calculatebtn;
	
	@FindBy(class="calc-output-container")
	private WebElement ConfirmMsg;
	
	// Methods
	
	public void mouseOverToApartmentsLink() {
		Actions action = new Actions(this.driver);
		action.moveToElement(this.Apartmentslink).build().perform();
	}
	
	public void clickOnPrestigeLink() {
		this.prestigelink.click();
	}
	
	public void enterMortagageeCalcValues(String saleprice, String dwnpymnt, String loantrm, String intrate) {
		this.saleprice.clear();
		this.saleprice.sendKeys(saleprice);
		this.downpaymnt.clear();
		this.downpaymnt.sendKeys(dwnpymnt);
		this.loanterm.clear();
		this.loanterm.sendKeys(loantrm);
		this.interestrate.clear();
		this.interestrate.sendKeys(intrate);
	}
	
	public void clickOnCalculateButton() {
		this.calculatebtn.click();
	}
	
	public String getMonthlyPaymentAmt() {
		return this.ConfirmMsg.getText();
	}

}
