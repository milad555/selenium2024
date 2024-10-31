package ClassWork;

// Abstract class
public abstract class Food {
// No constructor because abstract classes are never instantiated

    protected int calories;
    private int weight;
    public String state;
    protected String source;



    //this method can be overridden later
    public void eatFood(){
        System.out.println("Consume food");
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public int setWeight(int weight) {
        return this.weight = weight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
