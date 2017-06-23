package example.concurrency;


public class Counter implements Runnable {

    int count = 0;

    @Override
    public synchronized void run() {
            count++;
        System.out.println(this.count);
    }


}
