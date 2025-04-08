package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	 // Declare the class object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
    //Driver initialization
        driver = new FirefoxDriver();
        
      

    //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
    @Test
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
        //Find username and pasword fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        //Click Log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(loginMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}