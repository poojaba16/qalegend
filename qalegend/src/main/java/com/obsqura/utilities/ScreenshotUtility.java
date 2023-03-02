package com.obsqura.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.obsqura.constants.Constans;

public class ScreenshotUtility {

	TakesScreenshot takesscreenshot;

	public void takeScreenshot(WebDriver driver, String imageName) {

		try {

			takesscreenshot = (TakesScreenshot) driver;
			File screenshot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constans.SCREENSHOT_PATH + imageName + "_" + timeStamp + ".png";
			File destination = new File(path);
			FileHandler.copy(screenshot, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
