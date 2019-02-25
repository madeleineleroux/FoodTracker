package model.inventories;

import model.ingredients.Ingredient;
import org.apache.commons.math3.fraction.Fraction;

public class RecipeIngredients extends Inventory {

    public RecipeIngredients() {
        super();
    }

    @Override
    public String toString() {
        String res = "";
        for (Ingredient i: inventory) {
            Fraction amount = new Fraction(i.getQuantity());
            res += amount + " " + i.getMeasurement().toString() + i.getName() + "\n";
        }
        return res;
    }

}

