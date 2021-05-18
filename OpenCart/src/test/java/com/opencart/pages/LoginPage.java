package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and @title='My Account']")
	WebElement myaccount;
	@FindBy(xpath = "(//a[contains(.,'Login')])[1]")
	WebElement loginbutton;
	@FindBy(xpath = "//input[contains(@id,'input-email')]")
	WebElement email;
	@FindBy(xpath = "//input[contains(@id,'input-password')]")
	WebElement password;
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement buttonlogin;
	
	@FindBy(id="user_email_Login")
	WebElement username;
	
	//WebElement password=driver.findElement(By.id("user_password"));
	
	
	/**
	 * PageFactory Intilisation
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Login process
	 */
	public void clickLogin() {
		Waits.waitperiod();
		myaccount.click();
		loginbutton.click();
		email.sendKeys(prop.getProperty("Email"));
		password.sendKeys(prop.getProperty("Password"));
		buttonlogin.click();
	}
}
