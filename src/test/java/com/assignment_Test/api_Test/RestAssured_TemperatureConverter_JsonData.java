package com.assignment_Test.api_Test;
import com.assignment_Test.readData.ReadJsonFile;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import java.util.LinkedList;
import java.util.List;

public class RestAssured_TemperatureConverter_JsonData {

    @BeforeClass
    public static void init(){
       baseURI = "https://9616a323-0d5b-4fd7-8448-7f761b9c6ddb.mock.pstmn.io";
       basePath = "/temperature" ;
       ReadJsonFile.populate_ListOfTemperatureInputs();
    }

    RequestSpecification rs = given().log().uri().contentType(ContentType.JSON);
    static List<String> allResponse = new LinkedList<>();

//    ("Post a request to /correct and assert the response is 'correct' ")
    @Test
    public void check_ResponsePayload_For_Correct_Response_1(){
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


//    ("Post a request to /incorrect and assert the response is 'incorrect' ")
    @Test
    public void check_ResponsePayload_For_Incorrect_Response_2(){
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

//    @DisplayName("Post a request to /incorrect2 and assert the response is 'incorrect' ")

    @Test
    public void check_ResponsePayload_For_Incorrect_Response_3(){
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

//    @DisplayName("Post a request to /invalid and assert the response is 'invalid' ")
    @Test
    public void check_ResponsePayload_For_Invalid_Response_4(){
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

     @AfterClass
    public static void tearDown(){
        reset();
    }








}
