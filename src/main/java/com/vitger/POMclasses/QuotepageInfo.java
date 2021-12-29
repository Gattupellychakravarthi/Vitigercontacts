package com.vitger.POMclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotepageInfo {

	@FindBy(xpath = "//img[@title='Create Quote...']")
	private WebElement createQuoteimgclick;
	@FindBy(xpath = "//a[text()='Quotes']")
	private WebElement clickonQuoteinfo;

	public WebElement getCreateQuoteimgclick() {
		return createQuoteimgclick;
	}

	public WebElement getClickonQuoteinfo() {
		return clickonQuoteinfo;
	}

	public void ceatequoteimg() {
		createQuoteimgclick.click();
	}

	public void quoteinfo() {
		clickonQuoteinfo.click();
	}

}
