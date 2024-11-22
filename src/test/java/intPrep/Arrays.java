package intPrep;

import java.util.*;

public class Arrays {


    /*
    Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
    firstLast6([1, 2, 6]) → true
    firstLast6([6, 1, 2, 3]) → true
    firstLast6([13, 6, 1, 2, 3]) → false
    */
    public static boolean firstLast6(int[] nums) {
        int f = nums[0];
        int l = nums[nums.length - 1];
        return f == 6 || l == 6;
    }

    /*
    Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.
    commonEnd([1, 2, 3], [7, 3]) → true
    commonEnd([1, 2, 3], [7, 3, 2]) → false
    commonEnd([1, 2, 3], [1, 3]) → true
     */
    public static boolean commonEnd(int[] a, int[] b) {
        int fA = a[0];
        int fB = b[0];
        int lA = a[a.length - 1];
        int lB = b[b.length - 1];
        return fA == fB || lA == lB;
    }

    public static int sumOfAllElemInArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int secondLargestElement(int[] arr) {

        if (arr.length < 2) {
            System.out.println("Only one num");
            return arr[0];
        }

        int firstLarg = arr[0];
        int secondLarg = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > firstLarg) {
                secondLarg = firstLarg;
                firstLarg = arr[i];
            } else if (arr[i] > secondLarg && arr[i] != firstLarg) {
                secondLarg = arr[i];
            }
        }
        return secondLarg;
    }

    // find the index of the value
    public static int findIndexOfValue(int[] arr, int value) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                System.out.println("Index of the value is " + i);
                break;
            }

        }
        return index;

    }

    public static String rotateLeft3(int[] nums) {
        for (int i = 1; i <= 2; i++) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = nums[i + 1];
            nums[nums.length - 1] = temp;

        }
        return java.util.Arrays.toString(nums);
    }


    // Given an array of ints length 3, return a new array
    // with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.

    public static int[] reverse3(int[] nums) {
        int[] arr = new int[nums.length];
        int j = nums.length - 1;
        for (int i = 0; i <= nums.length - 1; i++) {
            arr[i] = nums[j--];

        }
        return arr;
    }

    public static int middleArrayValue(int[] arr) {
        int middle = arr.length / 2;
        return middle;
    }



    public static void main(String[] args) {
        int[] numsfirstLast6 = {4, 6, 6, 3, 1, 2, 3, 2, 8, 8};
        // System.out.println(firstLast6(numsfirstLast6));
        int[] rotate = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // System.out.println(rotateLeft3(rotate));
        //System.out.println(middleArrayValue(rotate));

        //System.out.println(java.util.Arrays.toString(reverse3(rotate)));
        // int[] commonEndA = {1, 2, 3};
        //int[] commonEndB = {7, 3};
        //System.out.println(commonEnd(commonEndA, commonEndA));
        //System.out.println(sumOfAllElemInArray(numsfirstLast6));

        //System.out.println(secondLargestElement(numsfirstLast6));
        //findIndexOfValue(numsfirstLast6, 1);
    }

}
