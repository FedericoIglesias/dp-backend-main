package dhm.register;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;


@SpringBootTest
class RegisterApplicationTests {

	@Test
	void registerTest() {
		RestAssured.baseURI = "http://localhost:8081/api/register";

		given()
				.header("Conten-Type","application/json")
				.when()
				.get("/status")
				.then()
				.statusCode(200);


		String aliasRegex = "^\\b\\w+\\b.\\b\\w+\\b.\\b\\w+\\b$";
		Pattern aliasPattern = Pattern.compile(aliasRegex);
		String cvuRegex = "^.{22}$";
		Pattern cvuPattern = Pattern.compile(cvuRegex);

		String requestBody = "{\"email\": \"fede@gmail.com\",\"lastname\": \"Igl\", "+
				" \"name\": \"Fede\", \"password\": \"holis\", \"phone\": 610107918 }";

		given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when()
				.post("/user")
				.then()
				.statusCode(201)
				.body("name", equalTo("Fede"))
				.body("email", equalTo("fede@gmail.com"))
				.body("lastname", equalTo("Igl"))
				.body("cvu", matchesPattern(cvuPattern))
				.body("alias", matchesPattern(aliasPattern))
				.body("phone", equalTo("610107918"));


		requestBody = "{\"email\": \"cerelia@gmail.com\",\"lastname\": \"Dinata\", "+
				" \"name\": \"Cerelia\", \"password\": \"holis\", \"phone\": 610107918 }";

		given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when()
				.post("/user")
				.then()
				.statusCode(201)
				.body("name", equalTo("Cerelia"))
				.body("email", equalTo("cerelia@gmail.com"))
				.body("lastname", equalTo("Dinata"))
				.body("cvu", matchesPattern(cvuPattern))
				.body("alias", matchesPattern(aliasPattern))
				.body("money", equalTo(0.0F))
				.body("phone", equalTo("610107918"));

		given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when()
				.post("/user")
				.then()
				.statusCode(500);
	}
}
