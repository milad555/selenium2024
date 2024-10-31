package definitions;

import io.cucumber.java.en.Given;

public class JavaStepDevs {
    @Given("I write Java step")
    public void iWriteJavaStep() {
        System.out.println("Hello World");
        String greetingForUser = "Say Hello";
        String user = "John";
        System.out.println(greetingForUser + " " + user.toUpperCase());
        int age = 25;
        System.out.println("Age: " + age);
        double salary = 1000;
        System.out.println("Salary: " + salary);

    }
}
