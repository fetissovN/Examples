package example.expertsoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(10);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(6);
        b.add(8);
        b.add(8);
        b.add(14);
        b.add(20);

        System.out.println(method(a, b));
    }

    public static List method(ArrayList<Integer> a, ArrayList<Integer> b) {

        List<Integer> newList = new ArrayList<>(a.size()+b.size());

        int iteratorA = 0;
        int iteratorB = 0;

        while (true) {
            if (iteratorA == a.size()) {

                newList.addAll(b.subList(iteratorB, b.size()));
                break;
            } else if (iteratorB == b.size()) {
                newList.addAll(a.subList(iteratorA, a.size()));
                break;
            }

            if (a.get(iteratorA) >= b.get(iteratorB)) {
                newList.add(b.get(iteratorB));
                iteratorB++;
            } else {
                newList.add(a.get(iteratorA));
                iteratorA++;
            }
        }

        return newList;
    }
}
