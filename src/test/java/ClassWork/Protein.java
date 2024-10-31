package ClassWork;


public class Protein extends Food {

public Protein(int cal, int weigh, String state){
    //Use Setters to create a Protein Object
    setCalories(cal);
    setWeight(weigh);
    // Use the standart constructor way
    super.calories = cal;
    super.state = state;
}

//Override forces the inherited method to change
    @Override
    public void eatFood(){
        System.out.println("Pump it up");
    }



//Examples of overloading:
    public void buildMuscles(){
        System.out.println("Get better muscles");
    }
// Same name but different outcome
    public void buildMuscles(String creatine){
        System.out.println("Get EVEN better muscles");
    }
    public void buildMuscles(String creatine, String supplements){
        System.out.println("Get EVEN MORE better muscles");
    }



}
