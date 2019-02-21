package example.RQ;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {
    static int k = 0;
    static SoftReference<One> wReference;
    static ReferenceQueue<One> queue;


    public static void main(String[] args) throws InterruptedException {
        One one = new One();
        queue = new ReferenceQueue<>();
        wReference = new SoftReference<>(one, queue);
//        WeakReference<One> wReference = new WeakReference<>(one, queue);
//        SoftReference<One> sReference = new SoftReference<>(one);
//        PhantomReference<One> pReference = new PhantomReference<>(one, queue);
        System.out.println(wReference.isEnqueued());

        one = null;

        System.gc();

        for (int i = 0; i < 1_000_000; i++) {
            k = i+1;
        }
//        System.out.println(wReference.isEnqueued());
//        System.out.println(reference.get());
//        System.out.println(queue.poll().get());

        System.out.println("___");
        method();

    }

    static void method() {
        System.out.println(wReference.isEnqueued());
        System.out.println(wReference.get());
        One one = wReference.get();
        System.out.println(queue.poll());
//        System.out.println(reference.get());
//        System.out.println(queue.poll().get());

    }
}

class One {
    String name = "one";

    @Override
    public String toString() {
        return "One{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized");
        super.finalize();
    }
}
