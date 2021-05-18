package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.BaseClass;

public class OrderHistory extends BaseClass {

	@FindBy(xpath = "//a[text()='Order History']")
	WebElement orderhistory;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement view;

	/**
	 * PageFactory Intilisation
	 */
	public OrderHistory() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Order History
	 */
	public void orderHistoryView(){
		orderhistory.click();
		view.click();
	}
}
