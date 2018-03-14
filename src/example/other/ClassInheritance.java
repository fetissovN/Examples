package example.other;


public class ClassInheritance {
    public static void main(String[] args) {
//        new B();
        System.out.println(new A() instanceof B);
        System.out.println(new B() instanceof A);
        System.out.println(new C() instanceof B);
        System.out.println(new B() instanceof B);

    }
}

class A {
//    static {
//        System.out.println("static-A, ");
//    }
//    {
//        System.out.println("init-A, ");
//    }
//    public A(){
//        System.out.println("constructor-A");
//    }
}

class B extends A{
//    static {
//        System.out.println("static-B, ");
//    }
//    {
//        System.out.println("init-B, ");
//    }
//    public B(){
//        System.out.println("constructor-B");
//    }
}
class C extends B{}

class Parent{
    protected Parent method(Parent list) throws Exception{
        return new Parent();
    }
}
class Child extends Parent{
    @Override
    protected Child method(Parent list) throws Exception {
        return new Child();
    }
}

