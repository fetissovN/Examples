package example.concurrency;

public class InterferenceThread extends Thread {

    /**
     * 4 ways to synchronize programme
     */
    private final InterferenceExample checker;

    /**
     * Should be static to work
     * otherwise new Object will be created for each thread
     * and can't be synchronized on not global object
     */
//    private static Object o = new Object();

    /**
     * make volatile
     * 4) look in concurrency1 pack
     */
    private static int  i;

    public InterferenceThread(InterferenceExample checker) {
        this.checker= checker;
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
//        synchronized (o){
            i++;
//        }
    }

    public int getI(){
        return i;
    }

}
