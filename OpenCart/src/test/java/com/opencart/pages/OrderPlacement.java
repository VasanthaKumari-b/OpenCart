/*
 * Testcases : OrderPlacement using Guest checkout, 
 * 				OrderPlacement using register checkout
 * Created By:: Joshi
 * */

package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.ScrollPage;
import com.opencart.utilities.Waits;

public class OrderPlacement extends BaseClass {

	@FindBy(xpath = "//a[@class='dropdown-toggle' and text()='Laptops & Notebooks']")
	WebElement laptops;
	@FindBy(xpath = "//a[@class='see-all' and text()='Show All Laptops & Notebooks']")
	WebElement showlaptops;
	@FindBy(xpath = "//a[text() ='HP LP3065']")
	WebElement hpproduct;
	@FindBy(id = "input-option225")
	WebElement date;
	@FindBy(id = "button-cart")
	WebElement addtocart;
	@FindBy(id = "cart")
	WebElement viewcart;
	@FindBy(xpath = "//a[@href='https://demo.opencart.com/index.php?route=checkout/checkout']")
	WebElement checkoutbutton;
	@FindBy(xpath = "//a[@class='panel-title' and text()='Step 1: Checkout Options']")
	WebElement checkoutoptions;
	@FindBy(name = "firstname")
	WebElement firstname;
	@FindBy(name = "lastname")
	WebElement lastname;
	@FindBy(id = "input-payment-telephone")
	WebElement phone;
	@FindBy(id = "input-payment-email")
	WebElement email;
	@FindBy(id = "input-payment-password")
	WebElement paymentpassword;
	@FindBy(id = "input-payment-confirm")
	WebElement paymentconfirmpassword;
	@FindBy(name = "address_1")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "postcode")
	WebElement postcode;
	@FindBy(id = "input-payment-zone")
	WebElement region;
	@FindBy(id = "input-payment-country")
	WebElement country;
	@FindBy(id = "button-guest")
	WebElement buttoncontinue;
	@FindBy(xpath = "//input[@value='guest']")
	WebElement rdoguestCheckout;
	@FindBy(xpath = "//input[@value='register']")
	WebElement rdoregistercheckout;
	@FindBy(id = "button-account")
	WebElement buttoncheckoutcontinue;
	@FindBy(name = "comment")
	WebElement deliverycomment;
	@FindBy(id = "button-shipping-method")
	WebElement buttondeliverycontinue;
	@FindBy(id = "button-payment-method")
	WebElement buttondeliverycontinueafter;
	@FindBy(id = "button-shipping-address")
	WebElement buttonregisterdelivercontinue;
	@FindBy(name = "agree")
	WebElement agreeterms;
	@FindBy(id = "button-confirm")
	WebElement buttonconfirmorder;
	@FindBy(xpath = "//input[@name='agree' and @value='1']")
	WebElement registerbillingcheckbox;
	@FindBy(xpath = "//input[@id='button-register' and @value='Continue']")
	WebElement buttonregisterbillingcontinue;
	@FindBy(id = "button-payment-method")
	WebElement buttonpaymentcontinue;

	/**
	 * PageFactory Intilisation
	 */
	public OrderPlacement() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Find the product in Laptops
	 */
	public void findProduct() {
		Actions pointer = new Actions(driver);
		pointer.clickAndHold(laptops).build().perform();
		showlaptops.click();
		Waits.waitperiod();
		ScrollPage.scrollPagedown();
		hpproduct.click();
		Waits.waitperiod();
		date.clear();
		date.sendKeys("2021-04-23");
	}

	/**
	 * Add to cart
	 */
	public void addToCart() {
		addtocart.click();
	}

	/**
	 * View Cart
	 */
	public void viewCart() {
		viewcart.click();
		Waits.waitForVisibility(checkoutbutton);
	}

	/**
	 * Guest checkout
	 */
	public void guestCheckOut() {
		checkoutbutton.click();
		Waits.waitForVisibility(rdoguestCheckout);
		rdoguestCheckout.click();
		buttoncheckoutcontinue.click();
	}

	/**
	 * Register checkout
	 */
	public void registerCheckOut() {
		checkoutbutton.click();
		Waits.waitForVisibility(rdoregistercheckout);
		rdoregistercheckout.click();
		buttoncheckoutcontinue.click();
	}

	/**
	 * Billing Details
	 */
	public void billingDetails() {
		firstname.sendKeys(prop.getProperty("FirstName"));
		Waits.waitperiod();
		lastname.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Emailnew"));
		phone.sendKeys(prop.getProperty("Phone"));
		address.sendKeys(prop.getProperty("Address"));
		city.sendKeys(prop.getProperty("City"));
		postcode.sendKeys(prop.getProperty("PostalCode"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select country1 = new Select(country);
		country1.selectByVisibleText(prop.getProperty("Country"));
		Select state = new Select(region);
		state.selectByVisibleText(prop.getProperty("Region/State"));
	}

	/**
	 * Guest billing details
	 */
	public void guestBillingDetails() {
		buttoncontinue.click();
	}

	/**
	 * Register billingdetails
	 */
	public void registerBillingDetails() {
		paymentpassword.sendKeys(prop.getProperty("Password"));
		paymentconfirmpassword.sendKeys(prop.getProperty("Password"));
		registerbillingcheckbox.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buttonregisterbillingcontinue.click();
	}

	/**
	 * Add Delivery comment
	 */
	public void addDeliveryComment() {
		deliverycomment.sendKeys(prop.getProperty("DeliveryComment"));
		buttondeliverycontinue.click();
		agreeterms.click();
		buttondeliverycontinueafter.click();
	}

	/**
	 * Add Delivery comment
	 */
	public void registerDelivery() {
		buttonregisterdelivercontinue.click();
	}

	/**
	 * Add payment option
	 */
	public void paymentMethod() {
		deliverycomment.sendKeys(prop.getProperty("DeliveryComment"));
		registerbillingcheckbox.click();
		buttonpaymentcontinue.click();
	}

	/**
	 * Order Confirmation
	 */
	public void confirmOrder() {
		buttonconfirmorder.click();
	}
}
