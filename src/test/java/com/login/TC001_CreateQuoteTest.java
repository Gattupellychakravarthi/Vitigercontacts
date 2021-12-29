package com.login;

import org.testng.annotations.Test;

import com.vitger.POMclasses.Baseclass;
import com.vitger.POMclasses.Homepage;
import com.vitger.POMclasses.QuotepageInfo;

public class TC001_CreateQuoteTest extends Baseclass {
	@Test
	public void creatQuote() throws InterruptedException {	
		Homepage home = new Homepage(driver);
		QuotepageInfo quote = new QuotepageInfo();
		home.selectquotedd();
		quote.ceatequoteimg();
		quote.getClickonQuoteinfo();
		

	}

}
