package ClassWork;

import java.util.ArrayList;
import java.util.HashMap;

public class CoffeeMachine {

    private ArrayList<String> order;
    String milk;

    //We need this constructor to create new ArrayList instance that will later be returned or modified.
    public CoffeeMachine() {
        this.order = new ArrayList<>();
    }

    public void addOrder(String drink) {
        order.add(drink);
    }
//edit order by the name of the drink
    public void editOrder(String drink) {
        order.remove(drink);
    }
    //edit order by the index of the drink
    public void editOrder(int drink) {
        order.remove(drink);
    }
    //Edit order by the index of the drink and REplace
    public void editOrder(int drink, String replaceDrink) {
        order.set(drink, replaceDrink);
    }

    public void clearOrder(String drink) {
        order.clear();
    }

    public String makeCoffee(String size) {
        return size + " Coffee";
    }

    public String makeLatte(String size) {
        return size + " Latte ";
    }

    public String makeLatte(String size, String milk) {
        return size + " Latte with " + milk;
    }

    public String makeMocha(String size) {
        return size + " Mocha" + milk;
    }


    public ArrayList<String> getOrder() {
        return order;
    }

    public static void main(String[] args) {
        CoffeeMachine cafeY = new CoffeeMachine();
        cafeY.makeCoffee("Grande");
        String hela = cafeY.makeCoffee("Grande");

        String milkLatte = cafeY.makeLatte("Tall", "Oat");

        cafeY.addOrder(hela);
        cafeY.addOrder(milkLatte);
        //System.out.println(cafeY.getOrder());


        HashMap<Integer, CoffeeMachine> coffeeStore = new HashMap<>();
        coffeeStore.put(1234,cafeY);

    }

}
