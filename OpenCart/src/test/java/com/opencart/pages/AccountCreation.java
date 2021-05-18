package com.opencart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class AccountCreation extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and @title='My Account']")
	WebElement myaccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpassword;
	@FindBy(xpath = "//input[@value=1 and @name='newsletter']")
	WebElement subscribe;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacypolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continuebutton2;
	@FindBy(xpath = "//div[@class='col-sm-10']/div[@class='text-danger']")
	WebElement errormessage;
	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement editaccount;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement buttoncontinue;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement readmessage;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	/**
	 * Pagefactorty Intilisation
	 */
	public AccountCreation() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Sign in Account
	 */
	public void clicksignin() {
		Waits.waitperiod();
		myaccount.click();
	}

	/**
	 * Account Creation with all required details
	 */
	public void createAccount() {
		Waits.waitperiod();
		register.click();
		firstname.sendKeys(prop.getProperty("FirstName"));
		lastname.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Email"));
		phone.sendKeys(prop.getProperty("Phone"));
		password.sendKeys(prop.getProperty("Password"));
		confirmpassword.sendKeys(prop.getProperty("Password"));
		subscribe.click();
		privacypolicy.click();
		continuebutton.click();
		continuebutton2.click();
			}

	/**
	 * Account creation with missed phone numder detail
	 */
	public void createAccountWithoutPhone() {
		Waits.waitperiod();
		firstname.sendKeys(prop.getProperty("FirstName"));
		lastname.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Email"));
		password.sendKeys(prop.getProperty("Password"));
		confirmpassword.sendKeys(prop.getProperty("Password"));
		subscribe.click();
		privacypolicy.click();
		continuebutton.click();
		String error = errormessage.getText();
		Reporter.log(error);
	}

	/**
	 * Edit account
	 */
	public void editAccount() {
		editaccount.click();
		lastname.clear();
		lastname.sendKeys(prop.getProperty("LastNameedit"));
		buttoncontinue.click();
		String actual = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText",readmessage)
				.toString();
		System.out.println(actual + "----actual msg");
		String expected = prop.getProperty("Successmsg");
	}

	/**
	 * Navigate to Homepage
	 */
	public void navigateToHomePage() {
		Waits.waitperiod();
		driver.navigate().to(prop.getProperty("url"));
	}

}
