package trelloApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specs {
    // Build Request Specification



    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                //.expectContentType(ContentType.JSON)
                .build();
    }
     public static void installSpecs(RequestSpecification reqSpec, ResponseSpecification resSpec){

         RestAssured.requestSpecification = reqSpec;
         RestAssured.responseSpecification  = resSpec;


     }

}