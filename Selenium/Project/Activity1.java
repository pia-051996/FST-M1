package SelJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1
{
    WebDriver driver;

    @BeforeClass
    public void beforeMethod()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase()
    {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Alchemy Jobs – Job Board Application", title);

    }

    @AfterClass
    public void afterMethod()
    {
        driver.quit();
    }

}






