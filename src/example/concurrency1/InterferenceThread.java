package example.concurrency1;

public class InterferenceThread extends Thread {

    private final StateObject checker;

    public static InterferenceExample thread = new InterferenceExample();

    /**
     * 4) make StateObject class
     */

    public InterferenceThread(StateObject checker) {
        this.checker= checker;
    }

    public void run(){
        while (!thread.stop()){
            increment();
        }
    }

    private void increment() {
            checker.increment();
    }

    public int getI(){
        return checker.getI();
    }
}
