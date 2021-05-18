package com.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;

import com.opencart.constants.BaseClass;

public class ScrollPage extends BaseClass {

	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	/**
	 * Scroll-Pageup
	 */
	public static void scrollPageup() {
		js.executeScript("window.scrollBy(0,-500");
	}

	/**
	 * Scroll-Pagedown
	 */
	public static void scrollPagedown() {

		js.executeScript("window.scrollBy(0,500)");
		
	}

}
