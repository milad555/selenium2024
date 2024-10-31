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
}
