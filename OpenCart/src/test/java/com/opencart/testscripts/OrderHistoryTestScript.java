package com.opencart.testscripts;

import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.opencart.constants.BaseClass;
import com.opencart.pages.AccountCreation;
import com.opencart.pages.LoginPage;
import com.opencart.pages.OrderHistory;

import org.testng.annotations.Test;


/**
 * Unit test for Orderhistory script.
 */
public class OrderHistoryTestScript extends BaseClass{

		/**
		 * Constuctor of LoginPage
		 */
		public OrderHistoryTestScript() {
			super();
		}

		OrderHistory oh;
		LoginPage lp;
		AccountCreation acc;
		/**
		 * Launch the url
		 * 
		 * @param browser
		 */
		@Parameters({ "browser" })
		@BeforeMethod
		public void beforemethod(String browser) throws FileNotFoundException {
			openURL(browser);
			oh = new OrderHistory();
			acc = new AccountCreation();
			lp = new LoginPage(); 
		}

		/**
		 * @Testtest case of order history(TC_16)
		 */
		@Test
		  public void orderHistory() {
	        lp.clickLogin();
	        acc.clicksignin();
			oh.orderHistoryView();
			try {
				BaseClass.takeSnapShot(driver,"orderHistoryView");
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
