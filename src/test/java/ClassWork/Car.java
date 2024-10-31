package ClassWork;

public class Car {

    int fuelLevel;
    int distance;
    private String make;
    private String model;

    public Car(int fuelLevel, int distance, String make, String model) {
        this.fuelLevel = fuelLevel;
        this.distance = distance;
        this.make = make;
        this.model = model;
    }

    public void drive() {
//        if(fuelLevel == 0){
//            System.out.println("Your fuel level is " + fuelLevel + " You can't drive");
//        }
        switch (fuelLevel) {
            case 0 -> System.out.println("In your " + make + " fuel level is " + fuelLevel + " You can't drive");
            case 10 ->
                    System.out.println("Your " + make + " " + model + " has " + fuelLevel + " percent of gas." + " You can drive " + distance/fuelLevel + " miles");
            case 100 -> System.out.println("Your " + make + " " + model + " has " + fuelLevel + " percent of gas." + " You can drive " + distance + " miles and grab some food");
            default -> System.out.println("foo");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    public void fuelUp(int fuel){
        this.fuelLevel = fuel;
    }
}
