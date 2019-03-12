package example.other.tasks;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class MiddleInLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        while (list.size() != 1) {
//            list.removeLast();
//            list.removeFirst();
//        }

        // find middle
//        int tempMid = 0;
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            int temp =  iterator.next();
//            if (iterator.hasNext()) {
//                tempMid = temp;
//                iterator.next();
//            }
//        }

        // find from the end
        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> iterator2 = list.iterator();
        int res = 0;
        int set = 2; // from the end
        while (iterator.hasNext()) {
            res = iterator2.next();
            while (set != 1) {
                iterator.next();
                set--;
            }
            iterator.next();
        }
        System.out.println(res);
        Stream<Integer> integerStream = list.stream().filter(integer -> integer == 2);
        integerStream.forEach(System.out::println);


    }
}
