package restAssuredBasics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PostRequestBodyPojoclass {
	
	
	@Test(priority=1)
	void testPostUsingHashMap() {
		Pojo pojorequest=new Pojo();
		
		
		pojorequest.setName("Scott");
		pojorequest.setLocation("France");
		pojorequest.setPhone("123456");
	String courseArr[]= {"Python", "Java"};
	pojorequest.setCourses(courseArr);
	
	
	given().contentType("application/json")
	.body(pojorequest)
	
	.when()
	.post("http://localhost:3000/students")
	
	.then()
	.statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location", equalTo("France"))
	.body("phone", equalTo("123456"))
	.body("courses[0]",equalTo("Python"))
	.body("courses[1]",equalTo("Java"))
	.header("Content-Type", "application/json")
	.log().all();
	}
	
	@Test(priority=2)
	void testDelete() {
		
		given()
		.when()
		.delete("http://localhost:3000/students/c331")
		.then()
		.log().body()
		.log().headers()
		.log().cookies();
	}

}
