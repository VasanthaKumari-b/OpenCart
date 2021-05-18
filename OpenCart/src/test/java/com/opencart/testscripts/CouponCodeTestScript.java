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
import com.opencart.pages.CouponCode;
import com.opencart.pages.LoginPage;
import com.opencart.utilities.Waits;

/**
 * Unit test for Couincode script
 */
public class CouponCodeTestScript extends BaseClass{
			 
			/**
		     *  Constuctor of Coupincode
		     */
		    public CouponCodeTestScript(  )
		    {
		        super( );
		    }
		    CouponCode cc;
		    LoginPage lp;
		    AddProduct ap;
		     /**
		     * Launch the url
		     * @param browser
		     */
		    @Parameters({ "browser" })
			@BeforeMethod
			public void beforemethod(String browser) throws FileNotFoundException {
				openURL(browser);
				cc = new CouponCode();
			    lp = new LoginPage();
			    ap = new AddProduct();
		    }
		    /**
		     * @Test test case for Apply coupincode(TC_12)
		     */
		    @Test(enabled = true, priority = 1)
			public void applyCouponCode() {
				Actions act = new Actions(driver);
				act.moveToElement(ap.lapandnoteproduct).click(ap.showallLapandnoteproducts).build().perform();
				ap.hpproduct.click();
				ap.deliverydate.clear();
				ap.deliverydate.sendKeys(prop.getProperty("deliveryDate"));
				ap.quantity.clear();
				ap.quantity.sendKeys(prop.getProperty("qty"));
				ap.addtocart.click();
				ap.cartItems.click();
				Waits.waitperiod();//line added
				ap.viewcart.click();
				ap.usecouponcode.click();
				ap.couponcode.clear();
				ap.couponcode.sendKeys(prop.getProperty("couponCode"));
				ap.applyCouponCode.click();
				ap.removeproduct.click();

			}
		    /**
		     * @Test test case for empty coupincode(TC_13)
		     */
		   @Test
		  	public void emptyCouponCode() throws Exception {

				lp.clickLogin();
				// start 
				Actions act = new Actions(driver);
				act.moveToElement(ap.lapandnoteproduct).click(ap.showallLapandnoteproducts).build().perform();
				ap.product(prop.getProperty("lapTopProduct")).click();
				ap.deliverydate.clear();
				ap.deliverydate.sendKeys(prop.getProperty("deliveryDate"));
				ap.quantity.clear();
				ap.quantity.sendKeys(prop.getProperty("qty"));
				ap.addtocart.click();
			// end start to en lines are added to add proct in cart 
				cc.Empty_Couponcode();
				cc.Estimate_Shipping();
				cc.BillingDetails();
				try {
					BaseClass.takeSnapShot(driver,"CoupinCode");
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




