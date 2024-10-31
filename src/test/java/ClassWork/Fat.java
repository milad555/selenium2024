package ClassWork;

public class Fat extends Food {
    private int energy;


    public Fat(int weight, String source) {
        setWeight(weight);
        super.source = source;


    }
    public void calcCaloriesPerMeat() {
        if (source.equalsIgnoreCase("Chicken")) {
            System.out.println("In your " + source + " is " + getWeight() * 165/100 + " calories");
        } else if (source.equalsIgnoreCase("Beef")) {
            System.out.println("In your " + source + " is " + getWeight() * 250/100 + " calories");
        } else if (source.equalsIgnoreCase("Pork")) {
            System.out.println("In your " + source + " is " + getWeight() * 242/100 + " calories");
        } else {
            throw new IllegalStateException("Unexpected value: " + source);
        }

    }
}
