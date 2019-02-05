package example.Padapter;

public class Main {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());
        carWash.washCar(new TruckWash(new MyTruck()));
    }
}
/**
 * Wrapper
 */
class TruckWash implements Car {
    Truck truck = null;

    public TruckWash(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void wash() {
        truck.clean();
    }
}

interface Car {
    void wash();
}

interface Truck {
    void clean();
}

class MyTruck implements Truck {
    @Override
    public void clean() {
        System.out.println("clean truck");
    }
}

class Audi implements Car {
    @Override
    public void wash() {
        System.out.println("wash car");
    }
}

class CarWash {
    public void washCar(Car car) {
        car.wash();
    }
}