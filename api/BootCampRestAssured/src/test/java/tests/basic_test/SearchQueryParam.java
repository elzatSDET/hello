package tests.basic_test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchQueryParam {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test1(){

        given()
                .log().uri()
                .accept(ContentType.JSON)
                .queryParam("gender","Female").
        when()
                .get("/spartans/search").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("content.gender", not( contains("Male") ) )

        ;


        ;

    }

    @Test
    public void test2(){


        given()
                .log().uri()
                .accept(ContentType.JSON).
                        when()
                .get("/spartans/{myID}", 213).
         then()
                .log().all()
                .body("name", is("EBC"))
                ;

    }




}
