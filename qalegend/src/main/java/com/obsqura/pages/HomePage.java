package com.obsqura.pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='vishwanadhan Aanadh']")
	WebElement profilename;
	
	public void home()
	{
		String name=profilename.getText();
		System.out.println(name);
	}
	
	public boolean isHomePageLoaded()
	{
		return profilename.isDisplayed();
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
