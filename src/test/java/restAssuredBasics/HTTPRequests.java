package restAssuredBasics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	int id;
	/*
	 * { "name": "morpheus", "job": "leader", "id":
	 * "237", "createdAt": "2024-03-25T15:49:04.684Z" }
	 * 
	 * https://reqres.in/api/users/2
	 */
	@Test(priority=1)
	void getUsers() {
		
		when()
		.get("https://reqres.in/api/users?page=2")

		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
	}

	/*
	 * @Test(priority = 2) void createUser() {
	 * 
	 * HashMap<String, String> hm = new HashMap<String, String>(); hm.put("name",
	 * "katty"); hm.put("job", "trainer");
	 * given().contentType("application/json").body(hm).when().post(
	 * "https://reqres.in/api/users") .then() .statusCode(201).log().all(); }
	 */
	
	@Test(priority=2)
	void createUser2() {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "katty");
		hm.put("job", "trainer");
		id=given().contentType("application/json").body(hm)
		.when().post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	}
	@Test(priority=3, dependsOnMethods= {"createUser2"})
	void updateUser() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "John");
		hm.put("job", "teacher");
		given().contentType("application/json").body(hm)
		.when().post("https://reqres.in/api/users" + id)
		.then()
		.statusCode(201).log().all();
		
	}
	@Test(priority=4)
	void deleteUser() {
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
		
	}

}
