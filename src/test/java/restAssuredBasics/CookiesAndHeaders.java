package restAssuredBasics;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesAndHeaders {

	// @Test(priority=2)
	public void testCookies() {

		given().when().get("https://www.google.com/").then()
				.cookie("AEC", "Ae3NU9MtHGjkHH0e2IJMe6CP2lVl-6IAdc7gyUHUPdNZm4-6OKqQIrHlsx0").statusCode(200).log()
				.all();

	}

	// @Test(priority=1)
	public void getCookiesInfo() {

		Response res = given().when().get("https://www.google.com/");
		String cookie = res.getCookie("AEC");
		System.out.println(cookie);

	}

	// @Test(priority = 1)
	public void getCookiesInfo2() {

		Response res = given().when().get("https://www.google.com/");

		Map<String, String> cookie_value = res.getCookies();
		for (String k : cookie_value.keySet()) {
			System.out.println(k + " - " + cookie_value);

		}
	}

	// @Test(priority = 1)
	public void getHeader() {

		given().when().get("https://www.google.com/").then().header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip").header("Server", "gws")

				.log().all();

	}

	//@Test(priority = 1)
	public void getHeaders() {

		Response res = given().when().get("https://www.google.com/");
		String content_Encoding = res.getHeader("Content-Encoding");
		System.out.println(content_Encoding);

		String content_Type = res.getHeader("Content-Type");
		System.out.println(content_Type);

		String server = res.getHeader("Server");
		System.out.println(server);
	}

	@Test(priority = 1)
	public void getHeaders2() {

		Response res = given().when().get("https://www.google.com/");
		Headers headersValues = res.getHeaders();
		for (Header h : headersValues) {
			System.out.println(h.getName() + "     " + h.getValue());
		}

	}
	
	
}
