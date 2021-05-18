package com.opencart.testscripts;

import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.opencart.constants.BaseClass;
import com.opencart.pages.AccountCreation;
import com.opencart.pages.LoginPage;

/**
 * Unit test for Accountcreation script
 */
public class AccountCreationTestScript extends BaseClass {

	/**
     *  Constuctor of Accountcreation
     */
	public AccountCreationTestScript() {
		super();
	}
	
	AccountCreation acc;
	LoginPage lp;
	
	/**
     * Launch the url
     * @param browser
     */
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforemethod(String browser) throws FileNotFoundException {
		openURL(browser);
		acc = new AccountCreation();
		lp = new LoginPage(); 
	}
	/**
     * @Test testcase of registerAccount(TC_01)
     */
	@Test(enabled = true, priority = 1)
	public void registerAccount() {
		acc.clicksignin();
		acc.createAccount();
		try {
			BaseClass.takeSnapShot(driver,"RegisterAccount");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * @Test testcase of registerAccountFailureest(TC_02)
     */
	@Test(enabled = true, priority = 2)
	public void registerAccountFailure() {
		acc.clicksignin();
		acc.createAccountWithoutPhone();
		try {
			BaseClass.takeSnapShot(driver,"RegisterAccountFailure");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * @Test test case of editAccount(TC_08)
     */
	@Test(enabled = true, priority = 2)
	public void editLastName() {
		acc.clicksignin();
		lp.clickLogin();
		acc.editAccount();
		acc.navigateToHomePage();
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
