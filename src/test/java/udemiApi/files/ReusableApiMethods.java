package udemiApi.files;

import io.restassured.path.json.JsonPath;

public class ReusableApiMethods {

    public String getStringFromJson(String jsonResponse, String stringToExtract){
        JsonPath js = new JsonPath(jsonResponse);
        return js.getString(stringToExtract);
    }
}
