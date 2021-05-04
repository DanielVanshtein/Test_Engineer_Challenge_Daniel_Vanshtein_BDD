package com.assignment_Test.api_Test;

import com.assignment_Test.readData.ReadJsonFile;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestAssured_TemperatureConverter_JsonData {

    @BeforeAll
    public static void init(){
       baseURI = "https://9616a323-0d5b-4fd7-8448-7f761b9c6ddb.mock.pstmn.io";
       basePath = "/temperature" ;
       ReadJsonFile.populate_ListOfTemperatureInputs();
    }

    RequestSpecification rs = given().log().uri().contentType(ContentType.JSON);
    static List<String> allResponse = new LinkedList<>();

    @DisplayName("Post a request to /correct and assert the response is 'correct' ")
    @Order(1)
    @Test
    public void check_ResponsePayload_For_Correct_Response(){
        allResponse.add(
        given()
                .spec(rs)
                .body(ReadJsonFile.temperatureInputTestCaseList.get(0))

                .when()
                .post("/correct")

                .then()
                .log().body()
                .body("response", is("correct"))
                .extract().jsonPath().getString("response"));

    }


    @DisplayName("Post a request to /incorrect and assert the response is 'incorrect' ")
    @Order(2)
    @Test
    public void check_ResponsePayload_For_Incorrect_Response(){
        allResponse.add(
        given()
                .spec(rs)
                .body(ReadJsonFile.temperatureInputTestCaseList.get(1))

                .when()
                .post("/incorrect")

                .then()
                .log().body()
                .body("response", is("incorrect"))
                .extract().jsonPath().getString("response"));
    }

    @DisplayName("Post a request to /incorrect2 and assert the response is 'incorrect' ")
    @Order(3)
    @Test
    public void check_ResponsePayload_For_Incorrect_Response2(){
        allResponse.add(
        given()
                .spec(rs)
                .body(ReadJsonFile.temperatureInputTestCaseList.get(2))

                .when()
                .post("/incorrect2")

                .then()
                .log().body()
                .body("response", is("incorrect"))
                .extract().jsonPath().getString("response"));
    }

    @DisplayName("Post a request to /invalid and assert the response is 'invalid' ")
    @Order(4)
    @Test
    public void check_ResponsePayload_For_Invalid_Response(){
        allResponse.add(
        given()
                .spec(rs)
                .body(ReadJsonFile.temperatureInputTestCaseList.get(3))

                .when()
                .post("/invalid")

                .then()
                .log().body()
                .body("response", is("invalid"))
                .extract().jsonPath().getString("response"));


        for (int i = 0; i < allResponse.size(); i++) {
            System.out.println("Test Case "+ (i+1) + " Response: "+allResponse.get(i));
        }

    }

    @AfterAll
    public static void tearDown(){
        reset();
    }








}
