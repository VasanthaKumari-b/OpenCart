package com.opencart.testscripts;

import java.io.FileNotFoundException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.constants.BaseClass;
import com.opencart.pages.AddToCart;

/**
 * Unit test for Addtocart script.
 */
public class AddToCartTestScript extends BaseClass{
	 
		/**
	     *  Constuctor of Addtocart
	     */
	    public AddToCartTestScript(  )
	    {
	        super( );
	    }
	    AddToCart at;
	    
	     /**
	     * Launch the url
	     * @param browser
	     */
	    @Parameters({ "browser" })
		@BeforeMethod
		public void beforemethod(String browser) throws FileNotFoundException {
			openURL(browser);
		at = new AddToCart();
	    }
	    /**
		 * @Test testcase of Addtocart(TC_05)
		 */
	   @Test
	   public void addToCart(){
			at.click();
			at.scrollpage();
			at.addtocart();
			try {
				BaseClass.takeSnapShot(driver,"Addtocart");
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




