package example.other;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            a.add(ThreadLocalRandom.current().nextInt(0, 20_000 + 1)
            );
        }
        for (int i = 0; i < 20_000; i++) {
            b.add(ThreadLocalRandom.current().nextInt(0, 20_000 + 1)
            );
        }
        Collections.sort(a);
        Collections.sort(b);

        ArrayList arrayList = new ArrayList();
//        arrayList.add(2);
//        arrayList.add(7);
//        arrayList.add(9);
//        arrayList.add(1);
//        arrayList.add(4);
//        arrayList.add(0);
//        arrayList.add(3);
//        MergeSort mergeSort = new MergeSort(arrayList);
//        mergeSort.sortGivenArray();
//        for(int i:mergeSort.getSortedArray()){
//            System.out.println(i + " ");
//        }
//        Calendar calendarBefore = Calendar.getInstance();
//        long timeInMillisBefore = calendarBefore.getTimeInMillis();
//        ArrayList<Integer> list = merge(a, b);
//        Calendar calendarAfter = Calendar.getInstance();
//        long timeInMillisAfter = calendarAfter.getTimeInMillis();
//        System.out.println("Iteration time: " + (timeInMillisAfter-timeInMillisBefore));

//        long timeStart = System.nanoTime();
//        ArrayList<Integer> list2 = mergeStupid(a, b);
////        for (Integer i: list2) {
////            System.out.println(i);
////        }
//        long timeEnd = System.nanoTime();
//        System.out.println("Iteration time: " + ((timeEnd-timeStart)/1000));
//
        Set<List<Integer>> lists = new HashSet<>();
        lists.add(a);
        lists.add(b);
        long timeStart = System.nanoTime();
        ArrayList<Integer> list3 = merge(lists);
//        for (Integer i: list3) {
//            System.out.println(i);
//        }
        long timeEnd = System.nanoTime();
        System.out.println("Iteration time: " + ((timeEnd-timeStart)/1000));

//        HashMap<CustomObject,Integer> map = new HashMap<>();
////        map.put(new CustomObject(1,"Nick"),2);
//        map.put(new CustomObject(2,"Derreck"),3);
//        map.put(new CustomObject(2,"Derreck"),3);
//        map.put(new CustomObject(2,"Der"),3);
//        System.out.println(map.get(1));
//        for (Map.Entry<CustomObject,Integer> m: map.entrySet()) {
//            System.out.println(m);
//        }
    }

//    static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
////        a.ensureCapacity(a.size()+b.size());
//        int size = b.size();
//        if (a.get(0)>b.get(size-1)){
//            a.addAll(0,b);
//            return a;
//        }
//        if (a.get(size-1) < b.get(0)){
//            a.addAll(b);
//            return a;
//        }
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < a.size()-1; j++) {
//                int actualSize = a.size();
//                if (b.get(i)>a.get(actualSize-1)){
//                    a.addAll(b.subList(i,size));
//                    return a;
//                }
//                if (b.get(i) > a.get(actualSize-2-j)){
//                    a.add(actualSize-1-j,b.get(i));
//                    break;
//                }
//            }
//        }
//
//        return a;
//    }
//
    static ArrayList<Integer> mergeStupid(ArrayList<Integer> a, ArrayList<Integer> b){
        int size = b.size();
        if (a.get(0)>b.get(size-1)){
            a.addAll(0,b);
            return a;
        }
        if (a.get(size-1) < b.get(0)){
            a.addAll(b);
            return a;
        }

        a.addAll(b);
        Collections.sort(a);
        return a;
    }
//
//    static ArrayList<Integer> mergeNew(ArrayList<Integer> a, ArrayList<Integer> b){
//        int size = b.size();
//        if (a.get(0)>b.get(size-1)){
//            a.addAll(0,b);
//            return a;
//        }
//        if (a.get(size-1) < b.get(0)){
//            a.addAll(b);
//            return a;
//        }
//        a.addAll(b);
//        a.stream().sorted();
//        return a;
//    }

//    static ArrayList<Integer> cleverSort(ArrayList<Integer> a, ArrayList<Integer> b){
//        int size = b.size();
//        if (a.get(0)>b.get(size-1)){
//            a.addAll(0,b);
//            return a;
//        }
//        if (a.get(size-1) < b.get(0)){
//            a.addAll(b);
//            return a;
//        }
//        a.addAll(b);
//        int temp;
//        for (int i = 0; i < size; i++) {
//            if (a.get(i) > b.get(i)){
//                temp = a.get(i);
//                a.set(i,b.get(i));
//
//            }
//        }
//    }

    public static ArrayList<Integer> merge(Set<List<Integer>> lists) {
        int totalSize = 0; // every element in the set
        for (List<Integer> l : lists) {
            totalSize += l.size();
        }

        ArrayList<Integer> result = new ArrayList<Integer>(totalSize);

        List<Integer> lowest;

        while (result.size() < totalSize) { // while we still have something to add
            lowest = null;

            for (List<Integer> l : lists) {
                if (! l.isEmpty()) {
                    if (lowest == null) {
                        lowest = l;
                    } else if (l.get(0).compareTo(lowest.get(0)) <= 0) {
                        lowest = l;
                    }
                }
            }

            result.add(lowest.get(0));
            lowest.remove(0);
        }

        return result;
    }

}
