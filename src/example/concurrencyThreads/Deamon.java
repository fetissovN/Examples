package example.concurrencyThreads;

public class Deamon extends Thread {
    @Override
    public void run() {
        System.out.println("deamon started");
        try {
            Deamon.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("deamon finished");
    }
}
