package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/");
	}

	@Test(priority = 1)
	public void pageTitleTest() {
		System.out.println("page title test has started"); //This test is run first because of higher priority
		assertEquals(driver.getTitle(), "Training Support");
	}

	@Test(priority = 2)
	public void aboutlinkTest() {
		System.out.println("about link test has started");//This test is run second due to lower priority. Higher number means lower priority
		//Find the about page link and click it
		driver.findElement(By.linkText("About Us")).click();
		assertEquals(driver.getTitle(), "About Training Support");
		
		//Verify page redirect //do it in another test
	}

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}

}
