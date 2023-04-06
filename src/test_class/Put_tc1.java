package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodPutApi;
import common_method.CommonMethodUtilities;
import io.restassured.path.json.JsonPath;
import request_repository.Put_Request_Repository.put_request_repository;

@Test
public class Put_tc1 {
	public static void orchestrator() throws IOException
	{    
		String responseBody = "" ;
		int responseStatuscode = 0;
		String baseUri = put_request_repository.baseuri();
		String resource = put_request_repository.resource();
		String requestBody = put_request_repository.Put_request_tc1();
		for(int i=0 ; i<5 ; i++) 
        {
		 responseStatuscode = CommonMethodPutApi.responsestatuscode_extractor(baseUri, resource, requestBody);	
          if (responseStatuscode == 200)
		  {
			responseBody = CommonMethodPutApi.responsebody_extractor(baseUri, resource, requestBody);
			responseBodyValidator(responseBody);
			
			break;
	      }
          else
          {
        	  System.out.println("correct status code is not found in the iteration " +i);
          }
        } 
		CommonMethodUtilities.evidenceFileCreator("Put_tc1",requestBody,responseBody);
		Assert.assertEquals(responseStatuscode, 200);
		
     }
	 public static void responseBodyValidator(String responseBody)
		{
			// create jsonPath object to extract responsebody parameters
			JsonPath jsp = new JsonPath(responseBody);

			// extract responsebody parameters
			String res_name = jsp.getString("name");
			String res_job = jsp.getString("job");
			String res_updatedAt = jsp.getString("updatedAt");
			String res_date = res_updatedAt.substring(0,10);

			System.out.println("name : " + res_name + "\njob : " + res_job + "\nupdatedAt : " + res_date);

			// validate responsebody parameter
			Assert.assertEquals(res_name, "morpheus");
			Assert.assertEquals(res_job, "zion resident");

			// extract date from updatedAt parameter
			String current_date = LocalDate.now().toString();
			Assert.assertEquals(res_date,current_date);
			System.out.println( "\nCurrent date : " +current_date);
			

		}


}
