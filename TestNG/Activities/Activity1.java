package activities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
public class Activity1 {
	
 //Declare Class objects
	
	WebDriver driver;
	
	@BeforeClass //Set up Function
	
  public void setUp() {
	  //Driver Initialization
	
	  driver = new FirefoxDriver();
	
	   //Open the Browser
	  driver.get("https://training-support.net/");
	
	
	
  }
  @Test
public void pageTitleTest() {
	  //Verifying page title
	  assertEquals(driver.getTitle(), "Training Support");
	
	
 }
  @Test
  public void aboutLinkTest() {
	
	  //Find the above page link and click it
	
	  //verify page redirect
	
  }
   @AfterClass //Tear down funtion
  public void tearDown() {
	  //Close the Browser
	   driver.quit();
	
  }
}

        
   