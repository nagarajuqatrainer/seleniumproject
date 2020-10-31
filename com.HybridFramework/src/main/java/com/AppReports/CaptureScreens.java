package com.AppReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreens {
	
public static WebDriver driver;
	
	public static String captureScreenshot(WebDriver driver,String screenname) {
		
		try {
			
			TakesScreenshot element = (TakesScreenshot)driver;
			File file = element.getScreenshotAs(OutputType.FILE);
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String dest = "./AppScreens/"+screenname+dateName+".png";
			File destination = new File(dest);
			System.out.println("captured screen");
			
			FileUtils.copyFile(file, destination);
			return dest;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}


}
