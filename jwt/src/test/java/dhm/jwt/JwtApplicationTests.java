package dhm.jwt;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class JwtApplicationTests {
/*
  @Test
  void jwtTest() {
    RestAssured.baseURI = "http://localhost:8090/jwt";

    String id = "102";
    String email = "pedro@gmail.com";

    given()
        .header("Content-Type", "application/json")
        .when()
        .get("/status")
        .then()
        .statusCode(200);


    Response res = RestAssured.get("/token?username=" + email + "&id=" + id);

    String jwt = res.getBody().asString();

    if (jwt instanceof String) {
      System.out.println(jwt);
    } else {
      System.out.println("Fail to get jwt");
    }

    given()
        .header("Content-Type", "application/json")
        .when()
        .get("/username?token=" + jwt)
        .then()
        .statusCode(200)
        .equals(email);


    given()
        .header("Content-Type", "application/json")
        .when()
        .get("/id?token=" + jwt)
        .then()
        .statusCode(200)
        .equals(id);

    given()
        .header("Content-Type", "application/json")
        .when()
        .get("/validate?token=" + jwt)
        .then()
        .statusCode(200)
        .equals(false);
  }

*/
}
