package model.inventories;

import model.ingredients.Ingredient;
import org.apache.commons.math3.fraction.Fraction;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RecipeIngredients extends Inventory {
    private static final String FILENAME = "recipeIngredients.ser";

    public RecipeIngredients() {
        super();
        try {
            ObjectInputStream is = new ObjectInputStream (new FileInputStream(FILENAME));
            this.inventory = (ArrayList<Ingredient>) ((ObjectInputStream) is).readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

