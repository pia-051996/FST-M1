package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity5 extends CRMBasePostLoginTest {
//	Goal: Get the color of the navigation menu
//	a. Open a browser.
//	b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials
//	provided.
//	c. Get the color of the navigation menu and print it to the console.
//	d. Close the browser.

	@Test
	public void testNavigationMenuColor() {
		Reporter.log("CRMActivity5 -> Navigation Menu Color", true);

		WebElement navbarElement = driver.findElement(By.xpath("//nav[contains(@class,'navbar')]"));
		String elementColor = navbarElement.getCssValue("color");
		Color headerColor = Color.fromString(elementColor);
		Reporter.log("Color of the Navigation bar in HEX is: " + headerColor.asHex(), true);
		Reporter.log("Color of the Navigation bar in RGB is: " + headerColor.asRgb(), true);
		Assert.assertEquals(headerColor.asHex(), "#534d64");
	}

}
