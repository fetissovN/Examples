package example.concurrency2;

public class TestExampleTrueFalse {

    /**
     * or volatile
     * or synchronized for both methods
     * volatile better
     */
    private volatile boolean canWork = true;

    public void doWork(){
        if (canWork){

        }
    }

    public void stop(){
        canWork = false;
    }
}
