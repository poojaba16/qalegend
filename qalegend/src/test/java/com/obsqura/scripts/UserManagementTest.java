package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagement;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.GenericUtility;

public class UserManagementTest extends TestHelper {

	LoginPage loginpage;
	UserManagement usermanagement;
	ExcelUtility excelutility = new ExcelUtility();

	@Test
	public void verifyNewUserCreation() {

		loginpage = new LoginPage(driver);
		usermanagement = new UserManagement(driver);
		
		loginpage.userLogin("admin", "123456");
		excelutility.selectExcelFile("UserManagement", "UserDatas");
		usermanagement.clickOnUserManagement();
		usermanagement.clickOnUsers();
		usermanagement.clickOnAdd();
		usermanagement.allowselectContact();
		
		String role="Engineer";
		String selectcontacts="Tom";
		String prefix=excelutility.getCellData(0, 0);
		String firstName=excelutility.getCellData(0, 1);
		String lastName=excelutility.getCellData(0, 2);
		String email=excelutility.getCellData(0, 3);
		email=email+GenericUtility.getRandomNumber()+"@gmail.com";
		String password=excelutility.getCellData(0, 4);
		String confirmpswd=excelutility.getCellData(0, 5);
		String salescomsnpercent=excelutility.getCellData(0, 6);
		String username=excelutility.getCellData(0,7);
		username=username+GenericUtility.getRandomNumber();
		
		usermanagement.createUser(prefix, firstName, lastName, email, password, confirmpswd, salescomsnpercent, role, username, selectcontacts);
		String expectedMessage="User added successfully";
		Assert.assertTrue(usermanagement.isAlertMessageDisplayed(expectedMessage));

	}
	@Test(dataProvider="UserDatas", dataProviderClass=DataProviders.class)
	public void verifyNew_UserCreation(String prefix, String firstName, String lastName, String email, String password, String confirmpswd, String salescomsnpercent)
	{
		loginpage = new LoginPage(driver);
		usermanagement = new UserManagement(driver);
		loginpage.userLogin("admin", "123456");
		usermanagement.clickOnUserManagement();
		usermanagement.clickOnUsers();
		usermanagement.clickOnAdd();
		usermanagement.createUser(prefix, firstName, lastName, email, password, confirmpswd, salescomsnpercent, "role", "username", "selectcontacts");
	}
}
