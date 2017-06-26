package example.concurrency1;


public class StateObject {

    private int i;

    public synchronized void increment(){
        i++;
    }

    public int getI(){
        return i;
    }
}
