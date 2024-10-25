package dhm.card;

import dhm.card.model.Cards;
import io.restassured.RestAssured;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class CardApplicationTests {
/*
	@Test
	void statusCard() {
		RestAssured.baseURI = "Http://localhost:8085/api/cards";
		given()
			.get("/status")
			.then()
			.statusCode(200);

/*
		given()
			.header("Content-Type", "application/json")
			.header("AUTHORIZATION", bearerToken)
			.when()
			.get("/" + id + "/transactions")
			.then()
			.statusCode(200); */

	}
/*
	@Test
	void crudCard() {
		RestAssured.baseURI = "Http://localhost:8085/api/cards";
		String id = "102";

		// Is a token invented
		String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZWRyb0BnbWFpbC5jb20iLCJqdGkiOiIxMDIiLCJpYXQiOjE3MjQyNDcxNjgsImV4cCI6MjcyNDI0ODYwOH0.1JTExZFSFVhNcX-J_Zgx6_EE_dYndORs4BcKbENNCUA";

		given()
			.header("Content-Type", "application/json")
			.body("{\"bank\":\"BBVA\",\"number\":476565295,\"endDate\":\"5/30\",\"cvv\":962,\"account\":{\"id\":102}}")
			.when()
			.post()
			.then()
			.statusCode(201);

		given()
			.when()
			.get("/476565295")
			.then()
			.statusCode(200)
			.body("bank", equalTo("BBVA"))
			.body("number", equalTo(476565295))
			.body("endDate", equalTo("5/30"))
			.body("cvv", equalTo(962));

		Cards requestBody = new Cards(null,"Macro",476565295,"5/30",962,null);

		given()
			.when()
			.delete("/476565295")
			.then()
			.statusCode(200);
	}

}

 */
