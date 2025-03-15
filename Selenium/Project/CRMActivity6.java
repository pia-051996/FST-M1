package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity6 extends CRMBasePostLoginTest {
//	Goal: Make sure that the “Activities” menu item exists and is clickable
//	a. Open a browser.
//	b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials
//	provided.
//	c. Locate the navigation menu.
//	d. Ensure that the “Activities” menu item exists.
//	e. Close the browser

	@Test
	public void testActivityNavItemExists() {
		Reporter.log("CRMActivity6 -> Activity Nav Item", true);

		WebElement navbarElement = driver.findElement(By.id("grouptab_3"));
		String activityNavMenuText = navbarElement.getText();
		Reporter.log("Activities Nav Menu Text: " + activityNavMenuText, true);
		Assert.assertEquals(activityNavMenuText, "ACTIVITIES");
	}

}
