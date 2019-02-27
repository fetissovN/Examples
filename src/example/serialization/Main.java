package example.serialization;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial("aaa", "ddd");
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        TestSerial tsS = (TestSerial) oin.readObject();
        System.out.println("version="+tsS.version);
    }
}

class TestSerial extends Parent implements Serializable {
//    private static final long serialVersionUID = 5;
    public byte version = 100;

    public byte count = 0;
    public Contain contain = new Contain();

    public TestSerial(String s, String aaa) {
        super(aaa);
//        this.contain = new Contain(s);
    }

    void method() {
        System.out.println(version);
    }
}

class Parent implements Serializable{
    int parentVersion;

    String s;

    public Parent() {
    }

    public Parent(String aaa) {
        this.s = aaa;
    }

//    public Parent() {
//    }

    public Parent(int parentVersion) {
        this.parentVersion = parentVersion;
    }
}


// Aggregation classes should impl Serializable
class Contain {
    int containVersion = 11;

    String s = "asdasdasdas";


}