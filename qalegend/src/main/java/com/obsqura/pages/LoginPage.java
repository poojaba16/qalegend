package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver driver;

	  @FindBy(xpath="//input[@id='username']")
	  WebElement username;
	  @FindBy(xpath="//input[@id='password']")
	  WebElement password;
	  @FindBy(xpath="//button[@type='submit' and @class='btn btn-primary']")
	  WebElement loginbutton;
	  @FindBy(xpath="//span[text()='vishwanadhan Aanadh']")
	  WebElement profilename;
	  @FindBy(xpath="//input[@type='checkbox']")
	  WebElement rememberme;
	  @FindBy(xpath="//button[@data-role='end']")
	  WebElement endtour;
	  
	  
		public void userLogin(String usname, String pswd)
		{
			
			username.sendKeys(usname);
			password.sendKeys(pswd);
			rememberme.click();
			loginbutton.click();
			endtour.click();
			
			
		}
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
}
