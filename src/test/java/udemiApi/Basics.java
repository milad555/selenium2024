package udemiApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import udemiApi.files.Payload;
import udemiApi.files.ReusableApiMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Basics {

    static ReusableApiMethods rm = new ReusableApiMethods();

    public static void main(String[] args) {
        // given - all input details
        // when - submit the api - resource, http method
        // then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.addPlace()).log().all()
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .log().all()
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();



        // Add place -> Update place with new address -> Get place to validate if new address is present in response

        JsonPath js = new JsonPath(response); // for parsing json
        String placeId =  js.getString("place_id");
        String newAddress = "Summer walk, Africa";
        System.out.println("PLACE ID: " + placeId);

        // Update place

        String updateBody = """
        {
          "place_id": "%s",
          "address": "%s",
          "key": "qaclick123"
        }
        """.formatted(placeId,newAddress);

        given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(updateBody)
                .when()
                .put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated")).log().all();

        // Get place


        String getPlaceResponce =  given()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then().log().all()
                .statusCode(200)
                .extract().response().asString();

       // ReusableApiMethods.rawToJson(getPlaceResponce);
        String actualAddress = rm.getStringFromJson(getPlaceResponce, "address");
        System.out.println("actual Address: " + actualAddress);

        Assert.assertEquals(newAddress, actualAddress);

    }
}

