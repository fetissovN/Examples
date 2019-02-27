package example.PObjectPool;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.stream.Stream;


public class ObjectPool {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        ObjectPoolClass objectPool = new ObjectPoolClass();
        ObjectPoolClass objectPool2 = new ObjectPoolClass();
        PooledObject pooledObject = objectPool.getPooledObject();
        objectPool.releasePooledObject(pooledObject);
        ObjectPool objectPool1 = new ObjectPool();
        ObjectPool objectPool3 = new ObjectPool();
        System.out.println(objectPool1.equals(objectPool3));

        Map<Object,String> map = new HashMap<>();
        map.put(new A("a"), "ASD");
        map.put(new A("b"), "ASDd");
//        map.put(new B(), "DDD");
        System.out.println(map.size());
//        System.out.println("asdasd");
        System.out.println(map.get(new A("a")));

//        map.forEach((s, s2) -> System.out.println(s + " " + s2));
    }
}
//
//class B {
//    @Override
//    public int hashCode() {
//        return 10;
//    }
//}

class A {

    String value;

    public A(String value) {
        this.value = value;
    }



    public static String fin = "asd";


    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public boolean equals(Object o) {
        A a = (A) o;
        return Objects.equals(value, a.value);
    }

    void meth2() {
        fin = "adaddasd";

    }

    public void meth() {
        Set<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                fin+="   asda";
                System.out.println(fin);
                return 0;
            }
        });
        set.add("adada");

    }
}

class PooledObject{

}

class ObjectPoolClass{

    List<PooledObject> free = new LinkedList<>();
    List<PooledObject> used = new LinkedList<>();

    public PooledObject getPooledObject(){
        if (free.isEmpty()){
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);
            return pooledObject;
        }else {
            PooledObject pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
            return pooledObject;
        }
    }

    public void releasePooledObject(PooledObject pooledObject){
        used.remove(pooledObject);
        free.add(pooledObject);
    }

}
