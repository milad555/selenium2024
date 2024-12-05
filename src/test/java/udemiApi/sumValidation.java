package udemiApi;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import udemiApi.files.Payload;

public class sumValidation {

    JsonPath js = new JsonPath(Payload.coursePrice());

    int count = js.getInt("courses.size()");
    int totalAmount = js.getInt("dashboard.purchaseAmount");
    @Test
    public void sumOfCourses(){
        int expAmount = 0;
        for (int i = 0; i < count; i++) {
            expAmount +=  js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
        }
        Assertions.assertEquals(totalAmount,expAmount);
        System.out.println("Expected total Amount: " + expAmount + " Actual amount is: "+ totalAmount);
    }

}
