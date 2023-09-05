package api.endPoints;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import api.Payload.user;

import static io.restassured.RestAssured.*;
import  io.restassured.http.ContentType;

import io.restassured.response.Response;

public class UserEndPoints {
	                       public static Response createUser( user Payload) {
		                   Response response= given()
		                  .contentType(ContentType.JSON)
		                  .accept(ContentType.JSON)
		                		    
		                    .body(Payload)
		                    .when()
		                    .post(Routes.post_url);
		                    return response;
		             		                    
	}
	                       public static Response getUser( String username) {
			                   Response response= given()
			                		   .pathParam("username", username) 
			                    
			                    .when()
			                    .post(Routes.get_url);
			                    return response;
			                               
	                       }
	                       public static Response updateUser( String username,user Payload) {
			                   Response response= given()
			                  .contentType(ContentType.JSON)
			 		          .accept(ContentType.JSON)
			                		   
			                    .body(Payload)
			                    .when()
			                    .post(Routes.update_url);
			                    return response;
		


}
	                       public static Response deleteUser( String username) {
			                   Response response= given()
			                    .pathParam("username", username)
			                    .when()
			                    .post(Routes. delete_url);
			                    return response;
		}
}