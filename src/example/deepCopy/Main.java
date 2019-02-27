package example.deepCopy;

import java.io.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        // (1) create a Person object named Al
        Address address = new Address("305 West Fern Avenue", "Palmer", "Alaska");
        Person al = new Person("Al", "Alexander", address);

        // (2) make a deep clone of Al
        Person neighbor = (Person)deepClone(al);
//        Person neighbor = (Person) al.clone();

        // (3) modify the neighbor's attributes
        neighbor.firstName = "Martha";
        neighbor.lastName = "Stewart";

        // (4) show that it all worked
        System.out.print(neighbor);
    }

    public static Object deepClone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * These classes implement Serializable so we can write them out and
 * read them back in as a stream of bytes.
 */
class Person implements Serializable{
    String firstName, lastName;
    Address address;
    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String method() {
        return address.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + firstName + "\n");
        sb.append("Last Name: " + lastName + "\n");
        sb.append("Street: " + address.street + "\n");
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address implements Serializable{
    String street, city, state;
    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}


