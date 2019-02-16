package model.ingredients;

public class Pantry extends Ingredient {
    public Pantry(String name, int quantity) {
        super(name, quantity);
        this.DEFAULT_LIFESPAN = 30;
    }
}
