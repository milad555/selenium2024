package ClassWork;


public class FoodMain {
    public static void main(String[] args) {
//
//        Protein whey = new Protein(140, 50, "Powder");
//        whey.eatFood();
//        System.out.println(whey.getCalories());
//
//        whey.setWeight(20);
//        System.out.println(whey.getWeight());
//
//        Carbs bread = new Carbs(120, 20, "loaf");
//
//        bread.convertGlycogen();
//        Fat avocado = new Fat(100, "GMO");
//        avocado.calculateEnergyFromFat();
//        System.out.println(avocado.calculateEnergyFromFat());
//        Alcohol vodka = new Alcohol(2, 2);
//        vodka.buzzLevel();
        //Alcohol.buzzLevelObj(vodka);
        //Alcohol.buzzLevelObj(new Alcohol(3,"beer"));
//        vodka.setDrinks(10);
//        vodka.buzzLevel();
//        Wine wine = new Wine(4, 5);
//
//        wine.buzzLevel();
//        wine.calculateHangover();

        Barbq chicken = new Barbq(200, "Chicken");
        chicken.calcCaloriesPerMeat();
        Beer beer = new Beer(3,10, "Beer");
        beer.calculateHangover();
    }
}
