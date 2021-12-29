package com.vitger.POMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitger.generics.FileUtile;

public class Applogin {

	WebDriver driver;
	@FindBy(name = "user_name")
	private WebElement username;

	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public Applogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login() throws IOException {
		username.sendKeys(FileUtile.objforfileutil().readDatafromPropfile("user"));
		password.sendKeys(FileUtile.objforfileutil().readDatafromPropfile("password"));
		loginbtn.click();

	}

	public void login(String newusername, String newpassword) {
		username.sendKeys(newusername);
		password.sendKeys(newpassword);
		loginbtn.click();

	}

}
