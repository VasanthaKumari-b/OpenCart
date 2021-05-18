package com.opencart.testscripts;

import java.io.FileNotFoundException;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.opencart.constants.BaseClass;
import com.opencart.pages.AddProduct;
import com.opencart.utilities.Waits;

import junit.framework.Assert;

/**
 * Unit test for AddProduct script
 */
public class AddProductTestScript extends BaseClass {
		/**
	     *  Constuctor of Accountcreation
	     */
		public AddProductTestScript() {
			super();
		}
		
		AddProduct ap;
		
		
		/**
	     * Launch the url
	     * @param browser
	     */
		@Parameters({ "browser" })
		@BeforeMethod
		public void beforemethod(String browser) throws FileNotFoundException {
			openURL(browser);
			ap = new AddProduct();
		}
		 /**
	     * @Test test case of ProductAvailability(TC_10)
	     */
		@Test(enabled = false, priority = 1)
		public void productAvailabitlyInCart() {

			ap.searchproduct.clear();
			ap.searchproduct.sendKeys(prop.getProperty("product"));
			ap.searchbutton.click();
			ap.product(prop.getProperty("product")).click();
			ap.quantity.clear();
			ap.quantity.sendKeys(prop.getProperty("qty"));
			ap.addtocart.click();
			ap.cartItems.click();
			Waits.waitperiod();
			ap.checkout.click();
			String actValue = ap.alertmessage.getText().trim();
			Assert.assertTrue(actValue.contains(prop.getProperty("alertMsg")));
			ap.removeproduct.click();
			try {
				BaseClass.takeSnapShot(driver,"AddProduct");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
	     * @Test test case of Remove product from cart(TC_11)
	     */
		@Test(enabled = true, priority = 2)
		public void removeProductFromCart() {
			Actions act = new Actions(driver);
			act.moveToElement(ap.lapandnoteproduct).click(ap.showallLapandnoteproducts).build().perform();
			ap.product(prop.getProperty("lapTopProduct")).click();
		   	ap.addtocart.click();
			ap.cartItems.click();
			Waits.waitperiod();//line added
			ap.viewcart.click();
			ap.removeproduct.click();
			ap.continuebutton.click();
			try {
				BaseClass.takeSnapShot(driver,"RemoveProduct");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 /**
	     * Get status of testcase and close the browse
	     */
	   @AfterMethod()
		public void aftermethod(ITestResult result) {
			String name = result.getName().toString().trim();
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println(name + "--------passed");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println(name + "-----failed");

				try {
					takeSnapShot(driver,name);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println(name + "---------Skiped");
			}
			driver.close();
			driver.quit();

		}

	}

