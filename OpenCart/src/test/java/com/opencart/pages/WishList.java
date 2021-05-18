/*
 * Testcases : WishList
 * Created By:: Sandeep
 * */

package com.opencart.pages;

import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.opencart.constants.BaseClass;
import com.opencart.utilities.Waits;

public class WishList extends BaseClass {

	@FindBy(xpath = "(//a[contains(@class,'dropdown-toggle')])[4]")
	WebElement components;
	@FindBy(xpath = "//a[contains(@href,'28')]")
	WebElement monitors;
	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement sortby_dropdown;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-heart')])[2]")
	WebElement wishlist_button;
	@FindBy(id = "wishlist-total")
	WebElement wishlist_icon;
	@FindBy(xpath = "//a[@title='Shopping Cart']")
	WebElement addtocart;

	/**
	 * PafeFactory Intilisation
	 */
	public WishList() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Add items to wishlist
	 * @throws InterruptedException 
	 */
	public void wishlist_method() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(components).click().build().perform();
		monitors.click();
		Select select = new Select(sortby_dropdown);
		select.selectByIndex(4);
		Thread.sleep(3000);
		wishlist_button.click();
		Thread.sleep(2000);
		wishlist_icon.click();
		Waits.waitperiod();
		addtocart.click();
			}

}
