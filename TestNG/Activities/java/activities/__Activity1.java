package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class __Activity1 {
    // Declare the WebDriver object
    WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        //WebDriverManager.firefox().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
            //Assertion for page title
        assertEquals("Training Support", title);
                    
        //Find the clickable link on the page and click it
        driver.findElement(By.id("about-link")).click();
                    
        //Print title of new page
        System.out.println("New page title is: " + driver.getTitle());
        
        assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        //Close the browser
        driver.quit();
    }

}