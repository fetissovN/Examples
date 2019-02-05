package example.concurrencyStatic;

public class A {

    public static int counter = 0;

    public static void methodA(int i, String name) {
        counter = i;
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Integer a = new Integer(i);
        System.out.println("Class name " + name + " " + a);
        System.out.println("count: "+counter);
    }
}
