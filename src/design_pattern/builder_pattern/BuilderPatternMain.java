package design_pattern.builder_pattern;

// BurgerMeal

// Bun
// Patty

// sides
// toppings
// cheese

import java.util.List;

class BurgerMeal {
    // Required
    private final String bun;
    private final String patty;

    // Optional
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    private BurgerMeal(BurgerBuilder burgerBuilder) {
        this.bun = burgerBuilder.bun;
        this.patty = burgerBuilder.patty;
        this.hasCheese = burgerBuilder.hasCheese;
        this.toppings = burgerBuilder.toppings;
        this.side = burgerBuilder.side;
        this.drink = burgerBuilder.drink;
    }

    public static class BurgerBuilder {
        // Required
        private final String bun;
        private final String patty;

        // Optional
        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;

        public BurgerBuilder(String bun, String patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public BurgerBuilder withCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerBuilder withSide(String side) {
            this.side = side;
            return this;
        }

        public BurgerBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }

    @Override
    public String toString() {
        return "BurgerMeal{" +
                "bun='" + bun + '\'' +
                ", patty='" + patty + '\'' +
                ", hasCheese=" + hasCheese +
                ", toppings=" + toppings +
                ", side='" + side + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}

public class BuilderPatternMain {
    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("wheat", "veg").build();
        BurgerMeal burgerMealWithCheese = new BurgerMeal.BurgerBuilder("wheat", "veg").withCheese(true).build();
        System.out.println(burgerMeal);
        System.out.println(burgerMealWithCheese);
    }
}
