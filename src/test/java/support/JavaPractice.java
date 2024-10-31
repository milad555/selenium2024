package support;

public class JavaPractice {

    public static void main(String[] args) {
     //   System.out.println("Hello world");
        int x = 4;
        int y = 2;
        double z = 40.2;
        double k = 20.1;
        double j = 10.1;
        System.out.println(x);
        String firstName = "Milad";
        String lastName = "Khusainkhel";

        boolean married = true;
        printName(firstName);
        printFirstAndLastName(firstName,lastName);
        printSum(x,y);
        printSubtraction(x,y);
        printDivision(z,k);
        printMultiplication(z,k);
        printRemainder(z,j);
        printEquals(x,y);
        printLogical(x,y);
    }

    public static void printName(String name){
        System.out.println("Hello " + name );
    }
    public static void printFirstAndLastName(String firstName, String lastName){
        System.out.println("Hello, my name is " + firstName + " " + lastName);
    }
    public static void printSum(int x, int y){
        System.out.println("Sum of x and y = " + (x+y));
    }
    public static void printSubtraction(int x, int y){
        System.out.println("Subtraction of x from y = " + (x-y));
    }
    public static void printDivision(double z, double k){
        System.out.println("Division z by k = " + (z/k));
    }
    public static void printMultiplication(double z, double k){
        System.out.println("Multiplication z by k = " + (z*k));
    }
    public static void printRemainder(double z, double j){
        System.out.println("Remainder of z / k = " + (z%j));
    }
    public static void printEquals(int x, int y){
        System.out.println("Is x equal to y ? " + (x==y));
    }
    public static void printLogical(int x, int y){
        System.out.println("Is x equal to y AND x > y ? " + (x==y && x>y));
    }
}
