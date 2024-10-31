package definitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import support.YamlDataHandler;
import trelloApi.Specs;

import static io.restassured.RestAssured.given;

public class TrelloStepDefs {

    private String yamlFile = "apiData";
    private final static String URL = "https://api.trello.com/";
    private final static String publicBoardId = "671c181bda301fbdd8f7524d";
    private final static String key = "c89d501e8951741b06e55ccdf74bd7fb";
    private final static String token = "ATTAd4b9dc75cf4b8d05b08008ee42d853a6de6e4947c81cc8d200e06d771ad1237aAAA42F18";
    private static String boardId;
    private String createListPath(String publicBoardId) {
        return "1/boards/" + publicBoardId + "/lists?";
    }

    @Given("I create board")
    public void iCreateBoard() {
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

        YamlDataHandler.writeKeyValue(yamlFile,"boardId",boardId);
        System.out.println("Created Board ID: " + boardId);
    }

    @Given("I create list")
    public void iCreateList() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());

        String newList =
                given()
                        .basePath(createListPath(YamlDataHandler.readValueByKey(yamlFile,"boardId")))
                        .queryParam("name", "newList1")
                        .queryParam("key", "c89d501e8951741b06e55ccdf74bd7fb")
                        .queryParam("token", "ATTAd4b9dc75cf4b8d05b08008ee42d853a6de6e4947c81cc8d200e06d771ad1237aAAA42F18")
                        .when()
                        .post()
                        .then().log().all()
                        .extract()
                        .jsonPath()
                        .get("id");

        YamlDataHandler.writeKeyValue("apiData","listId", newList);
        System.out.println(newList);
    }

    @Given("I create card")
    public void iCreateCard() {
        Specs.installSpecs(Specs.requestSpec(URL), Specs.responseSpecification200());
        for (int i = 1; i <=3 ; i++) {

            String newCard = given()
                    .basePath("/1/cards?")
                    .queryParam("name", "newCard" +i)
                    .queryParam("idList", YamlDataHandler.readValueByKey(yamlFile,"listId"))
                    .queryParam("key", key)
                    .queryParam("token", token)
                    .when()
                    .post()
                    .then().log().all()
                    .extract()
                    .jsonPath()
                    .get("id");

            YamlDataHandler.writeKeyValue("apiData","cardId"+i, newCard);
            System.out.println(newCard);
        }
    }
}
