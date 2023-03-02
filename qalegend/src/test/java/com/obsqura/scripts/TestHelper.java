package com.obsqura.scripts;

import org.testng.annotations.Test;

import com.obsqura.constants.Constans;
import com.obsqura.utilities.ScreenshotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestHelper {

	static WebDriver driver;
	Properties prop;
	FileInputStream ip;
	ScreenshotUtility screenshott = new ScreenshotUtility();
	

	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@BeforeMethod(enabled=true, alwaysRun=true)
	public void launchBrowser() {
		
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		System.out.println("Execution started");
		initialize(browser, url);
	} 

	
	@Parameters("browser")  //cross browser
	@BeforeMethod(enabled= false)
	public void launchCrossBrowserSession(String browser)
	{
		
	
		String url=prop.getProperty("url");
		System.out.println("Execution started");
		initialize(browser, url);
	}
	@AfterMethod()
	public void terminateInstance(ITestResult itestresult)
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			
			screenshott.takeScreenshot(driver, itestresult.getName());
		}
		
	}
	

	public TestHelper() {
		prop = new Properties();

		try {
			
			ip=new FileInputStream(Constans.CONFIG_FILE_PATH);
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
	
	
	
	
	
	
	/*
	 * @BeforeTest public void beforeTest() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.get("https://qalegend.com/billing/public/login");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); }
	 * 
	 * @Test public void f() {
	 * 
	 * }
	 * 
	 * @AfterTest public void afterTest() { }
	 */


