package com.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppObjects.LoginObjects;
import com.AppReports.CaptureScreens;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class LoginTestCase   {
	
	public static WebDriver driver;
	public static BrowserFac browser;
	public static ConfigRead config;
	public static LoginObjects loginpage;
	public static CaptureScreens capture;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	
	
@ BeforeSuite
public void AppSuite() {
	browser=new BrowserFac();
	config=new ConfigRead();
	loginpage = new LoginObjects(driver);
	capture=new CaptureScreens();
	report = new ExtentReports("./AppReports/testreport.html",true);
}
	     
	
@BeforeTest
public void launchBrowser() {
	logger=report.startTest("sample extent test");
	driver=BrowserFac.getBrowser(config.getbrowsername(), config.getbrowserurl());
}
	
 @Test
    public void verifySeleniumTest()
    {
       
	String title = driver.getTitle();
	logger.log(LogStatus.INFO, "verify title");
	System.out.println("verify title");
    loginpage=PageFactory.initElements(driver, LoginObjects.class);
    loginpage.getusername(config.getusername(), config.getpassword());
    loginpage.clickloginbutton();
    CaptureScreens.captureScreenshot(driver, "screen1");
    logger.log(LogStatus.INFO, "click button");
  
    	
    }
 
 
 @AfterMethod
 public void getextentresults(ITestResult result) {
	 
	 if(result.getStatus()==ITestResult.FAILURE){
		  String screenShotPath = CaptureScreens.captureScreenshot(driver, "test");
			String image = logger.addScreenCapture(screenShotPath);
			logger.log(LogStatus.INFO, "click button",image);
	 }
	 
 }
    
  
 @AfterClass
 public void endTest() {
	 report.flush();
	 report.endTest(logger);
 }
 
 
 
  @AfterTest
  public void closeBrowser() {
	  browser.closebrowser();
  }
    
}
