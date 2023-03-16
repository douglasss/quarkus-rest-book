package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {


    @Test
    public void shouldGetABook() {
        given()
                .pathParam("id", 1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Undertaning quarkus"))
                .body("author", is("Antonio"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("Information Technology"));

    }
}
