package request_repository;

public class Put_Request_Repository {

	public class put_request_repository {
		public static String baseuri() {
			String baseuri = "https://reqres.in/";
			return baseuri;
		}

		public static String resource() {
			String resource = "api/users/2";
			return resource;
		}

		public static String Put_request_tc1() {
			String requestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n"
					+ "}\r\n" + "";
			return requestBody;

		}
	}
}