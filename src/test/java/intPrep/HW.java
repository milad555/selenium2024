package intPrep;

public class HW {

    public static int sumOfAllElemInArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int secondLargestElement(int[] arr) {
        int firstLarg = Integer.MIN_VALUE;
        int secondLarg = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if( arr[i] > firstLarg){
                secondLarg = firstLarg;
                firstLarg = arr[i];
            }else if (arr[i]> secondLarg && arr[i] != firstLarg){
                secondLarg = arr[i];
            }
        } return secondLarg;
    }

    public static void reverseString(String str){
        String reverse = "";

        for (int i = str.length()-1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }

    public static void reverseWords(String str){
        String[] words = str.trim().split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = words.length-1 ; i >=0 ; i--) {
            builder.append(words[i] + " ");
        }
        System.out.println(builder);
    }

    public static void reverseLettersInWord(String str){
        String[] words = str.trim().split(" ");
        String finalStr = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = word.length()-1; j >=0 ; j--) {
                if (word.charAt(j) == ',') {
                    finalStr += ' ';
                } else {
                    finalStr += word.charAt(j);
                }
            }
            finalStr += " ";

        }
        System.out.println(finalStr);
    }

    public static void main(String[] args) {
        String s = "Hello, this is Joe Rogan podcast";
//        reverseString(s);
//        reverseWords(s);
        reverseLettersInWord(s);
    }

}




