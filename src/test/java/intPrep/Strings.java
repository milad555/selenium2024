package intPrep;

public class Strings {

    /*
Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". The string length will be at least 3.
middleThree("Candy") → "and"
middleThree("and") → "and"
middleThree("solving") → "lvi"
 */
    public static String middleThree(String str) {
        int m = str.length() / 2;
        return str.substring(m - 1, m + 2);

    }

    public static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    /*

Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping).
For example, the string "abXYZba" has the mirror end "ab".
mirrorEnds("abXYZba") → "ab"
mirrorEnds("abca") → "a"
mirrorEnds("aba") → "aba"
     */
    public static String mirrorEnds(String string) {
        int l = string.length() - 1;
        String res = "";
        for (int i = 0; i <= l; i++) {
            if (string.charAt(i) == string.charAt(l - i)) {
                res += string.charAt(i);
            } else {
                break;
            }
        }
        return res;
    }

    public static String backAround(String str) {
        return str.charAt(str.length() - 1) + str + str.charAt(str.length() - 1);
    }


    /*

Given a non-empty string and an int n, return a new string where the char at index n has been removed.
The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).
missingChar("kitten", 1) → "ktten"
missingChar("kitten", 0) → "itten"
missingChar("kitten", 4) → "kittn"
     */
    public static String missingChar(String str, int n) {
        String front = str.substring(0, n);
        String back = str.substring(n + 1, str.length());

        return front + back;

    }

    /*
Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back,
so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
front22("kitten") → "kikittenki"
front22("Ha") → "HaHaHa"
front22("abc") → "ababcab"
     */
    public String front22(String str) {
        int take = 2;
        if (take > str.length()) {
            take = str.length();
        }
        String front = str.substring(0, take);
        return front + str + front;
    }

    /*

Given a string, return true if the string starts with "hi" and false otherwise.
startHi("hi there") → true
startHi("hi") → true
startHi("hello hi") → false
     */
    public boolean startHi(String str) {
        return str.startsWith("hi");
    }

    public boolean scoresIncreasing(int[] scores) {
        boolean result = true;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < scores[i + 1]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /*
    Given a string, return a new string where "not " has been added to the front.
    However, if the string already begins with "not", return the string unchanged. Note: use .equals() to compare 2 strings.
    notString("candy") → "not candy"
    notString("x") → "not x"
    notString("not bad") → "not bad"
     */
    public String notString(String str) {
        if (str.length() < 3) {
            return "not " + str;
        }

        if (str.substring(0, 3).equals("not")) {
            return str;
        } else {
            return "not " + str;
        }
    }

    /*
    Given a string, return a new string where the first and last chars have been exchanged.
    frontBack("code") → "eodc"
    frontBack("a") → "a"
    frontBack("ab") → "ba"
     */
    public static String frontBack(String str) {
        if (str.length() < 2) {
            return str;
        }
        String middle = str.substring(1, str.length() - 1);
        return str.charAt(str.length() - 1) + middle + str.charAt(0);
    }


    public String front3(String str) {
        if (str.length() > 3) {
            return str;
        }
        String front = str.substring(0, 3);
        return front + front + front;
    }

    public String endUp(String str) {
        if (str.length() < 3) {
            return str.toUpperCase();
        } else {
            return str.substring(str.length() - 3, str.length()).toUpperCase();
        }
    }

    public static String everyNth(String str, int n) {
        String newStr = "";

        for (int i = 0; i < str.length(); i = i + n) {
            newStr = newStr + str.charAt(i);
        }
        return newStr;
    }


    public static String delDel(String str) {
        if (str.substring(1, 4).equals("del")){
            return str.substring(0,1) + str.substring(4);
        }else{
            return str;
        }

    }

    public static void main(String[] args) {

        System.out.println(delDel("adelHello"));

//        String middleThree = "candy";
        String abcd = "abcdefgh";
//        // System.out.println(middleThree(middleThree));
//        StringBuilder sb = new StringBuilder(middleThree);
//
//        String newsstr = sb.delete(0, middleThree.length() - 1).toString();
//
//        System.out.println(everyNth(abcd, 3));
//        // System.out.println(newsstr);
//
//
//        String s = "abcdef";
//        System.out.println(reverseString(s));
//        String m = "abXYZba";
        // System.out.println(mirrorEnds(m));
        // System.out.println(backAround(s));
        //System.out.println(missingChar(middleThree,3));
        //frontBack(s);
    }


}
