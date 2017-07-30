package example.PfactoryMethod;

public class FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
        person.hashCode();
    }
}

class Person{
    private Person(){

    }
    public static Person create(){
        return new Person();
    }
}
