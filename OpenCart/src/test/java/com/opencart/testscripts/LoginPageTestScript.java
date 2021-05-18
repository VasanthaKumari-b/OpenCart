package com.opencart.testscripts;

import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.opencart.constants.BaseClass;
import com.opencart.pages.LoginPage;

import junit.framework.Assert;

import org.testng.annotations.Test;

/**
 * Unit test for Login Page script.
 */

public class LoginPageTestScript extends BaseClass {

	/**
	 * Constuctor of LoginPage
	 */
	public LoginPageTestScript() {
		super();
	}

	LoginPage lp;

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
	}

	/**
	 * @Test testcase of Login(TC_03)
	 */
	@Test(enabled = true, priority = 1)
	public void login() {
		lp.clickLogin();
		try {
			BaseClass.takeSnapShot(driver,"Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Test testcase of verifytitle(TC_04)
	 */
	@Test(enabled = false, priority = 2)
	public void verifyTitle() {
		lp.clickLogin();//added this line
		String actual = driver.getTitle();
		Reporter.log(actual);
		String expected = prop.getProperty("title");
		Reporter.log(expected);
		Assert.assertEquals(actual, expected, "Title matched");
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
