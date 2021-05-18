/*
 * Testcases : Login, VerifyTitle, AddToCart
 * Created By:: Rohith
 * */

package com.opencart.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class AddToCart extends BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(xpath = "(//a[contains(.,'Desktops')])")
	WebElement desktop;
	@FindBy(xpath = "//a[contains(.,'Mac (1)')]")
	WebElement mac;
	@FindBy(xpath = "//img[contains(@src,'1-228x228.jpg')]")
	WebElement imac;
	@FindBy(xpath = "//button[contains(@id,'button-cart')]")
	WebElement addtocart1;

	/**
	 * Pagefactorty Intilisation
	 */
	public AddToCart() throws FileNotFoundException {
		PageFactory.initElements(driver, this);

	}

	/**
	 * MouseOver Action(Desktop)
	 */
	public void click() {
		Actions pointer = new Actions(driver);
		pointer.moveToElement(desktop).build().perform();
		mac.click();
	}

	/**
	 * Add product to cart
	 */
	public void addtocart() {
		imac.click();
		addtocart1.click();
	}

	/**
	 * Scroll Page up and down
	 */
	public void scrollpage() {
		js.executeScript("window.scrollBy(0,1000)");
		Waits.waitperiod();
		js.executeScript("window.scrollBy(0,-1000)");
	}

}
