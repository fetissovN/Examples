package example.findMostDuplicatesInList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1,2,5,2,2,3};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ints.length; i++) {
            if (map.containsKey(ints[i])) {
                int anInt = map.get(ints[i]);

                map.put(ints[i], anInt + 1);
            } else {
                map.put(ints[i], 1);
            }
        }

        System.out.println(
                map.entrySet().stream()
                        .max(Comparator.comparingInt(Map.Entry::getValue))
                        .get().getKey()
        );
        map.forEach((integer, integer2) -> System.out.println(integer + " " + integer2));
    }
}
