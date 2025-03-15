package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity4 extends CRMBaseTest {
//	Logging into the site
//	Goal: Open the site and login with the credentials provided
//	a. Open the browser
//	b. Navigate to ‘https://alchemy.hguy.co/crm’.
//	c. Find and select the username and password fields
//	d. Enter login credentials into the respective fields
//	e. Click login
//	f. Verify that the homepage has opened.
//	g. Close the browser.

	@Test
	public void testLogin() {
		Reporter.log("CRMActivity4 -> Login Test", true);

		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginElement = driver.findElement(By.xpath("//input[@id='bigbutton']"));

		// Send keys to username and password
		userNameElement.sendKeys("admin");
		passwordElement.sendKeys("pa$$w0rd");
		loginElement.click();

		// Verify that after login we are in the dashboard.
		// We can check by verifying the Tab name to "SUITECRM DASHBOARD"
		WebElement dashboardTabElement = driver.findElement(By.id("tab0"));
		String dashboardTabText = dashboardTabElement.getText();
		Assert.assertEquals(dashboardTabText, "SUITECRM DASHBOARD");
	}

}
