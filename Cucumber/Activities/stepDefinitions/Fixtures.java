package stepDefinitions;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Fixtures extends BaseClass {
    @BeforeAll
    public static void setUp() {
        // Initialize Firefox Driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Setup done");
    }
    
    @AfterAll
    public static void tearDown() {
        // Close the browser
    	System.out.println("All tear down done");
        driver.quit();
    }
}

