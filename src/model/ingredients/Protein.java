package model.ingredients;

public class Protein extends Ingredient {
    public Protein(String name, int quantity) {
        super(name, quantity);
        this.DEFAULT_LIFESPAN = 3;
    }
}
