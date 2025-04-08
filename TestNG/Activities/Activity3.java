package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	// Declare the class object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
    //Driver initialization
        driver = new FirefoxDriver();
        //Open browser
    	
        driver.get("https://training-support.net/webelements/login-form");
	
    }
	
 	
    @Test
	
    public void loginTest() {
	
        //Find the username and password fields
	
        WebElement username = driver.findElement(By.id("Username"));
	
        WebElement password = driver.findElement(By.id("Password"));
	
        
	
        //Enter credentials
	
        username.sendKeys("admin");
	
        password.sendKeys("password");
	
        
	
        //Click login
	
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	
        
	
        //Read login message
	
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	
        assertEquals("Welcome Back, admin", loginMessage);
	
    }
	
 
	
    @AfterClass
	
    public void afterClass() {
	
        //Close browser
	
        driver.close();
	
    }
}
        