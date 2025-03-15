package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity3 extends CRMBaseTest {
//	Get the copyright text
//	Goal: Print the first copyright text in the footer to the console
//	a. Open a browser.
//	b. Navigate to ‘https://alchemy.hguy.co/crm’.
//	c. Get the first copyright text in the footer.
//	d. Print the text to the console.
//	e. Close the browser.

	@Test
	public void testCopyrightText() {
		Reporter.log("CRMActivity3 -> Copyright print Test", true);

		WebElement copyrightElement = driver.findElement(By.id("admin_options"));
		String copyrightText = copyrightElement.getText();

		Reporter.log("Copyright Text is: " + copyrightText, true);

	}
}
