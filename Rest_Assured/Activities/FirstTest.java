package Examples;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class FirstTest {
		    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
	@Test
	public void getPetWithQueryParam() {
		//Given: contains requirements for the request
		//When: send request and receiving response
		Response response =
				//Given: contains requirements for the request
				given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json")
				.queryParam("status", "alive")
				.when()
			.get("findByStatus");
			//print response status code
		System.out.println(response.getStatusCode());
		
		//print response headers
		System.out.println(response.getHeaders().asList());
		
		//print response body
		System.out.println(response.getBody().asPrettyString());
		
		//Extract individual properties
		String petStatus = response.then().extract().path("[0]['status']");
		assertEquals(petStatus,"alive");
		
		//Then: Response extraction and assertion
		response.then().statusCode(200).body("[0]['status']",equalTo("alive"));
		
	}
		
	    // GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getPetWithPathParam() {
		//Given: contains requirements for the request
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.pathParam("petId", 66362)
		//When: send request and receiving response
		.when()
		.get("/{petId}")
		//Then: Response extraction and assertion
		.then()
	.statusCode(200)
	.body("status", equalTo("alive"));
	
		
		}
	}








