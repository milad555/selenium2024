package intPrep;

import java.util.*;

public class LeetCode {

    public static void main(String[] args) {

/*
Merge sorted array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 */
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        mergeSortedArray(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));


//Two Integer Sum:
// Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//Return the answer with the smaller index first.
//        int[] nums = {3,4,5,6};
//        int target = 7;
//        System.out.println(Arrays.toString(twoSum(nums, target)));


//Is Anagram https://neetcode.io/problems/is-anagram
//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//        String s = "racecar";
//        String t = "carrace";
//        isAnagram(s,t);


// Count the Occurrence of Words in a String. Problem: Given a string, count the number of occurrences of each word and store it in a HashMap.
        //  String countWords = "this is a test this is only a test";
        // wordCount(countWords);
/*
Remove element
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
*/
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//        System.out.println(removeElement(nums, val));

/*
Remove Duplicates - ONLY UNIQUE
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
//        System.out.println(removeDuplicatesHashSet(nums));


/*
Remove Duplicates - AT MOST TWICE
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,4,4,4};
//        int j = removeDuplicatesTWO(nums);
//        System.out.println("Length of the array is " +j);
//        for (int i = 0; i <j ; i++) {
//            System.out.print(nums[i]);
//        }

//        int[] nums = {2, 3, 1, 6, 5, 7, 2};
//        System.out.println(majorityElement(nums));


        // System.out.println(Arrays.toString(bubbleSortIncrement(nums)));
        // System.out.println(Arrays.toString(bubbleSortDecrement(nums)));


// prime number
       // int finish = 30;
        // System.out.println(prime(30));
     //   primeNumber(finish);

//        String s = "VII";
//        System.out.println(romanToInt(s));
//        String out = "<<>>";
//        String a = "candy";
        //  System.out.println(middleThree(a));

        // System.out.println(makeOutWord(out,a));
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println( isPalindrome(s));

        String s = "ace";
        String t ="abcde";
    }

    public boolean isSubsequence(String s, String t) {

        int sPoint = 0;
        int tPoint = 0;
        while(sPoint < s.length() && tPoint <t.length()){
            if (s.charAt(sPoint) == t.charAt(tPoint)){
                sPoint++;
            }
            tPoint++;
        }

        return sPoint == s.length();

    }

    // valid palindrome
    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (s.length() == 0) {
            return true;
        }
        int len = s.length() -1;

        for (int i = 0; i <= s.length()/2; i++) {
                if (s.charAt(i) != s.charAt(len)) {
                   return false;
                }
            len--;
            }
        return true;
    }


    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    public static int[] twoSumHash(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];             // Current number
            int diff = target - num;       // Complement needed to reach target

            // Check if the complement is already in the map
            if (prevMap.containsKey(diff)) {
                // Complement found; return indices
                return new int[]{prevMap.get(diff), i};
            }

            // Store the current number and its index in the map
            prevMap.put(num, i);
        }

        // No pair found (should not happen per problem statement)
        return new int[]{};
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        System.out.println(sMap.equals(tMap));
        return sMap.equals(tMap);
    }

    public static void wordCount(String sentence) {
        HashMap<String, Integer> count = new HashMap<>();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
        }

        count.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // Pointer for nums1
        int j = n - 1;        // Pointer for nums2
        int k = n + m - 1;    // Pointer for the merged array
        // Merge nums1 and nums2 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // Copy any remaining elements from nums2 to nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static int removeDuplicates(int[] nums) {
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = 1; // we start with k=1 because the first element is always unique. ex= nums[0]=0; nums[1]=0
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;

    }

    public static int removeDuplicatesHashSet(int[] nums) {
        int index = 0;
        HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!unique.contains(nums[i])) {
                unique.add(nums[i]);
                nums[index++] = nums[i];
            }
        }
        return index;
    }


    public static int removeDuplicatesTWO(int[] nums) {
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> majority = new HashMap<>();
        for (int num : nums) {
            majority.put(num, majority.getOrDefault(num, 0) + 1);
        }
        Integer max = Collections.max(majority.entrySet(), Map.Entry.comparingByValue()).getKey();
        return max;
    }

    public static int[] bubbleSortIncrement(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j]; // start with tems
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp; // end with temp
                }
            }
        }
        return nums;
    }

    public static int[] bubbleSortDecrement(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {                   // to decrement -> change IF to "<"
                    temp = nums[j]; // start with tems
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp; // end with temp
                }
            }
        }
        return nums;
    }

    public static void primeNumber(int finish) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int numberToCheck = 2; numberToCheck <= finish; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(numberToCheck);
            }
        }
        for (int num : primeNumbers) {
            System.out.println(num);
        }

    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        sMap.put('I', 1);
        sMap.put('V', 5);
        sMap.put('X', 10);
        sMap.put('L', 50);
        sMap.put('C', 100);
        sMap.put('D', 500);
        sMap.put('M', 1000);
// VII
//IIV
        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentNumber = sMap.get(s.charAt(i));
            if (currentNumber < prevValue) {
                result -= currentNumber;
            } else {
                result += currentNumber;
                prevValue = currentNumber;
            }
        }
        return result;

    }

    public static Set<Integer> prime(int n) {
        Set<Integer> primes = new HashSet<>();

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

    public static String middleThree(String str) {
        int m = str.length() / 2;

        return str.substring(m - 1, m + 2);
    }

    public static String makeOutWord(String out, String word) {
        String begin = out.substring(0, 2);
        String end = out.substring(2, 4);
        return begin + word + end;
    }


//candy
}