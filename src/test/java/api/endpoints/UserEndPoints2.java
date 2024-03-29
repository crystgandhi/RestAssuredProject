package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ResourceBundle;

import api.payload.User;

public class UserEndPoints2 {
	
	public static ResourceBundle getURL(){
		//load properties files
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	

	public static Response createUser(User payload) {
		String post_url=getURL().getString("post_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);

		return res;
	}

	public static Response readUser(String username) {
		String get_url=getURL().getString("get_url");
		Response res=given()
				.pathParam("username", username)
				.when()
				.get(get_url);

		return res;
	}
	
	public static Response updateUser(String username, User payload) {
		String put_url=getURL().getString("put_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(put_url);
		return res;
	}
	
	public static Response deleteUser(String username) {
		String delete_url=getURL().getString("delete_url");
		Response res=given()
				.pathParam("username", username)
				.when()
				.delete(delete_url);

		return res;
	}
}
