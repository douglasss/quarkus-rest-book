package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }

    @Test
    public void shouldCountAllBooks() {
        given()
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("4"));
    }

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
                .body("genre", is("IT"));

    }

}