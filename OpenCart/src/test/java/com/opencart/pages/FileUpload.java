/*
 * Testcases : Upload A File
 * Created By:: Vasantha
 * */

package com.opencart.pages;

import com.opencart.constants.BaseClass;
import com.opencart.utilities.ScrollPage;
import com.opencart.utilities.Waits;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FileUpload extends BaseClass {
	
   
	@FindBy(xpath = "//a[@class='dropdown-toggle' and text()='Components']")
	WebElement mouseoveraction;
	@FindBy(xpath = "//a[contains(.,'Monitors (2)')]")
	WebElement option;
	@FindBy(xpath = "//a[contains(.,'Apple Cinema 30')]")
	WebElement product;
	@FindBy(xpath = "//input[@name='option[223][]' and @value='10']")
	WebElement checkbox;
	@FindBy(xpath = "//input[@value='test']")
	WebElement text;
	@FindBy(xpath = "//select[@name='option[217]']")
	WebElement dropdown;
	@FindBy(xpath = "//textarea[contains(@placeholder,'Textarea')]")
	WebElement textarea;
	@FindBy(xpath = "//button[@id='button-upload222']")
	WebElement uploadfile;
	@FindBy(xpath = "//input[contains(@id,'input-option219')]")
	WebElement datewidget;
	@FindBy(xpath = "//input[@name='quantity']")
	WebElement quantity;
	@FindBy(xpath = "(//button[contains(.,'Add to Cart')])[1]")
	WebElement addtocart;

	/**
	 * Pagefactorty Intilisation
	 */
	public FileUpload() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Product selection from compenents
	 */
	public void selectproductfromcompenent() {
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseoveraction).build().perform();
		Waits.waitForVisibility(option);
		option.click();
		Waits.waitperiod();
		product.click();
	}

	/**
	 * Add to cart with required options.
	 */
	public void addtocartoptions() {
		ScrollPage.scrollPagedown();
		checkbox.click();
		text.clear();
		text.sendKeys("text");
		Select dropdownoption = new Select(dropdown);
		dropdownoption.selectByValue("3");
		textarea.clear();
		textarea.sendKeys("Hello");
		ScrollPage.scrollPagedown();
		uploadfile.sendKeys("C:\\Users\\user\\Desktop\\WF\\selinium_graph.png");
		datewidget.clear();
		datewidget.sendKeys("2021-05-10");
		quantity.clear();
		quantity.sendKeys("2");
		addtocart.click();
		}

	/**
	 * FileUpload Process
	 */
	public void uploadfile() {
		uploadfile.sendKeys("C:\\Users\\user\\Desktop\\WF\\selinium_graph.png");
		String expectedFile = uploadfile.getAttribute("value");
		if (expectedFile.equalsIgnoreCase(expectedFile)) {
			System.out.println("File is Uploaded");
		} else {
			System.out.println("File is not Uploaded");
		}
	}
}
