
package com.opencart.constants;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
		
		public static WebDriver driver;
		public static Properties prop;
		public  static WebDriverWait wait;
		final static Logger logger = Logger.getLogger(BaseClass.class);
		
		/**
	     *  Load Properties File 
	     */
		public BaseClass() {
				prop = new Properties();
				FileInputStream file,file1;
				try {
					file = new FileInputStream("C:\\Users\\user\\workspace\\OpenCart\\src\\main\\java\\com\\opencart\\config\\config.properties");
					file1= new FileInputStream("C:\\Users\\user\\workspace\\OpenCart\\src\\main\\java\\com\\opencart\\config\\log4j.properties");
					prop.load(file);
					prop.load(file1);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		/**
	     *  Launch Chrome Browser 
	     */
		
		public static WebDriver gotoChromeDriver() {
			PropertyConfigurator.configure("log4j.properties");
			//System.out.println("Script running by google chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\workspace\\OpenCart\\Drivers\\chromedriver.exe");
			logger.debug("Debug this path for chrome path issue");
			WebDriver driver = new ChromeDriver();
			logger.info("Chrome driver is up and running");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			logger.warn("Url is not loaded properly");
			return driver;
		}
		/**
	     *  Launch Firefox Browser 
	     */
		
		public static WebDriver gotoFirefoxDriver() {
			System.out.println("Script running by Firefox browser");
			System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\workspace\\OpenCart\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			return driver;
		}
		
		
		/**
	     *  Cross  Browsing 
	     */
		 public static void openURL(String browsertype){
					
			if(browsertype.equals("chrome")) {
				driver = gotoChromeDriver();
			}
			if(browsertype.equals("firefox")) {
				driver = gotoFirefoxDriver();
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
  
		}
		
		/**
	     *  Take Screenshots 
	     */
		public static void takeSnapShot(WebDriver webdriver,String Filename) throws Exception{

			 File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 Date d=new Date();
		        File dest = new File("screenshot/" + Filename +d.toString().replace(":", "_")+".png");
		        FileUtils.copyFile(scr, dest); 
		     		}
		}
