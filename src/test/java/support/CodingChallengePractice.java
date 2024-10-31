package support;

public class CodingChallengePractice {

    public static void main(String[] args) {
        swapNums(3, 5);
    }

    public static void swapNums(int a, int b) {
        System.out.println("Before swapping: a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = " + a + " b = " + b);
    }

}