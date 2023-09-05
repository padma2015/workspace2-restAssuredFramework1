package api.Test;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.user;
import api.endPoints.UserEndPoints;
import io.restassured.response.Response;
	
	public class UserTests {
		Faker faker;
		user userpayload;
		@BeforeClass
		public void setupData() {
			faker =new Faker();
			userpayload=new user();
			userpayload.setId(faker.idNumber().hashCode());
			userpayload.setUsername(faker.name().username());
			userpayload.setFirstname(faker.name().firstName());
			userpayload.setLastname(faker.name().lastName());
			userpayload.setEmail(faker.internet().emailAddress());
			userpayload.setPassword(faker.internet().password(5,10));
			userpayload.setPhone(faker.phoneNumber().cellPhone());
	
		}


       @Test(priority=1)
       public void testpostuser() {
    	   Response response=UserEndPoints.createUser(userpayload);
    	   response.then().log().all();
    	   Assert.assertEquals(response.getStatusCode(), 200);
    	   
       }
		      @Test(priority=2)
		public void testgetuserByname() {
			   Response response=UserEndPoints.getUser(this.userpayload.getUsername());
			   response.then().log().all();
			   Assert.assertEquals(response.getStatusCode(), 200);
      }
      
		      @Test(priority=3)
		      public void testUpdateuserByname() {
				userpayload.setUsername(faker.name().username());
				userpayload.setFirstname(faker.name().firstName());
				userpayload.setLastname(faker .name().lastName());
				
				
				
				 Response responseAfterUpdate=UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
				   responseAfterUpdate.then().log().all();
				   Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
			      }
		
			
			@Test(priority=4)
			public void testdeleteuserByname() {
			  Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
			  Assert.assertEquals(response.getStatusCode(), 200);

}}
