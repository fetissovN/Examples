package example.concurrency;


import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static volatile AtomicInteger m = new AtomicInteger(0);
    int j = 0;
    Test teslt = new Test();

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 1000; i++) {
            new TestThread().start();
        }
        Thread.sleep(2000);
        System.out.println(Test.m.get());
    }




}

class TestThread extends Thread{
    @Override
    public void run() {
        Test.m.incrementAndGet() ;
        Test.m.decrementAndGet() ;
        Test.m.incrementAndGet() ;

    }
}