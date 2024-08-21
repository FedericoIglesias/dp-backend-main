package dhm.account;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@SpringBootTest
class AccountApplicationTests {

  @Test
  void accountTest() {
    RestAssured.baseURI = "http://localhost:8084/api/accounts";
    String id = "102";

    // Is a token invented
    String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQyNDcxNjgsImV4cCI6MjcyNDI0ODYwOH0.1JTExZFSFVhNcX-J_Zgx6_EE_dYndORs4BcKbENNCUA";

    given()
      .get("/status")
      .then()
      .statusCode(200);


    given()
      .header("Content-Type", "application/json")
      .header("AUTHORIZATION", bearerToken)
      .when()
      .get("/" + id + "/transactions")
      .then()
      .statusCode(200);
  }

  @Test
  void transferenceId() {
    RestAssured.baseURI = "http://localhost:8084/api/accounts";
    String idAccount = "102";

    // Is a token invented
    String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQyNDcxNjgsImV4cCI6MjcyNDI0ODYwOH0.1JTExZFSFVhNcX-J_Zgx6_EE_dYndORs4BcKbENNCUA";


    given()
      .header("AUTHORIZATION", bearerToken)
      .when()
      .get("/" + idAccount + "/activity/0")
      .then()
      .statusCode(200);
    given()
      .when()
      .get("/" + idAccount + "/activity/0")
      .then()
      .statusCode(401);
  }

}
