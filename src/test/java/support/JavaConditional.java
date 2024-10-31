package support;

import javax.xml.transform.Source;
import java.util.HashMap;

public class JavaConditional {

    public static void main(String[] args) {
//        int age = 16;
//        daClub(age);
//        daClub(18);
//        daClub(20);
//        daClub(21);
//        daClub(45);
//        String user = "Admin";
//        adminRights(user);
//        adminRights("User");
//        adminRights("Manager");
//        adminRights("Exec");

//          int age = 16;
//        int[] ages = { 16, 21, 44, 87};
//        String[] users ={"Admin", "Executive", "Managers", "Users"};
//        adminRights(users[0]);

//        while(age<18){
//            System.out.println("Too young");
//            age++;
//        }
      // for (int x = 16; x < 18; x++) {
//            System.out.println(x);
//            System.out.println("You are not old enough");
//        }
//        for (int i = 0; i < ages.length; i++) {
//            System.out.println(ages[i]);
//            daClub(ages[i]);
//            //prints from the end
//          //  System.out.println(ages[ages.length-1-i]);
//        }
//        for(int a: ages ){
//            System.out.println(a);
//        }

//        Object[] fam = new Object[]{"Marina", 32, true, "Milad", 33, true};
////        printFam(fam);
//        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        isItFridayYet(days);

        //countMississippi(4);
       // fooOrBar("foo");
        countChars();
    }

    public static void daClub(int age) {
        if (age < 18) {
            System.out.println("No access to daClub");
        } else if (age >= 18 && age < 21) {
            System.out.println("No alcohol for you");
        } else {
            System.out.println("Welcome to DaClub");
        }
    }

    public static void adminRights(String user) {
        switch (user) {
            case "Admin" -> System.out.println("Welcome Admin user");
            case "User" -> System.out.println("Welcome Regular user");
            case "Manager" -> System.out.println("Welcome Manager user");
            case "Exec" -> System.out.println("Welcome Exec user");
            default -> System.out.println("no user");
        }


//        if (user == "Admin" || user == "Administrator"){
//            System.out.println("Welcome Admin user");
//        } else if (user == "User") {
//            System.out.println("Welcome Regular User");
//        } else {
//            System.out.println("No user found");
//        }

    }
    public static void printFam(Object[] obj){
        for (Object o:obj) {
            System.out.println(o);
        }
    }

    public static void isItFridayYet(String[] days){
        for(String day:days){
            System.out.println(day);
            if(day.equals("Friday")){
                System.out.println("TGIF");
                break;
            }
        }
    }
    public static void countMississippi(int n){
        for (int i = 1; i <= n; i++) {
            System.out.println(i +" Mississippi");
        }
    }

    public static void fooOrBar(String text){
        if (text == "foo"){
            System.out.println("Foo0000");
        } else if (text == "bar") {
            System.out.println("baaaar");
        } else {
            System.out.println("invalid");
        }
    }

    public static void countChars(){
        String a = "Hello";
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            count.put(a.charAt(i), count.getOrDefault(a.charAt(i),0)+1 );
        }
        count.forEach((key,value) -> System.out.println(key+ ": " + value));

    }

}
