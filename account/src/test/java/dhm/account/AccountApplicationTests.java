package dhm.account;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class AccountApplicationTests {

	@Test
	void accountTest() {
		RestAssured.baseURI = "http://localhost:8084/api/accounts";
		String id ="112";

		// Is a token invented
		String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQxNTkwNzQsImV4cCI6MjcyNTE5MDUxNH0.0vWpRgZ3zOod9CXNrjrjM--YUZ7dj60aApzUk3kgG2k";

		given()
				.header("Content-Type", "application/json")
				.header("AUTHORIZATION",jwt)
				.when()
				.get("/status")
				.then()
				.statusCode(200);


		given()
			.header("Content-Type", "application/json")
			.header("AUTHORIZATION",jwt)
			.when()
			.get("/"+ id +"/transactions")
			.then()
			.statusCode(200);

	}

}
