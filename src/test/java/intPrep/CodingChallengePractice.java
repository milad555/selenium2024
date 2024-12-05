package intPrep;

import java.util.*;
import java.util.Arrays;

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


    public static void reverseLettersInWords(String str) {
        String[] words = str.trim().split(" ");

        String revWord = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                revWord += word.charAt(j);
            }

            revWord = revWord + " ";
        }
        System.out.println(revWord);
    }

    public static List<Integer> primeNumbers(int n) {
        List<Integer> primes = new LinkedList<>();
        for (int numberToCheck = 1; numberToCheck <= n; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(numberToCheck);
            }
        }
        return primes;
    }


    public static void fibonachi(int n) {
        int f1 = 0;
        int f2 = 1;
        int f3;

        for (int i = 1; i <= n; i++) {
            System.out.println(f1);
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
    }

    public static int[] bubble(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

// Given 2 arrays of integers. Merge them and remove duplicates.

    public void merge2ArrAndRemoveDups(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        int idx = 0;

        for (int i = 0; i < arr1.length; i++) {
            int current = arr1[i];
            boolean isDuplicated = false;

            for (int j = 0; j < arr2.length; j++) {
                if (current == arr2[j]) {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                result[idx++] = current;
            }
        }
        System.out.println(Arrays.toString(result));
        for (int res : result) {
            System.out.println(res);
        }
    }

    //Reverse an Integer
    public static int reverseInteger(int ints) {
        String s = ints + "";
        String z = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            z += s.charAt(i);
        }
        return Integer.parseInt(z);
    }

    //Reverse an Integer using do/while loop
    public static int reverseInteger2(int num) {
        int reversed = 0;
        do {
            int digit = num % 10; // get the last digit
            reversed = reversed * 10 + digit; // add the last digit to the reversed number
            num = num / 10; // remove the last digit
        } while (num != 0);
        return reversed;
    }

    //Create a program that calculates the sum of all digits of a given integer until the sum is a single digit.
    public static String sumOfDigits(int integer) {
        String ints = integer + "";
        int z = 0;
        while (ints.length() >= 2) {
            for (int i = ints.length() - 1; i >= 0; i--) {
                z += ints.charAt(i) - '0';
            }
            ints = z + "";
            z = 0;
        }
        return ints;
    }
//Create a program that calculates the sum of all digits of a given integer until the sum is a single digit. Second solution

    public static int sumOfDigits2(int num) {
        if (num < 10) {
            return num;
        }
        do {
            int res = 0;
            while (num != 0) {
                int d = num % 10;
                res += d;
                num /= 10;
            }
            num = res;
        } while (num > 9);
        return num;
    }


    public static boolean palindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    //Reverse Words in a Sentence Using a Single Loop
    //Write a program to reverse the order of words in a sentence using
    //a single loop.
    //For example, "Hello World" becomes "World Hello".
    public static String reverseWords2(String s) {
        int idxBeginOfWord = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); //current char
            if (ch == ' ') {
                String word = s.substring(idxBeginOfWord, i);
                if (result.isBlank()) {
                    result = word;
                } else {
                    result = word + " " + result;
                }
                idxBeginOfWord = i + 1;
            } else if (i == s.length() - 1) {
                result = s.substring(idxBeginOfWord, i + 1) + " " + result;
            }
        }
        return result;
    }

    // reverse words in sentence
    public static void reverseWords(String str) {
        String[] words = str.trim().split(" ");

        StringBuilder build = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            build.append(words[i] + " ");
        }
        System.out.println(build);
    }

    //Implement a Simple Calculator Using Switch Case
    //Write a program that takes two numbers and an operator (+, -, *, /) as input and performs the corresponding arithmetic operation using a switch statement.

    private static int solution(int n, int m, char op) {
        int res = -1;
        switch (op) {
            case '+':
                res = n + m;
                break;
            case '-':
                res = n - m;
                break;
            case '*':
                res = n * m;
                break;
            case '/':
                if (m == 0) {
                    System.out.println("cant divide to 0");
                    return -1;
                } else {
                    res = n / m;
                }
                break;
            default:
                System.out.println("unknown operator");

        }
        return res;
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int k : arr) {
            System.out.println(k);
        }

    }

    //2. Find Two Elements that Add Up to a Target Sum

    public static void twoElToTarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + target);
                }
            }
        }
    }

    public static boolean isAnagram(String a, String b) {
        //must be same length
        // must be lower case
        // remove spaces
        // check if strings are null
        if (a.length() != b.length()) {
            return false;
        }
        a = a.replaceAll(" ", "").toLowerCase();
        b = b.replaceAll(" ", "").toLowerCase();


        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0) + 1);
            bMap.put(b.charAt(i), bMap.getOrDefault(b.charAt(i), 0) + 1);
        }
        return aMap.equals(bMap);
    }

    public static void fibonachi2(int n) {
        int temp;
        int n1 = 0;
        int n2 = 1;
        int n3;

        for (int i = 0; i < n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
        }
    }

    public static void primeN(int n) {

        List<Integer> primes = new ArrayList<>();
        for (int numberToCheck = 2; numberToCheck <= n; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(numberToCheck);
            }

        }
        System.out.println(primes);
    }


    /*
    public static List<Integer> primeNumbers(int n) {
        List<Integer> primes = new LinkedList<>();
        for (int numberToCheck = 1; numberToCheck <= n; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(numberToCheck);
            }
        }
        return primes;
    }
     */
    /*
    There are n kids with candies. You are given an integer array candies, where each candies[i]
    represents the number of candies the ith kid has,
    and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
they will have the greatest number of candies among all the kids, or false otherwise.
Note that multiple kids can have the greatest number of candies.
     */

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
         /*
        3
        [1,2,4,6,7]
        [false,false,false,true,true]
        find a greatest number of candies
        loop thru the array again and compare if the candy+extraCandy is more than greatest number
        */
        List<Boolean> result = new ArrayList<>();
        int arrLen = candies.length;
        int greatNumCandy = 0;
        for (int i = 0; i < arrLen; i++) {
            if (greatNumCandy < candies[i]) {
                greatNumCandy = candies[i];
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= greatNumCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String anagram1 = "The eyes";
        String anagram2 = "They see";


        primeN(100);
        // System.out.println(isAnagram(anagram1, anagram2));
        //fibonachi2(9);
        // System.out.println(sumOfDigits(555));
        //evenOrOdd(3);
        // fooBar(1);
        //  System.out.println(reverseInteger(1234));
        //  String a = "this is just a test";
        // countVowels(a);
        //    reverseString(a);
        // reverseWords(a);
        //System.out.println(primeNumbers(30));
        // reverseLettersInWords(a);
        //   fibonachi(15);

        int[] arr = {1, 2, 3, 7, 2, 7, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int target = 6;


    }
}
