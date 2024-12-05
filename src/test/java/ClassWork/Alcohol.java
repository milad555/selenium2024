package ClassWork;

import java.util.Collection;
import java.util.HashMap;

public class Alcohol extends Food {

    private int drinks;
    private int hangoverIndex;

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public Alcohol(int drinks, int hangoverIndex, String source) {
        this.hangoverIndex = hangoverIndex;
        this.drinks = drinks;
        super.source = source;
    }


    public void buzzLevel() {
        if (drinks <= 1) {
            System.out.println("You had "+drinks+" Good start"); ;
        } else if (drinks <= 3) {
            System.out.println("You had "+drinks+" Keep up");
        } else if (drinks <= 6) {
            System.out.println("You had "+drinks+" Party started");
        } else if (drinks <= 10) {
            System.out.println("You had "+drinks+" Take it easy");
        } else if (drinks <= 15) {
            System.out.println("You had "+drinks+" Superhero");
        } else {
            System.out.println("You had "+drinks+ " Call a doctor!");
        }
    }

    public void calculateHangover(){
        System.out.println("You had "+drinks+" drinks of " + source + "\nYour Hangover level is: " + (drinks * hangoverIndex)/2);
    }
//    public static void buzzLevelObj(Alcohol alcohol){
//        if (alcohol.drinks <= 1) {
//            System.out.println("Good start"); ;
//        } else if (alcohol.drinks <= 3) {
//            System.out.println("Keep up");
//        } else if (alcohol.drinks <= 6) {
//            System.out.println("Party started");
//        } else if (alcohol.drinks <= 10) {
//            System.out.println("Take it easy");
//        } else if (alcohol.drinks <= 15) {
//            System.out.println("Superhero");
//        } else {
//            System.out.println("Call a doctor!");
//        }
//    }




//    public Alcohol(int drinks, String liquorType) {
//
//        if (liquorType.equalsIgnoreCase("Beer")) {
//            setDrinks(drinks);
//        } else if (liquorType.equalsIgnoreCase("Wine")) {
//            setDrinks(drinks*2);
//        } else if (liquorType.equalsIgnoreCase("Vodka")) {
//            setDrinks(drinks*3);
//        }
//    }
}
