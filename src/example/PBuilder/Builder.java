package example.PBuilder;


import org.omg.CORBA.PRIVATE_MEMBER;

public class Builder {

    public static void main(String[] args) {
        SprotCar sprotCar = new SprotCar.Builder("Audi")
                .setColor("white")
                .setMaxSpeed(333)
                .build();
        System.out.println(sprotCar.getColor() + " " + sprotCar.getMaxSpeed());
    }
}

class SprotCar{
    private String name;
    private String color;
    private int maxSpeed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private SprotCar(Builder builder){
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    static class Builder{
        private String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SprotCar build(){
            return new SprotCar(this);
        }
    }
}
