package com.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ITlListenerClass.class)
public class ExtendRepots {
	
	WebDriver driver;
	static WebDriver sdriver;

	@Test
	public void getfbTitle() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sdriver=driver;
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(true, true);
	}

	@Test
	public void getTitlefrommvn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(true, false);
	}

	@Test
	public void skipit() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		throw new SkipException("i am Skipping");
		
	}

	public static String takeCreenshort(String name) throws IOException {
		File srcfile = ((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir") + "/Screenshots/" + name + ".png";
		File Filedest = new File(destfile);
		FileUtils.copyFile(srcfile, Filedest);
		return destfile;

	}
}
