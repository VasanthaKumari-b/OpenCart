package com.opencart.testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.opencart.constants.BaseClass;
import com.opencart.pages.LoginPage;
import com.opencart.pages.WishList;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;

/**
 * Unit test for Add items to WishList script.
 */
public class WishListTestScript extends BaseClass {

		/**
		 * Constuctor of LoginPage
		 */
		public WishListTestScript() {
			super();
		}

		LoginPage lp;
		WishList wl;  
		/**
		 * Launch the url
		 * 
		 * @param browser
		 */
		@Parameters({ "browser" })
		@BeforeMethod
		public void beforemethod(String browser) throws FileNotFoundException {
			openURL(browser);
			lp = new LoginPage();
			wl = new WishList();
		}

		/**
		 * @throws InterruptedException 
		 * @Test testcase of add items to wishlist(TC_15)
		 */
		@Test
		public void login() throws InterruptedException {
		        wl.wishlist_method();
			try {
				BaseClass.takeSnapShot(driver,"Wishlist");
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
