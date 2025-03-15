package project;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CRMActivity1 extends CRMBaseTest{
//	Goal: Read the title of the website and verify the text
//	a. Open a browser.
//	b. Navigate to ‘https://alchemy.hguy.co/crm’.
//	c. Get the title of the website.
//	d. Make sure it matches “SuiteCRM” exactly.
//	e. If it matches, close the browser.

  @Test
  public void titleTest() {
	  Reporter.log("CRMActivity1 -> Title Test", true);
	  String pageTitle = driver.getTitle();
	  Reporter.log("CRM Home page title: " + pageTitle, true);
	  
	  Assert.assertEquals(pageTitle, "SuiteCRM");
  }
}
