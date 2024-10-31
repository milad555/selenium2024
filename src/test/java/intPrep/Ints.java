package intPrep;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ints {

    /*
    Convert numerical scores into letter grades based on the following scale:
90 and above: A
80 to 89: B
70 to 79: C
60 to 69: D
Below 60: F
     */

    public static void gradeConverter(int grade) {
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80 && grade < 90) {
            System.out.println("B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("C");
        } else if (grade >= 60 && grade < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
    /*
Maximum of Three Numbers
Take three numbers from the user and print the largest one.
Example:
- Input parameters: 3, 80, 1
- Method print: 80 is the largest number


     */
    public static int maxNum(int a, int b, int c){
        if(a >=b && a>=c){
            return a;
        } else if (b>=a && b>=c) {
            return b;

        }else {
            return c;
        }
    }


    public static void sortArray(int[] arr){
        if (arr.length==0){
        }
    }



    public static void main(String[] args) {
        //  gradeConverter(79);
        //System.out.println(maxNum(300,800,799));


    }
}



