package activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<Object>> readExcel(String filePath) {
        List<List<Object>> data = new ArrayList<>();
        try {
            // Read the file as a stream
            FileInputStream file = new FileInputStream(filePath);

            // Create the workbook
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from that workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Set up a Data Formatter
            DataFormatter dataFormatter = new DataFormatter();

            // Iterate through all the rows one by one
            for (Row row: sheet) {
                // Temp var
                List<Object> rowData = new ArrayList<>();
                // Iterate over all the cells one by one
                for(Cell cell: row) {
                    rowData.add(cell.getStringCellValue());
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "src/test/resources/employees.xlsx";
        List<List<Object>> data = readExcel(filePath);
        return new Object[][] {
                { data.get(1) },
                { data.get(2) },
                { data.get(3) },
        };
    }

    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows) {
        WebElement fullName = driver.findElement(By.id("full-name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement eventDate = driver.findElement(By.name("event-date"));
        WebElement details = driver.findElement(By.id("additional-details"));

        // Clear the fields
//        fullName.clear();
//        emailField.clear();
//        eventDate.clear();

        // Enter the data
        fullName.sendKeys(rows.get(0).toString());
        emailField.sendKeys(rows.get(1).toString());
        eventDate.sendKeys(rows.get(2).toString().replaceAll("\"",""));
        details.sendKeys(rows.get(3).toString());

        // Click on the submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        //Confirm booking
        String message = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(message, "Your event has been scheduled!");
        // Refresh the page
        driver.navigate().refresh();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}