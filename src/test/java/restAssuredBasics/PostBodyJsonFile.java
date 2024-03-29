package restAssuredBasics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class PostBodyJsonFile {
	@Test(priority = 1)
	@Epic("EP001")
	@Feature("Feature 1 :RequestBody")
	void testPostUsingHashMap() throws FileNotFoundException {
		File file = new File(".\\body.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);

		given().contentType("application/json").body(jsonObject.toString())

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("Scott")).body("location", equalTo("France"))
				.body("phone", equalTo("123456")).body("courses[0]", equalTo("Python"))
				.body("courses[1]", equalTo("Java")).header("Content-Type", "application/json").log().all();
	}

	@Test(priority = 2)
	void testDelete() {
		given().when().delete("http://localhost:3000/students/c331")
		.then()
		.log().all();
	}

}
