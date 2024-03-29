package restAssuredBasics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostRequestOrgJson {

	@Test(priority = 1)
	void testPostUsingjsonLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		String courseArr[] = { "C", "Java" };
		data.put("courses", courseArr);
		data.put("courses", courseArr);
		given().contentType("application/json").body(data.toString())

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("Scott")).body("location", equalTo("France"))
				.body("phone", equalTo("123456")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("Java"))
				.header("Content-Type", "application/json").log().all();
	}

	@Test(priority = 2)
	void testDelete() {

		given().when().delete("http://localhost:3000/students/e427").then().log().all();
	}

}
