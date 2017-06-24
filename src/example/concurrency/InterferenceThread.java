package example.concurrency;

public class InterferenceThread extends Thread {

    /**
     * 4 ways to synchronize programme
     */
    private final InterferenceExample checker;

    /**
     * make volatile
     * 4) make StateObject class
     */
//    private static volatile int  i;

    StateObject stateObject = new StateObject();

    private static Object object = new Object();

    public InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    public void run(){
        while (!checker.stop()){
            increment();
        }
    }

    /**
     * 1) white in signature of a method synchronized static
     * 2) synchronize inside with static lock object
     * 3) synchronize inside with static checker
     */
    private void increment() {
//        synchronized (object){
            stateObject.increment();
//            i++;
//        }
    }

    public int getI(){
        return stateObject.getI();
    }
}
