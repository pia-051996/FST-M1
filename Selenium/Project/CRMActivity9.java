package project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity9 extends CRMBasePostLoginTest {
//	Goal: Open the leads page and print the usernames and full names from the table.
//	a. Open the browser to the Alchemy CRM site and login.
//	b. Navigate to the Sales -> Leads.
//	c. Find the table on the page and print the first 10 values in the Name column and
//	the User column of the table to the console.
//	d. Close the browser.

	@Test
	public void testAccountsTable5Names() {
		Reporter.log("CRMActivity9 -> Find the first 10 Leads Names along with User", true);

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

		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
		int count = 0;
		for (Iterator<WebElement> iterator = allRows.iterator(); iterator.hasNext();) {
			if(count < 10) {
				WebElement row = (WebElement) iterator.next();
				//type = name
				WebElement nameCell = row.findElement(By.xpath(".//td[@type='name']//a"));
				//type = relate
				WebElement userCell = row.findElement(By.xpath(".//td[@type='relate']//a"));
				Reporter.log("Lead Name: " + nameCell.getText() + " User: " + userCell.getText(), true);
			} else {
				break;
			}
			count++;
		}
	}

}
