package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class Activity3 extends BaseClass{

	Alert alert;
	@Given("User is on the page")
	public void verifyPage() {
		driver.get("https://training-support.net/webelements/alerts");
		assertEquals("Selenium: Alerts", driver.getTitle());
	}
	
	@When("User clicks the Simple Alert button")
	public void simpleALert() {
		
		driver.findElement(By.id("simple")).click();
	}
	
	@When("User clicks the Confirm Alert button")
	public void confirmALert() {
		
		driver.findElement(By.id("confirmation")).click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void promptALert() {
		
		driver.findElement(By.id("prompt")).click();
	}
	
	@Then("Alert opens")
	public void verifyAlertPop() {
		
	    alert = driver.switchTo().alert();
		
	}
	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println(alert.getText());
		}
	@And("Close the alert")
	public void closeAlert(){
		alert.accept();
	}
	
	@And("Close the alert with Cancel")
	public void closeAlertWithCancel() {
		alert.dismiss();
	}
	
	@And("Write a custom message in it")
	public void sendValues() {
		alert.sendKeys("Madhu");
	}
	
	@And("Read the result text")
	public void readResult() {
		String res = driver.findElement(By.id("result")).getText();
		System.out.println(res);
	}
		
}
