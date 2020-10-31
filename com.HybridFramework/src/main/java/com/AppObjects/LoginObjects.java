package com.AppObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SeleniumProject.ConfigRead;


public class LoginObjects {
	
	
	public WebDriver driver;
	public static ConfigRead repo = new ConfigRead();
	public static WebDriverWait wait;




	By uname = By.name(repo.getunelement());
	By pword = By.name(repo.getpwelement());
	By lbutton = By.name(repo.getbuttonelement());
	By homelink = By.xpath(repo.getHomeLink());

	/*
		@FindBy(name="unrepo")
		WebElement username;
		
		@FindBy(name="pass")
		WebElement password;

		@FindBy(name="btnSubmit")
		WebElement button;
		*/
		
	//Waiting methods are three types
	//1) Implicity wait - page is loading
	//2) Explicity wait - If we want to wait until loading objects
	//3) fluent wait


		public LoginObjects(WebDriver driver) {
			this.driver=driver;
			
		}
		
		
	public void getusername(String un,String pw) {
			
		driver.findElement(uname).sendKeys(un);
		driver.findElement(pword).sendKeys(pw);
		
		}
			
		public void clickloginbutton() {
			
			wait= new WebDriverWait(driver,10);
			
			WebElement submit = driver.findElement(lbutton);
			if(submit.isEnabled()) {
			wait.until(ExpectedConditions.visibilityOf(submit));
				submit.click();
			}
		}

		public void clickhomelink() {
			WebElement lbutton =driver.findElement(homelink);		
			if(lbutton.isEnabled()) {
				wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(homelink)));
				lbutton.click();
				System.out.println("passed");
			}
			else
			{
				System.out.println("Fail");
			}
			
			
			
		}

}
