package example.other.tasks;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2,3,9,5,1,6};
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j+1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }
}
