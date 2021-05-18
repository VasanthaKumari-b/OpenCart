package com.opencart.testscripts;

import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.opencart.constants.BaseClass;
import com.opencart.pages.FileUpload;
import org.testng.annotations.Test; 

/**
 * Unit test for FileUpload script.
 */
public class FileUploadTestScript extends BaseClass{
    
	 FileUpload fu;
	
	/**
     *  Constuctor of FileUploadTest
     */
    public FileUploadTestScript(  )
    {
        super( );
    }
    
     /**
     * Launch the url
     * @param browser
     */
    @Parameters({"browser"})
	@BeforeMethod
	public void beforemethod(String browser) throws FileNotFoundException {
		openURL(browser);
		fu = new FileUpload();
    }
    /**
     * @Test testcase of fileupload(TC_09)
     */
   @Test
	public void uploadFile() {
		fu.selectproductfromcompenent();
		fu.addtocartoptions();
		try {
			BaseClass.takeSnapShot(driver,"FileUpload");
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
				BaseClass.takeSnapShot(driver,"FileUpload_Fail");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(name + "---------Skiped");
			try {
				BaseClass.takeSnapShot(driver,"FileUpload_skip");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.close();
		driver.quit();

	}

}

