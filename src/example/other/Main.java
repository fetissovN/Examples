package example.other;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setPrice(1);
        car1.setSpeed(1);
        Car car2 = new Car();
        car2.setPrice(1);
        car2.setSpeed(2);

        HashSet<Car> hashSet = new HashSet();
        hashSet.add(car1);
        hashSet.add(car2);
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        for (Car car: hashSet) {
            System.out.println(car);
        }
        System.out.println(hashSet.size());
    }

    public static void mmm(){
        List<Integer> integers = new LinkedList<>();
        integers.add(2);
        integers.add(1);
        integers.add(6);
        integers.add(9);
        integers.add(0);
        ArrayList<Integer> arrayList = new ArrayList<>(integers.subList(2,5));
        Collections.sort(arrayList);
        for (Integer integer: arrayList){
            System.out.println(integer);
        }
    }
}
class Car{
    private int price;
    private int speed;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        return speed == car.speed;

    }

    @Override
    public int hashCode() {
        return price;
    }
}
