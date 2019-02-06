package example.concurrencyThreads;

public class Main {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started");

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Deamon deamon = new Deamon();
        deamon.setDaemon(true);
        System.out.println(deamon.getState().toString());

        thread1.setPriority(1);
        thread1.start();
        thread2.start();
        deamon.start();

        Thread.sleep(3000);
        System.out.println("extra " + thread1.getState());



        System.out.println("Main finished");
    }
}
