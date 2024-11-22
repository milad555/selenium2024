package udemiApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import udemiApi.files.Payload;
import udemiApi.files.ReusableApiMethods;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    static ReusableApiMethods rm = new ReusableApiMethods();
    @Test
    public void addBook(){
        RestAssured.baseURI = "https://rahulshettyacademy.com/";

        String responce = given()
                .contentType("text/plain")
                .body(Payload.addBook())
                .when()
                .post("Library/Addbook.php")
                .then()
                .log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println( rm.getStringFromJson(responce,"ID"));
    }
}
