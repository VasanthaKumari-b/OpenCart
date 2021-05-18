package com.opencart.listeners;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	static ExtentReports extent = ExtentManager.getInstance();
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	/**
	 * Get the details of ExtentTest
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/**
	 * End ExtentTest
	 */
	public static synchronized void endTest() {
		extent.flush();
	}

	/**
	 * Start ExtentTest
	 */
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

}
