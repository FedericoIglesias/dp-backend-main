package dhm.login;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class LoginApplicationTests {

  @Test
  void loginTest() {
    RestAssured.baseURI = "http://localhost:8082/api/login";

    given()
        .when()
        .get("/status")
        .then()
        .statusCode(200);

    given()
        .header("Content-Type", "application/json")
        .body("{\"email\":\"fede@gmail.com\",\"password\":\"holis\"}")
        //.body(requestBody)
			  .when()
        .post()
        .then()
        .statusCode(200);
  }
}
