package intPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static boolean isPrime(int num) {
        if (num != 2 && num % 2 == 0) {
            return false;
        } else if (num != 3 && num % 3 == 0) {
            return true;
        } else if (num != 5 && num % 5 == 0) {
            return true;
// etc...
        } else {
            return false;
        }
    }
//count the number of vowels in a string

    private static void countVowels(String string) {
        String vowels = "auieo";
        string.toLowerCase();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (vowels.contains(c + "")) {
                count++;
            }

        }
        System.out.println(count);
    }

    // reverse string
    public static void reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);

        }
        System.out.println(reversed);

    }

    /**
     * Print numbers from 1 to n.
     * For multiples of 3, print "Foo";
     * for multiples of 5, print "Bar";
     * for multiples of 7, print "Qux".
     * If a number is divisible by both 3 and 5, print "FooBar",
     * and if divisible by all three (3, 5, and 7), print "FooBarQux".
     */

    public static void fooBarQux(int n) {
        for (int i = 1; i >= 0; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                System.out.println("FooBarQux");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FooBar");
            } else if (i % 7 == 0) {
                System.out.println("Qux");
            } else if (i % 5 == 0) {
                System.out.println("Bar");
            } else if (i % 3 == 0) {
                System.out.println("Foo");
            }
        }
    }

    // reverse words in sentence
    public static void reverseWords(String str) {
        String reversed = "";
        String divide = " ";
        List<String> strArr = new ArrayList<>();

//        for (int i = 0; i < str.length() ; i++) {
//            str.s
//        }

    }

    public static void main(String[] args) {
        //evenOrOdd(3);
        // fooBar(1);

        String a = "this is just a test";
        // countVowels(a);
//        reverseString(a);




        int[] arr = {1, 2, 3, 7, 2, 7, 5};
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
        }
        List<Integer> mapValues = map.entrySet().stream().filter(entry -> entry.getValue() == 2).map(Map.Entry::getKey).toList();
        System.out.println(mapValues);


//
//        for (int i = 0; i < arr.length; i++) {
//            int n = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    System.out.println(n);
//                    break;
//                }
//            }
//        }
    }
}
