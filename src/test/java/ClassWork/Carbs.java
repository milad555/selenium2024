package ClassWork;

public class Carbs extends Food {

    private int energy;

    public Carbs(int cal, int weight, String state ){
        setWeight(weight);
        super.calories = cal;
        super.state = state;
    }

    public void convertGlycogen(){
        energy = calories/20;
    }
}
