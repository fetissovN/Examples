package example.concurrency;


public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter counter2 = new Counter();
//        counter.run();
//        counter2.run();
//        Counter counter3 = new Counter();
//        Counter counter4 = new Counter();
//        counter3.run();
//        counter4.run();
        for (int i=0;i<10000;i++){
            counter.run();
            counter2.run();
        }

    }
}
