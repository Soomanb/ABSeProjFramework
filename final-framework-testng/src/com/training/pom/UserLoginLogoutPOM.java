package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginLogoutPOM {

private WebDriver driver; 
	
	public UserLoginLogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement LoginRegLink;
	
	@FindBy(id="user_login")
	private WebElement Username; 
	
	@FindBy(id="user_pass")
	private WebElement Password;
	
	@FindBy(name="login")
	private WebElement SignInBtn; 
	
	@FindBy(linkText="Log Out")
	private WebElement LogOutBtn;
	
	public void clickLoginRegisterLink() {
		this.LoginRegLink.click();;
	}
	
	public void sendUsername(String username) {
		this.Username.clear();
		this.Username.sendKeys(username);
	}
	
	public void sendPassword(String password) {
		this.Password.clear(); 
		this.Password.sendKeys(password); 
	}
	
	public void clickSignInBtn() {
		this.SignInBtn.click(); 
	}
	
	public void clickLogOut() {
		this.LogOutBtn.click(); 
	}
	
}
