package com.vitger.POMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vitger.generics.FileUtile;
import com.vitger.generics.IAutoconstant;
import com.vitger.generics.webdriverutile;

public class Baseclass implements IAutoconstant {

	public WebDriver driver;
	public Applogin login;

	@BeforeSuite
	public void setUp() {
		System.out.println("Connect to DB");
	}

	@BeforeClass
	public void BrowserLunchandGetUrl() throws IOException {	
		String Browser = FileUtile.objforfileutil().readDatafromPropfile("browser");
		System.out.println(Browser);
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();

		}
		String url = FileUtile.objforfileutil().readDatafromPropfile("url");
		driver.get(url);
		webdriverutile Methods = new webdriverutile(driver);
		Methods.MaxiniseWindow();

	}

	@BeforeMethod
	public void LoginintoApp() throws IOException {
		login = new Applogin(driver);
		login.login();
	}

	@AfterMethod
	public void LogoutApp() throws InterruptedException {
		Homepage home = new Homepage(driver);
		home.LogoutfromApp();
	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}

	@AfterSuite
	public void disconnectfromDB() {
		System.out.println("disconnect");
	}

}
