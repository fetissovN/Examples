package example.other;

public class Interface8 {
    public static void main(String[] args) {
    Normal normal = new Normal();
    normal.mmm();

    }
}

class Normal implements TestA {

    public void mmm() {
        TestA.m2();
//        TestA.InnerAbs innerAbs = new InnerAbs() {
//            @Override
//            void pr() {
//                System.out.println("abs");
//            }
//        };
//        innerAbs.pr();
        
    }

}

interface TestA {

    public static final String asd = "ad";

    public default void m() {
        System.out.println("mDef");
    }

    static void m2() {
        System.out.println("mDef");
    }

    abstract class InnerAbs {
        abstract void pr();
        void pr2() {
            System.out.println("pr2");
        }
    }
}
