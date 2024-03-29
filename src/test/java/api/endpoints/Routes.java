package api.endpoints;




//https://petstore.swagger.io/#/user/createUsersWithListInput
//https://petstore.swagger.io/#/user/getUserByName
//https://petstore.swagger.io/#/user/updateUser
//https://petstore.swagger.io/#/user/deleteUser

//https://petstore.swagger.io/v2/user
//https://petstore.swagger.io/v2/user/{username}
//https://petstore.swagger.io/v2/user/{username}
//https://petstore.swagger.io/v2/user/{username}
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2/";
	//user module urls
	public static String post_url=base_url+"user";
	public static String get_url=base_url+"user/{username}";
	public static String put_url=base_url+"user/{username}";
	public static String delete_url=base_url+"user/{username}";

}
