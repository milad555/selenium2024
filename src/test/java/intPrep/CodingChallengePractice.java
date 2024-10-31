package intPrep;

public class CodingChallengePractice {


    /*
Maximum of Three Numbers
Take three numbers from the user and print the largest one.
Example:
- Input parameters: 3, 80, 1
- Method print: 80 is the largest number


    */
    public static int maxNum(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;

        } else {
            return c;
        }
    }

    // Even or Odd
    public static void evenOrOdd(int number) {
        System.out.println("Is number " + number + " even ? " + (number % 2 == 0));
        // or: return number%2==0
    }

// Foo-Bar: if num is divisible by 3 - print foo
// if divisible by 5 - print bar
// if divisible by 5 and 3 - print foobar

    public static void fooBar(int num) {
        if (num % 15 == 0) {
            System.out.println("FooBar");
        } else if (num % 5 == 0) {
            System.out.println("Bar");
        } else if (num % 3 == 0) {
            System.out.println("Foo");
        } else {
            System.out.println("no bar or foo");
        }
    }

    // find a prime number using if else
    public static boolean isPrime(int num){
        if (num !=2 && num%2==0){
            return false;
        } else if (num !=3 && num%3==0){
            return true;
        } else if (num !=5 && num%5==0) {
            return true;
// etc...
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        //evenOrOdd(3);
        fooBar(1);
    }


}
