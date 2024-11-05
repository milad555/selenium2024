package trelloApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import support.YamlDataHandler;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Get card
 * https://api.trello.com/1/cards/
 * 5b62135c81432307e8714883
 * ?key=c89d501e8951741b06e55ccdf74bd7fb
 * &token=ATTAd4b9dc75cf4b8d05b08008ee42d853a6de6e4947c81cc8d200e06d771ad1237aAAA42F18
 */
public class TrelloTest {
    // YamlDataHandler yaml = new YamlDataHandler();
    private String yamlFile = "apiData";
    private final static String URL = "https://api.trello.com/";
    private final static String publicBoardId = "671c181bda301fbdd8f7524d";
    private final static String key = "c89d501e8951741b06e55ccdf74bd7fb";
    private final static String token = "ATTAd4b9dc75cf4b8d05b08008ee42d853a6de6e4947c81cc8d200e06d771ad1237aAAA42F18";
    private static String boardId;

    private String createListPath(String publicBoardId) {
        return "1/boards/" + publicBoardId + "/lists?";
    }

    private Map<String, Object> yamlData;


    @Test
    public void createABoard() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());
        boardId = given()

                .basePath("1/boards/")
                .contentType(ContentType.JSON)
                .queryParam("name", "RestAndPeaceBoardPub")
                .queryParam("prefs_permissionLevel", "public")
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .post()
                .then().log().all()
                .extract()
                .path("id"); // Extract the board ID and store it in the static variable

        YamlDataHandler.writeKeyValue(yamlFile, "boardId", boardId);
        System.out.println("Created Board ID: " + boardId);

    }

    @Test
    public void validateBoard() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());

        given()
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get("1/boards/" + "671ef63770fac24a6c59c01c")
                .then().log().all()
                .body("id", equalTo("671ef63770fac24a6c59c01c"))
                .body("name", equalTo("RestAndPeaceBoardPub"))
                .body("prefs.permissionLevel", equalTo("public"))
                .body("prefs.switcherViews[0].viewType", equalTo("Board"));
    }

    @Test
    public void createNewListOnBoard() {

        // 1/boards/{id}/lists?name={name}&key=APIKey&token=APIToken
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());

        String newList =
                given()
                        .basePath(createListPath(YamlDataHandler.readValueByKey(yamlFile, "boardId")))
                        .queryParam("name", "newList1")
                        .queryParam("key", "c89d501e8951741b06e55ccdf74bd7fb")
                        .queryParam("token", "ATTAd4b9dc75cf4b8d05b08008ee42d853a6de6e4947c81cc8d200e06d771ad1237aAAA42F18")
                        .when()
                        .post()
                        .then().log().all()
                        .extract()
                        .jsonPath()
                        .get("id");

        YamlDataHandler.writeKeyValue("apiData", "listId", newList);
        System.out.println(newList);
    }

    @Test
    public void createCardInList() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());
        for (int i = 1; i <= 3; i++) {

            String newCard = given()
                    .basePath("/1/cards?")
                    .queryParam("name", "newCard" + i)
                    .queryParam("idList", YamlDataHandler.readValueByKey(yamlFile, "listId"))
                    .queryParam("key", key)
                    .queryParam("token", token)
                    .when()
                    .post()
                    .then().log().all()
                    .extract()
                    .jsonPath()
                    .get("id");

            YamlDataHandler.writeKeyValue("apiData", "cardId" + i, newCard);
            System.out.println(newCard);
        }

    }

    @Test
    public void deleteCardsInList() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());
        for (int i = 1; i <= 3; i++) {
            given()
                    // .basePath("1/cards/"+yaml.readValueByKey(yamlFile,"cardId") +i)
                    //.queryParam("name", yaml.readValueByKey(yamlFile,"cardId") +i)
                    // .queryParam("idList", yaml.readValueByKey(yamlFile,"listId"))
                    .queryParam("key", key)
                    .queryParam("token", token)
                    .when()
                    .delete("1/cards/" + YamlDataHandler.readValueByKey(yamlFile, "cardId" + i))
                    .then().log().all();
        }
    }

    @Test
    public void deleteBoard() {
        //  --url 'https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken'

        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());

        given()
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete("1/boards/" + YamlDataHandler.readValueByKey(yamlFile, "boardId"))
                .then().log().all()
                .statusCode(200);

    }


    @Test
    public void deleteAllBoards() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());

        Response response = given()
                .basePath("1/members/me/boards")
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get()
                .then().log().all()
                .extract()
                .response();
        List<String> boardIds = response.jsonPath().getList("id");
        System.out.println("Board side BEFORE deleting: "+ boardIds.size());
        for (int i = 0; i <= boardIds.size(); i++) {
            given()
                    .queryParam("key", key)
                    .queryParam("token", token)
                    .when()
                    .delete("1/boards/" + boardIds.get(i))
                    .then()
                    .statusCode(200);
        }
        System.out.println("Board side AFTER deleting: "+ boardIds.size());
    }

//    @Test
//    public void getPublicBoardListsPublicBoard() {
//        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());
//
//        List<String> getIds = given()
//                .basePath("1/boards/")
//                .when()
//                .get(publicBoardId + "/lists")
//                .then()//.log().all()
//                .body("name", notNullValue())
//                .body("color", everyItem(nullValue()))
//                .body("idBoard", everyItem(is(publicBoardId)))
//                .extract().body().jsonPath().getList("id");
//        getIds.forEach(System.out::println);
//    }
//
//
//    @Test
//    public void printBoard(){
//        System.out.println("Created Board ID: " + boardId);
//    }
}
