package design_pattern.decorator_pattern;

interface Pizza {
    String getDescription();

    double getCost();
}

// Concrete Component
class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "PlainPizza Pizza";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}

// Decorator Abstract Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza; // HAS-A relationship

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete Decorators

class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0;
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}

public class DecoratorPatternMain {
    public static void main(String[] args) {
        Pizza pizza = new ExtraCheese(new PlainPizza());
        System.out.println(pizza.getCost());
        Pizza margheritaCheesePizza = new ExtraCheese(new MargheritaPizza());
        Pizza olivesCheese = new Olives(margheritaCheesePizza);
        System.out.println(olivesCheese.getDescription());
    }
}
