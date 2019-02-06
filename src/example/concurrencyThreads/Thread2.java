package example.concurrencyThreads;

public class Thread2 extends Thread {
    @Override
    public void run() {

//        System.out.println(Thread1.);
        System.out.println("thread 2 started");
        try {
            Thread2.sleep(4000);
            synchronized (Main.object) {
                System.out.println("notify");
                Main.object.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread1.);
        System.out.println("thread 2 finished");
    }
}
