package Log4J;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTestMethod {
	Logger log = Logger.getLogger(LoginTestMethod.class);
	WebDriver driver;

	@BeforeSuite
	public void connecttodb() {
		log.info("connect to database");

	}

	@BeforeClass
	public void openBrowse() {
		log.info("Opening the Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void login() {
		log.info("Login");
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();

	}

	@AfterClass
	public void closebrowser() {
		log.info("Close the Browser");
		driver.close();

	}

	@AfterSuite
	public void disconnectdb() {
		log.info("Disconnect to Database");

	}

}
