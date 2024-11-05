package intPrep;

public class ifElse {
  /*
Leap Year Checker
Determine if a given year is a leap year. A leap year is divisible by 4 but not by 100 unless it is also divisible by 400.
Example:
- Input parameter: 1900
- Method print: Not a leap year
     */

    public static void isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("leap");
                } else {
                    System.out.println("not leap");
                }
            } else {
                System.out.println(" leap");
            }
        } else {
            System.out.println("not leap");
        }
    }


    public boolean sleepIn(boolean weekday, boolean vacation) {

        if (!weekday && !vacation) {
            return true;
        } else return !weekday || vacation;
    }

    public boolean nearHundred(int n) {
        if (Math.abs(n) < 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cigarParty(int cigars, boolean isWeekend) {
        if ((40 < cigars && cigars < 60) && !isWeekend) {
            return true;
        } else if (isWeekend && (cigars > 40)) {
            return false;

        }
        return false;

    }

    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return a + b < 0;
        } else if (!negative) {
            return a > 0 || b > 0;
        }
        return negative;
    }

    /*
    We'll say that a number is "teen" if it is in the range 13..19 inclusive.
    Given 3 int values, return true if 1 or more of them are teen.
    hasTeen(13, 20, 10) → true
    hasTeen(20, 19, 10) → true
    hasTeen(20, 10, 13) → true
     */
    public boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
    }

    /*
    We'll say that a number is "teen" if it is in the range 13..19 inclusive.
    Given 2 int values, return true if one or the other is teen, but not both.
    loneTeen(13, 99) → true
    loneTeen(21, 19) → true
    loneTeen(13, 13) → false
     */
    public boolean loneTeen(int a, int b) {
       boolean aTeen = (a >= 13 && a <= 19);
       boolean bTeen = (b >= 13 && b <= 19);
       return (aTeen && !bTeen) || (!aTeen && bTeen);
    }

    public boolean mixStart(String str) {
        if(str.substring(1,3).equals("ix") ){
            return  true;
        }
        return false;
    }

    public String startOz(String str) {
        String result = "";

        if (str.length() >= 1 && str.charAt(0)=='o') {
            result = result + str.charAt(0);
        }

        if (str.length() >= 2 && str.charAt(1)=='z') {
            result = result + str.charAt(1);
        }

        return result;
    }

    public static int close10(int a, int b) {
        int difA = Math.abs(10 - a);
        int difB = Math.abs(10 - b);

        if (difA<difB){
            return a;
        }
        if (difA>difB){
            return b;
        }
        return 0;
    }

    public static int max1020(int a, int b) {

        if (b>a){
            int temp = a;
            a=b;
            b = temp;
        }
        if (a>=10 && a<=20) return a;
        if (b>=10 && b<=20) return b;
        return 0;
    }





    public static void main(String[] args) {
      //  isLeap(1900);
//        close10(13, 7);

       // max1020(11,9);
    }


}