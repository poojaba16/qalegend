package com.obsqura.scripts;

import org.testng.annotations.Test;



import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPageTest extends TestHelper {

	@Test(groups="smoke")
	public void validLogin() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.userLogin("admin", "123456");

		System.out.println("Excel1");
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.selectExcelFile("LoginData", "validcredentials");
		excelutility.getCellData(0, 0);
		System.out.println(excelutility.getCellData(0, 0));

		// HomePage homepage=new HomePage(driver);
		// Assert.assertTrue(homepage.isHomePageLoaded());

	}

}
