package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;

public class HomePageTest extends TestHelper {

	@Test(groups= {"smoke","regression"})
	public void checkHomePageLoaded() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.userLogin("admin", "123456");
		HomePage homepage = new HomePage(driver);
		homepage.isHomePageLoaded();
		Assert.assertTrue(homepage.isHomePageLoaded(), "home page not loaded");
	}
}
