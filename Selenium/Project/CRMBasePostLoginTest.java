package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CRMBasePostLoginTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/crm");
		
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginElement = driver.findElement(By.xpath("//input[@id='bigbutton']"));

		// Send keys to username and password
		userNameElement.sendKeys("admin");
		passwordElement.sendKeys("pa$$w0rd");
		loginElement.click();

	}

	@AfterClass
	public void afterClass() {
		// Tear down
		driver.quit();
	}

}
