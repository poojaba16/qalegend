package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class UserManagement {

	WebDriver driver;
	WaitUtility waitutility;
	GenericUtility genericutility;

	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagement;

	///// Uesrs//////
	
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	WebElement users;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement addbutton;
	@FindBy(id="surname")
	WebElement prefixelement;
	@FindBy(id="first_name")
	WebElement firstnameelement;
	@FindBy(id="last_name")
	WebElement lastnameelement;
	@FindBy(id="email")
	WebElement emailelement;
	//@FindBy(id="select2-role-container")
	//WebElement roleelement;
	//Select s=new Select(role);
	//s.selectByVisibleText("Engineer");
	@FindBy(id="password")
	WebElement passwordelement;
	@FindBy(id="confirm_password")
	WebElement confirmpswdelement;
	@FindBy(id="cmmsn_percent")
	WebElement salescomsnpercentelement;
	@FindBy(id = "username")
	WebElement usernameelement;
	@FindBy(id="select2-role-container")
	WebElement clickrole;
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
	WebElement roleelement;
	@FindBy(xpath = "//div[@class='icheckbox_square-blue']//ins[@class='iCheck-helper']")
	WebElement allowselectcontactelement;
	@FindBy(xpath="//ul[@class='select2-selection__rendered']")
	WebElement selectcontactsclickelement;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement selectcontactselement;
    @FindBy(id="submit_user_button")
	WebElement savebuttonelement;
	@FindBy(xpath="//input[@id='status_span']")
	WebElement successmessage;

	///// Roles/////

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles']")
	WebElement roleselement;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles/create']")
	WebElement rolesaddbuttonelement;
	@FindBy(id="name")
	WebElement rolesnameelement;
	

	///// SalesCommissionAgents

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/sales-commission-agents']")
	WebElement salescommissionagentsbutton;
	@FindBy(xpath = "//button[@data-href='https://qalegend.com/billing/public/sales-commission-agents/create']")
	WebElement salescommissionagentsaddbutton;
	
	public UserManagement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUserManagement()
	{
		usermanagement.click();
		
	}
	public void clickOnUsers()
	{
		users.click();
		
	}
	public void clickOnAdd()
	{
		addbutton.click();
		
	}
	public void selectRole(String role)
	{
		clickrole.click();
		roleelement.sendKeys(role+Keys.ENTER);
	
	}
	public void allowselectContact()
	{
		allowselectcontactelement.click();
	}
	public void selectContactsElement(String selectcontacts)
	{
		selectcontactsclickelement.click();
		selectcontactselement.sendKeys(selectcontacts+Keys.ENTER);
	}



	public void createUser(String prefix, String firstName, String lastName, String email, String password, String confirmpswd, String salescomsnpercent,String role, String username, String selectcontacts)
	{
		waitutility = new WaitUtility(driver);
		waitutility.waitForVisibility(prefixelement);
		prefixelement.sendKeys(prefix);
		firstnameelement.sendKeys(firstName);
		lastnameelement.sendKeys(lastName);
		emailelement.sendKeys(email);
		usernameelement.sendKeys(username);
		selectRole(role);
		passwordelement.sendKeys(password);
		confirmpswdelement.sendKeys(confirmpswd);
		salescomsnpercentelement.sendKeys(salescomsnpercent);
		selectContactsElement(selectcontacts);
		savebuttonelement.click();
		
	}
 public String getUserCreationMessage()
 {
	 return successmessage.getAttribute("data-msg");
	 
 }
 public boolean isAlertMessageDisplayed(String expectedMessage)
 {
	 genericutility = new GenericUtility();
	 return genericutility.is_TextAsExpected(successmessage, expectedMessage);
 }
 
     //roles////
 
	public void clickOnRoles()
	{
		roleselement.click();
		
	}
	public void clickOnRolesAdd()
	{
		rolesaddbuttonelement.click();
		
	}
	public void roleCreation()
	{
		
	}
	

}
