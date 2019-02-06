package example.concurrencyThreads;

public class Thread1 extends Thread {



    @Override
    public void run() {

//        System.out.println(Thread1.);
        System.out.println("thread 1 started");
        try {
            synchronized (Main.object) {
                System.out.println("Thread 1 wait");
                Main.object.wait();
                System.out.println("Thread 1 not waiting");
            }
//            Thread1.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread 1 finished");
    }

    @Override
    public State getState() {
        return super.getState();
    }
}
