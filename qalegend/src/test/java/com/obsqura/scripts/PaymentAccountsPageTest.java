package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PaymentAccountsPage;
import com.obsqura.utilities.ExcelUtility;

public class PaymentAccountsPageTest extends TestHelper{
	
	LoginPage loginpage;
	PaymentAccountsPage paymentaccountspage;
	ExcelUtility excelutility = new ExcelUtility();
	
  @Test
  public void verifyNewAccountCreation() {
	  
	  loginpage = new LoginPage(driver);
	  paymentaccountspage = new PaymentAccountsPage(driver);
	  loginpage.userLogin("admin", "123456");
	  excelutility.selectExcelFile("PaymentAccount", "listAccounts");
	  paymentaccountspage.clickOnPaymentAccounts();
	  paymentaccountspage.clickOnListAccounts();
	  paymentaccountspage.clickOnAdd();
	  String name=excelutility.getCellData(0, 0);
	  String accountnumber=excelutility.getCellData(0, 1);
	  String openingbalance=excelutility.getCellData(0, 2);
	  String note=excelutility.getCellData(0, 3);
	  paymentaccountspage.paymentAccountsAdd(name, accountnumber, openingbalance, note);
	  String expectedAlertMessage="Account created successfully";
	  Assert.assertEquals(paymentaccountspage.getAccountCreationMessage(), expectedAlertMessage);
  }
}
