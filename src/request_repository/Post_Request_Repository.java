package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import common_method.GetData;

public class Post_Request_Repository {

	public static String baseuri() {
		String baseuri = "https://reqres.in/";
		return baseuri;
	}

	public static String resource() {
		String resource = "/api/users";
		return resource ;
	}
	
	public static String Post_request_tc1() throws IOException
	{
//		GetData.getDataExel("POST_data", "tc1");
//		String requestBody= "{\r\n"
//				+ "    \"name\": \"morpheus\",\r\n"
//				+ "    \"job\": \"leader\"\r\n"	
//				+ "}";
//		return requestBody;
		
	
	
		ArrayList<String> data = GetData.getDataExel("post_data","tc1");
		String Name = data.get(2);
		String Job = data.get(3);
		String requestBody ="{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		
		return requestBody;
	}
	
}
