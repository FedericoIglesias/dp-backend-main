package dhm.account;

import io.restassured.RestAssured;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

@SpringBootTest
class AccountApplicationTests {
/*
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

  @Test
  void activity(){
    RestAssured.baseURI = "http://localhost:8084/api/accounts";
    String idAccount = "102";

    // Is a token invented
    String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQyNDcxNjgsImV4cCI6MjcyNDI0ODYwOH0.1JTExZFSFVhNcX-J_Zgx6_EE_dYndORs4BcKbENNCUA";


    given()
      .header("AUTHORIZATION", bearerToken)
      .when()
      .get("/" + idAccount + "/activity")
      .then()
      .statusCode(200);
    given()
      .when()
      .get("/" + idAccount + "/activity")
      .then()
      .statusCode(401);
  }

  @Test
  void getInfoAccount(){
    RestAssured.baseURI = "http://localhost:8084/api/accounts";
    String idAccount = "102";

    // Is a token invented
    String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQyNDcxNjgsImV4cCI6MjcyNDI0ODYwOH0.1JTExZFSFVhNcX-J_Zgx6_EE_dYndORs4BcKbENNCUA";

    String aliasRegex = "^\\b[\\p{L}]+\\b.\\b[\\p{L}]+\\b.\\b[\\p{L}]+\\b$";
    Pattern aliasPattern = Pattern.compile(aliasRegex);
    String cvuRegex = "^.{22}$";
    Pattern cvuPattern = Pattern.compile(cvuRegex);

    given()
      .header("AUTHORIZATION", bearerToken)
      .when()
      .get("/" + idAccount )
      .then()
      .statusCode(200)
      .body("name", equalTo("Pedro"))
      .body("username", equalTo("pedro@gmail.com"))
      .body("lastname", equalTo("Pe"))
      .body("cvu", matchesPattern(cvuPattern))
      .body("alias", matchesPattern(aliasPattern))
      .body("phone", equalTo("610107918"));

    given()
      .when()
      .get("/" + idAccount )
      .then()
      .statusCode(401);
  }
*/
}
