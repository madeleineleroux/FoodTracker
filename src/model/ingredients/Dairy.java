package model.ingredients;

public class Dairy extends Ingredient {
    public Dairy(String name, int quantity) {
        super(name, quantity);
        this.DEFAULT_LIFESPAN = 14;
    }
}
