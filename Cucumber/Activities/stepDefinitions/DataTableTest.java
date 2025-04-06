package stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableTest extends BaseClass{
	
	@Given("user is on the to-do list page")
	public void verifyPage() {
		
		driver.get("https://training-support.net/webelements/todo-list");
		assertEquals("Selenium: To-Do List", driver.getTitle());
		
	}
	
	
	@When("user provides the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException{
		
		List<String> tasks = inputTasks.asList();
		// asList() can be used based on the data, it can be asMaps()
		//if we have multiple columns make List<List<String>>
		
		System.out.println(tasks);
		
		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			driver.findElement(By.id("todo-add")).click();
		}
		
		
	}
	
	@Then("they can see the task added to the list")
	public void verifyResults() {
		WebElement lis = driver.findElement(By.xpath("//h3[contains(@class, 'text-')]"));
		
		System.out.println(lis.getText());
	}
	

}
