package udemiApi;

import io.restassured.path.json.JsonPath;
import udemiApi.files.Payload;

public class ComplexJsonParse {


    public static void main(String[] args) {

        JsonPath js = new JsonPath(Payload.coursePrice());

        int count = js.getInt("courses.size()");
        System.out.println(count);

        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        for (int i = 0; i < count; i++) {
            System.out.println("Course number is: " + js.get("courses[" + i + "].title").toString() + " and the price is "+js.get("courses[" + i + "].price").toString());
        }

        // Print N of copies sold by RPA Course

        for (int i = 0; i < count; i++) {
            js.get("courses[" + i + "].title");
            if (js.get("courses[" + i + "].title").toString().equalsIgnoreCase("RPA")){
                System.out.println("Copies of RPA: " + js.getInt("courses[" + i + "].copies"));
                break;
            }
        }

// Verify if sum of all courses price matches with Purchase amount

        int expAmount = 0;
        for (int i = 0; i < count; i++) {
            expAmount +=  js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
        }
        System.out.println(expAmount);
    }
}
