package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage {
	
WebDriver driver;
@FindBy(xpath="//span[text()='Contacts']")
WebElement contactselement;
//suppliers
@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts?type=supplier']")
WebElement supplierselement;
@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
WebElement supplieraddelement;
@FindBy(xpath="//select[@id='contact_type']")
WebElement contacttypeelement;
@FindBy(xpath="//input[@id='name']")
WebElement nameelement;
@FindBy(xpath="//input[@id='supplier_business_name']")
WebElement businessnameelement;
@FindBy(xpath="//input[@id='contact_id']")
WebElement contactidelement;
@FindBy(xpath="//input[@id='tax_number']")
WebElement taxnumberelement;
@FindBy(xpath="//input[@id='opening_balance']")
WebElement openingbalanceelement;
@FindBy(xpath="//input[@id='pay_term_number']")
WebElement paytermnumberelement;
@FindBy(xpath="//select[@class='form-control width-60 pull-left']")
WebElement paytermselectelement;
@FindBy(xpath = "//select[@class='form-control']")
WebElement customergroupelement;
@FindBy(xpath="//input[@id='credit_limit']")
WebElement creditlimitelement;
@FindBy(xpath="//input[@id='email']")
WebElement emailelement;





}
