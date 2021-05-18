/*
 * Testcases :Product Availability,Remove Product, Apply couponcode 
 * Created By:: Ramesh
 * */

package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.opencart.constants.BaseClass;
import com.opencart.constants.ReadExcel;
import com.opencart.utilities.Waits;

public class AddProduct extends BaseClass {

	@FindBy(xpath = "//div[@id='search']/input")
	public WebElement searchproduct;
	
	@FindBy(xpath = "//div[@id='search']/span")
	public WebElement searchbutton;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a[text()='Laptops & Notebooks']")
	public WebElement lapandnoteproduct;
	
	@FindBy(xpath = "//div[@class='dropdown-menu']/a[text()='Show All Laptops & Notebooks']")
	public WebElement showallLapandnoteproducts;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//button[@title='Remove']")
	public WebElement removeproductfromcart;
	
	public WebElement product(String pName) {
	return driver.findElement(By.xpath("//div[@class='product-thumb']//div[@class='caption']/h4/a[text()='"+pName+"']"));
	}
	
	@FindBy(xpath = "//a[text() ='HP LP3065']")
	public WebElement hpproduct;
	
	@FindBy(xpath="//div[@id='product']//input[@name='quantity']")
	public  WebElement quantity;
	
	@FindBy(xpath="//div[@id='product']//button[@id='button-cart']")
	public WebElement addtocart;
	
	@FindBy(xpath="//div[@id='cart']")
	public WebElement cartItems;

	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/checkout')]")
	public WebElement checkout;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/cart')]")
	public WebElement viewcart;

	@FindBy(xpath="//div[contains(@class,'alert')]")
	public WebElement alertmessage;
	
	@FindBy(xpath="//span[@class='input-group-btn']/button[@data-original-title='Remove']")
	public WebElement removeproduct;
	
	@FindBy(xpath="//a[text()='Continue']")
	public WebElement continuebutton;
		
	@FindBy(xpath="//div[@class='input-group date']/input")
	public WebElement deliverydate;
	
	@FindBy(xpath="//a[@href='#collapse-coupon']")
	public WebElement usecouponcode;
	
	@FindBy(xpath="//input[@id='input-coupon']")
	public WebElement couponcode;	
	
	@FindBy(xpath="//input[@id='button-coupon']")
	public WebElement applyCouponCode;
	
	/**
	 * PageFactory intilisation
	 */
	public AddProduct() {
		PageFactory.initElements(driver, this);
	}

	
}

