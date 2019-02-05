package example.concurrencyStatic;

public class Thread1 extends Thread {

    @Override
    public void run() {
        A a = new A();
        for (int i = 0; i < 100000; i++) {
            A.methodA(i, this.getName());
        }
        super.run();
    }
}
