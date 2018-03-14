package example.other;

import java.util.HashMap;
import java.util.TreeMap;

public class Diff {

    public static void main(String[] args) {

    }

    class A{

        protected String getA() throws IndexOutOfBoundsException{
            return "as";
        }
    }

    class B extends A{
        @Override
        protected String getA() {
            return super.getA();
        }
    }

}
