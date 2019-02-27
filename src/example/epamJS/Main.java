package example.epamJS;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 2, 7};
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            int el = array[i];
            if (el > array.length) {
                continue;
            }
            int elNext = array[el-1];
            if (elNext == 1+i) {
                continue;
            }
            int elLast = array[elNext-1];
            if (elLast == i+1) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
