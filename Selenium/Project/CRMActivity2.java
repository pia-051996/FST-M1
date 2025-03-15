package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity2 extends CRMBaseTest {
//	Get the url of the header image
//	Goal: Print the url of the header image to the console
//	a. Open a browser.
//	b. Navigate to ‘https://alchemy.hguy.co/crm’.
//	c. Get the url of the header image.
//	d. Print the url to the console.
//	e. Close the browser
	@Test
	public void testHeaderImage() {
		Reporter.log("CRMActivity2 -> HeaderImage url print Test", true);

		WebElement headerImageElement = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String headerURL = headerImageElement.getDomAttribute("src");

		Reporter.log("URL of the header image is: " + headerURL, true);
	}
}
