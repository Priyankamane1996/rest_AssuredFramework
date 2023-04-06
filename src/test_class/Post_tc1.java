package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodUtilities;
import common_method.common_method_api;
import io.restassured.path.json.JsonPath;
import request_repository.Post_Request_Repository;

@Test
public class Post_tc1 {

	// Run everything, driver class return
	public static void orchestrator() throws IOException {
		int responseStatuscode = 0;
		String responseBody = "";
		String baseUri = Post_Request_Repository.baseuri();
		String resource = Post_Request_Repository.resource();
		String requestBody = Post_Request_Repository.Post_request_tc1();
		
		
		for(int i = 0; i < 5; i++) {
			responseStatuscode  = common_method_api.responsestatuscode_extractor(baseUri, resource, requestBody);
			if(responseStatuscode == 201) {
				responseBody = common_method_api.responsebody_extractor(baseUri, resource, requestBody);
				responseBodyValidator(responseBody);
				break;
			}
			
			else {
				System.out.println("correct status code is not found in the iteration" +i);
			}
		}
		Assert.assertEquals(responseStatuscode, 201);
		CommonMethodUtilities.evidenceFileCreator("PostTc1", requestBody, responseBody);
		
			}
	public static void responseBodyValidator(String responseBody)
	{
		//create json pathobject to extract responseBody parameter
	
	JsonPath jsp = new JsonPath(responseBody);
	
	//Extract responsebody parameter
	String res_name = jsp.getString("name");
	String res_job = jsp.getString("job");
	String res_id = jsp.getString("id");
	String res_createdAt = jsp.getString("createdAt");
	
	System.out.println("name:" +res_name+ "/n job:" +res_job+ "/n id: " +res_id+ "/n createdAt:" +res_createdAt);
      
	
	// validate responsebody parameter
	Assert.assertEquals(res_name, "Morpheus");
	Assert.assertEquals(res_job, "Leader");
	Assert.assertNotNull(res_id, "assertionError, id parameter is null");
	
	//Extract date from createdAt parameter
	String actual_date = res_createdAt.substring(0, 10);
	//create date object
	String current_date = LocalDate.now().toString();
	Assert.assertEquals(actual_date, current_date);
	System.out.println("Actual date:" +actual_date+ "/n current_date: " +current_date  );
	
	}
}
