package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;

	// Include alwaysRun property on the @BeforeTest
	// to make sure the page opens
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		// Set up the Firefox driver
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open the browser
		driver.get("https://training-support.net/webelements/target-practice");
	}

	@Test(groups = { "HeaderTests", "ButtonTests" })
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		Assert.assertEquals(title, "Selenium: Target Practice");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
	public void HeaderTest1() {
		WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class,'orange')]"));
		Assert.assertEquals(header3.getText(), "Heading #3");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
	public void HeaderTest2() {
		WebElement header5 = driver.findElement(By.cssSelector("h5.text-purple-600"));
		String elementColor = header5.getCssValue("color");
		Color headerColor = Color.fromString(elementColor);
		Assert.assertEquals(headerColor.asHex(), "#9333ea");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
	public void ButtonTest1() {
		WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
		Assert.assertEquals(button1.getText(), "Emerald");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
	public void ButtonTest2() {
		WebElement button2 = driver.findElement(By.xpath("//button[contains(@class, 'bg-purple-200')]"));
		String elementColor = button2.getCssValue("color");
		Color button2Color = Color.fromString(elementColor);
		Assert.assertEquals(button2Color.asHex(), "#581c87");
	}

	// Include alwaysRun property on the @AfterTest
	// to make sure the page closes
	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		// Close the browser
		driver.close();
	}
}