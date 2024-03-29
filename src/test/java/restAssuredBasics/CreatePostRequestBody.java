package restAssuredBasics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class CreatePostRequestBody {
	
	@Test(priority=1)
	void testPostUsingHashMap() {
		HashMap students =new HashMap();
		students.put("name", "Scott");
		students.put("location", "France");
		students.put("phone", "123456");
	String courseArr[]= {"C", "C++"};
	students.put("courses", courseArr);
	students.put("courses", courseArr);
	
	given().contentType("application/json")
	.body(students)
	
	.when()
	.post("http://localhost:3000/students")
	
	.then()
	.statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location", equalTo("France"))
	.body("phone", equalTo("123456"))
	.body("courses[0]",equalTo("C"))
	.body("courses[1]",equalTo("C++"))
	.header("Content-Type", "application/json")
	.log().all();
	}
	
	@Test(priority=2)
	void testDelete() {
		
		given()
		.when()
		.delete("http://localhost:3000/students/00b6")
		.then()
		.log().all();
	}

}
