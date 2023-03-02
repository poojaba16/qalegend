package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockAdjustmentPage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Stock Adjustment']")
	WebElement stockadjustmentelement;

	
	//add
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/stock-adjustments/create']")
	WebElement addstockadjustment;
	@FindBy(id="transaction_date")
	WebElement dateelement;
	@FindBy(xpath="//input[@id='transaction_date']")
	WebElement monthtextelement;
	
	
	public void clickOnStockAdjustment()
	{
		stockadjustmentelement.click();
	}
	
	public void clickOnAddStockAdjustment()
	{
		addstockadjustment.click();
	}
	
	public void selectDate()
	{
		
	}
	
	public void addStockAdjustment()
	{
		
	}
	
	
	
	
	
	
	
	
	public StockAdjustmentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	
}
