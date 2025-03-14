package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://training-support.net/webelements/login-form");
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
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        //Assert Message
        String loginMessage = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, Admin!");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}
