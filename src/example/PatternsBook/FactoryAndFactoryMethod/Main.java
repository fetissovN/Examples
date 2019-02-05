package example.PatternsBook.FactoryAndFactoryMethod;


public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        pizza.getStyle();

//        NYStylePizzaStore nyStylePizzaStore = new NYStylePizzaStore();
//        Pizza cheese = nyStylePizzaStore.createPizza("cheese");
//        System.out.println(cheese.getStyle());
//        cheese.prepare();
//        cheese.bake();
//        cheese.cut();
//        cheese.box();
    }

}
interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
    String getStyle();
}

class CheesePizza implements Pizza{

    private static String style;


    public CheesePizza(String style) {
        this.style = style;
    }

    public String getStyle() {
        System.out.println(style);
        return style;
    }

    public static void setStyle(String style) {
        CheesePizza.style = style;
    }

    @Override
    public void prepare() {
        System.out.println("prepare cheese");
    }

    @Override
    public void bake() {
        System.out.println("bake cheese");
    }

    @Override
    public void cut() {
        System.out.println("cut cheese");
    }

    @Override
    public void box() {
        System.out.println("box cheese");
    }
}
class PepperoniPizza implements Pizza{

    public static String style;

    public PepperoniPizza(String style) {
        this.style = style;
    }

    @Override
    public String getStyle() {
        System.out.println(style);
        return style;
    }

    public static void setStyle(String style) {
        PepperoniPizza.style = style;
    }

    @Override
    public void prepare() {
        System.out.println("prepare Pepperoni");
    }

    @Override
    public void bake() {
        System.out.println("bake Pepperoni");
    }

    @Override
    public void cut() {
        System.out.println("cut Pepperoni");
    }

    @Override
    public void box() {
        System.out.println("box Pepperoni");
    }
}



//class SimplePizzaFactory {
//    public Pizza cratePizza(String type) {
//        switch (type) {
//            case "Pepperoni":
//                return new PepperoniPizza();
//            case "Cheese":
//                return new CheesePizza();
//            default:
//                return null;
//        }
//    }
//}

abstract class PizzaStore {

    /**
     * all commited code refer to simple Factory
     */

//    SimplePizzaFactory factory;

//    public PizzaStore(SimplePizzaFactory factory) {
//        this.factory = factory;
//    }

    public Pizza orderPizza(String type) {
//        Pizza pizza = factory.cratePizza(type);
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * Abstract method to be implemented
     */
    abstract Pizza createPizza(String type);
}

class NYStylePizzaStore extends PizzaStore{

    public static final String style = "NY";

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza(style);
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza(style);
        }
        return null;
    }
}

class ChicagoStylePizzaStore extends PizzaStore{

    public static final String style = "Chicago";

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza(style);
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza(style);
        }
        return null;
    }
}


