package example.happen_before;

public class Main {
    static boolean boo;
    static volatile int a = 0;
    static volatile int b = 0;
    int r1 = 0;
    int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                int r1 = a;
                b = 2;
                System.out.println(r1);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                int r2 = b;
                a = 1;
                System.out.println(r2);
            }
        }.start();
        Thread.sleep(300);
        System.out.println(a + " " + b);
        System.out.println(boo);
    }
}
