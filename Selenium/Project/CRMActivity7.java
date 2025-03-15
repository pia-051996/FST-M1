package project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity7 extends CRMBasePostLoginTest {
//	Reading additional information
//	Goal: Reading a popup that contains additional information about the account/lead.
//	a. Open the browser to the Alchemy CRM site and login.
//	b. Navigate to Sales -> Leads
//	c. In the table, find the Additional information icon at the end of the row of the lead
//	information. Click it.
//	d. Read the popup and print the phone number displayed in it.
//	e. Close the browser

	@Test
	public void testSalesToLeadsMenuItem() {
		Reporter.log("CRMActivity7 -> Find phone numbers of all Leads wherever available", true);

		WebElement salesNavElement = driver.findElement(By.id("grouptab_0"));
		salesNavElement.click();
		WebElement leadsMenuElement = driver.findElement(By.id("moduleTab_9_Leads"));
		leadsMenuElement.click();

		Reporter.log("Waiting for the page to load");

		// Wait for the page to load and show the LEADS label above the table
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='module-title-text']"),
				"LEADS"));

		Reporter.log("Waiting for the LEADS table to load");
		// Wait for the table to load with atleast 1 row
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//table[@class='list view table-responsive']/tbody/tr"), 1));

		// Now that the table is visible, we can get the total cells with "i"
		// xpath is //span[@class='suitepicon suitepicon-action-info']
		List<WebElement> allCellsWithI = driver
				.findElements(By.xpath("//span[@class='suitepicon suitepicon-action-info']"));
		for (Iterator<WebElement> iterator = allCellsWithI.iterator(); iterator.hasNext();) {
			WebElement cell = (WebElement) iterator.next();
			cell.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Wait for the pop up to be visible
			//Below lines are not working when running the code, works in Debug
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
			//		"//div[contains(@class,'ui-dialog ui-widget ui-widget-content') and contains(@style,'display: block')]"))));
			
			// Note that all the pops are present in the table ( Bad design, just that they
			// are all invisible )

			// The next challenge is that phone text may not be present in the popup.
			// If you directly try to find then Exception occurs
			try {
				WebElement visiblePhoneTextElement = driver.findElement(By.xpath(
						"//div[contains(@class,'ui-dialog ui-widget ui-widget-content') and contains(@style,'display: block')]//span[@class='phone']"));
				Reporter.log("Phone number is: " + visiblePhoneTextElement.getText(), true);

			} catch (NoSuchElementException e) {
				Reporter.log("Phone field is not present in DOM", true);
			}
		}
	}

}
