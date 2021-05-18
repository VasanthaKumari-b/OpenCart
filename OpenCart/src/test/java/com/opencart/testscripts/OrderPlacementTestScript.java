package com.opencart.testscripts;

import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.opencart.constants.BaseClass;
import com.opencart.listeners.ExtentTestManager;
import com.opencart.pages.OrderPlacement;
import com.opencart.utilities.Waits;

import org.testng.annotations.Test;

/**
 * Unit test for OrderPlacement script.
 */
public class OrderPlacementTestScript extends BaseClass{
	
			/**
			 * Constuctor of LoginPage
			 */
			public OrderPlacementTestScript() {
				super();
			}

			OrderPlacement op;
			
			/**
			 * Launch the url
			 * 
			 * @param browser
			 */
			@Parameters({ "browser" })
			@BeforeMethod
			public void beforemethod(String browser) throws FileNotFoundException {
				openURL(browser);
				op = new OrderPlacement();
			}

			/**
			 * @Test testcase of orderPlacementWithGuest checkout(TC_06)
			 */
			@Test(enabled = false, priority = 8)
			public void orderPlacementWithGuest() {
				op.findProduct();
				op.addToCart();
				op.viewCart();
				op.guestCheckOut();
				Waits.waitperiod();
				op.billingDetails();
				op.guestBillingDetails();
				op.addDeliveryComment();
				op.confirmOrder();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					BaseClass.takeSnapShot(driver,"GuestCheckout_Confirm-Order");
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			/**
			 * @Test testcase of orderPlacementWithRegister checkout(TC_07)
			 */
			@Test(enabled = true, priority =2)
			public void orderPlacementWithRegister() {
				op.findProduct();
				op.addToCart();
				op.viewCart();
				op.registerCheckOut();
				Waits.waitperiod();
				op.billingDetails();
				op.registerBillingDetails();
				op.registerDelivery();
				op.addDeliveryComment();
				op.paymentMethod();
				op.confirmOrder();
				Waits.waitperiod();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					
					takeSnapShot(driver,"RegisterCheckout_Confirm-Order");
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
