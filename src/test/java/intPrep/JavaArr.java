package intPrep;

import ClassWork.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.*;


public class JavaArr {
    public static void main(String[] args) {
        //create and populate
//        String[] arr1 = {"Anna", "Nonna", "Donna"};
//
//        //create an empty array with 3 spaces
//        String[] arr2 = new String[3];
//        arr2[0]= "Max";
//        arr2[1]= "Fido";
//        arr2[2]= "Jil";
//
//        ArrayList<String> arr3 = new ArrayList<>();
//        ArrayList<Integer> arr4 = new ArrayList<>();
//
//        String base = "user";
//        ArrayList<String> users = new ArrayList<>();
//        for (int i = 0; i < 5; i++){
//            Random random = new Random();
//            users.add(i + base + " " + random.nextInt(9000));
//        }
//        for(String u: users){
//            System.out.println(u);
//        }

        HashMap<String, String> car = new HashMap<>();
        car.put("Nissan", "Rouge");
        car.put("Honda", "Pilot");
        car.put("Rav4", "Toyota");
        car.put("Pruis", "Toyota");
        //System.out.println(car);

//printing values using forEach
        //car.forEach((key, value) -> System.out.println(key+ ": "+ value ));


//        System.out.println(car.get("Honda"));
//        System.out.println();

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Spider", "Man"));

        HashMap<Integer, Hero> huros = new HashMap<>();
        //         key     value --because was instantiated on this line
        huros.put(12, new Hero("Spider", "Woman"));
        huros.put(13, new Hero("Klark", "SpiderMan"));
        huros.put(14, new Hero("Brad", "Pitt"));
        huros.put(15, new Hero("Lex", "Fridman"));

//access values via for loop
        Set<Integer> her = huros.keySet();
        for (int i = 0; i < huros.size(); i++) {
            //used the .values method to get all the values from the Hashmap
            //create another for loop
           for (int ss: her){
               huros.get(ss);// get us the access to Hero methods, such as getSecretIdentity()
               System.out.println(huros.get(ss).getSecretIdentity());
           }
        }


        String regex = "^a-z";
        String rightEmail = "test@test.com";
        String wrongEmail = "2eq.da";
        String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        //Pattern Objects compile into an object
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(rightEmail);
        //You will talk to the matcher and not to something else
        Matcher matcher1 = pattern.matcher(wrongEmail);
        // System.out.println("Pattern is " + matcher.matches());
        // System.out.println("Pattern is " + matcher1.matches());

        ArrayList<String> emails = new ArrayList<>();
        emails.add("test@test.com");
        emails.add("testtest.com");
        emails.add("test@testcom");
        emails.add("test@test.");

        // emailValidatorHash(emails);
        System.out.println(emailValidatorHash(emails));
    }


    public static ArrayList<Boolean> emailValidator(ArrayList<String> arrayList) {
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        ArrayList<Boolean> results = new ArrayList<>();

        for (String arr : arrayList) {
            Matcher matcher = pattern.matcher(arr);
            results.add(matcher.matches());
        }
        return results;
    }

    public static HashMap<String, Boolean> emailValidatorHash(ArrayList<String> arrayList) {
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        HashMap<String, Boolean> results = new HashMap<>();

        //Allows us to go thru a simple array list
        for (String arr : arrayList) {
            // creating a matcher object to tell us if the pattern is found  or not
            Matcher matcher = pattern.matcher(arr);
            results.put(arr, matcher.matches());
        }
        return results;
    }

}
