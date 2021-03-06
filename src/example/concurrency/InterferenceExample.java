package example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class InterferenceExample {

    public static final int Million = 1_000_000;

    private AtomicInteger counter = new AtomicInteger();

    public boolean stop(){

       return counter.incrementAndGet() > Million;
    }

    public void example() throws InterruptedException{
        InterferenceThread thread1 = new InterferenceThread(this);
        InterferenceThread thread2 = new InterferenceThread(this);
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("Expected: "+ Million);
        System.out.println("Result: "+ thread1.getI());
    }
}
