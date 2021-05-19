
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

public class BaseClass {
		
		public static WebDriver driver;
		public static Properties prop;
		public  static WebDriverWait wait;
		 static Logger log = Logger.getLogger(BaseClass.class);
		
		/**
	     *  Load Properties File 
	     */
		public BaseClass() {
				prop = new Properties();
				PropertyConfigurator.configure("log4j.properties");	
				FileInputStream file;
				try {
					file = new FileInputStream("C:\\Users\\user\\workspace\\OpenCart\\src\\main\\java\\com\\opencart\\config\\config.properties");
					prop.load(file);
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
			log.debug("Debug this path for chrome path issue");
			WebDriver driver = new ChromeDriver();
			log.info("Chrome driver is up and running");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			log.warn("Url is not loaded properly");
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
		public static void takeSnapShot(WebDriver webdriver,String screenshotName) throws Exception{

			Date d=new Date();
			String dateString = d.toString().replace(":", "_").replace(" ", "_");
			
			String destPath ="C:\\Users\\user\\workspace\\YLigthingDemo\\screenshot\\" + dateString + screenshotName + ".png";

			 File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File DestFile = new File(destPath);
		        FileUtils.copyFile(scr, DestFile); 
		     		}
		}
