package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Initialize Firefox driver object
        driver = new FirefoxDriver();
        // Initialize wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }    
    
    @Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		Assert.assertEquals(title, "Selenium: Login Form");
	}
    
    @DataProvider(name = "BadCredentials")
    public static Object[][] creds() {
        return new Object[][] { 
        	{ "admin", "wrongpassword", "Invalid credentials" },
        	{ "wrongAdmin", "password", "Invalid credentials" },
        	{ "wrongAdmin", "wrongPassword", "Invalid credentials" },
        	{ "    ", "     ", "Invalid credentials" },
        };
    }
    
    @Test (priority = 2, dataProvider = "BadCredentials")
    public void failLoginTest(String username, String password, String expectedMessage) {
        driver.navigate().refresh(); // browser refresh
        //Find the input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
//    	Clear the input fields
        usernameField.clear();
        passwordField.clear();
        
        //Enter the credentials and click Log in
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        //Click Log in
        submitButton.click();
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        //Assert Message
        String loginMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(loginMessage, expectedMessage);
    }
    
    @Test(priority = 3)
    public void successLoginTest() {
    	
    }
    

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}
