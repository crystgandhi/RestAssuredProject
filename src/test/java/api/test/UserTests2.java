package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userPayload;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testGettUser() {
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdatetUser() {
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseAfterupdate = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		responseAfterupdate.then().log().all();
	}
	
	@Test(priority = 4)
	public void testdeletetUser() {
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
