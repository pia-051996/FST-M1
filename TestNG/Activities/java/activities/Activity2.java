package activities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    @BeforeTest
    public void beforeMethod() {
        // Set up the Firefox driver
        //WebDriverManager.firefox().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    
    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        assertEquals(title, "Target Practice");
    }
    
    @Test
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        assertTrue(blackButton.isDisplayed());
        assertEquals(blackButton.getText(), "Black");
    }
    
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        assertTrue(subHeading.contains("Practice"));
    }
    
    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");      
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
