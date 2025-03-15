package project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity8 extends CRMBasePostLoginTest {
//	Goal: Open the accounts page and print the contents of the table.
//	a. Open the browser to the Alchemy CRM site and login.
//	b. Navigate to the Sales -> Accounts page.
//	c. Find the table on the page and print the names of the first 5 odd-numbered rows
//	of the table to the console.
//	d. Close the browser.

	@Test
	public void testAccountsTable5Names() {
		Reporter.log("CRMActivity8 -> Find the first 5 Account Names", true);

		WebElement salesNavElement = driver.findElement(By.id("grouptab_0"));
		salesNavElement.click();
		WebElement accountsMenuElement = driver.findElement(By.id("moduleTab_9_Accounts"));
		accountsMenuElement.click();

		Reporter.log("Waiting for the page to load");

		// Wait for the page to load and show the LEADS label above the table
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='module-title-text']"),
				"ACCOUNTS"));

		Reporter.log("Waiting for the ACCOUNTS table to load");
		// Wait for the table to load with atleast 1 row
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//table[@class='list view table-responsive']/tbody/tr"), 1));

		List<WebElement> allOddRowNameCells = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[@class='oddListRowS1']//td[@type='name']//a"));
		int count = 0;
		for (Iterator<WebElement> iterator = allOddRowNameCells.iterator(); iterator.hasNext();) {
			if(count < 5) {
				WebElement cell = (WebElement) iterator.next();
				
				String name = cell.getText();
				Reporter.log("Account Name: " + name, true);
			} else {
				break;
			}
			count++;
		}
	}

}
