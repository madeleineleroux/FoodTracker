package model.inventories.test;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;
import model.inventories.RecipeIngredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testRecipeIngredients {
    RecipeIngredients rp;

    @BeforeEach
    public void before() {
        rp = new RecipeIngredients();
    }

    @Test
    public void testAdd() {
        Ingredient i = new Ingredient("Carrot", GroceryCategory.PRODUCE, 1, Measurement.NONE);
        try {
            rp.add(i);
            assertEquals(1, rp.getInventory().size());
        } catch (QuantityException e) {
            fail();
        }
    }

    @Test
    public void testAddDouble() {
        Ingredient i = new Ingredient("Carrot", GroceryCategory.PRODUCE, 1, Measurement.NONE);
        Ingredient i2 = new Ingredient("Carrot", GroceryCategory.PRODUCE, 2, Measurement.NONE);
        try {
            rp.add(i);
            rp.add(i2);
            assertEquals(1, rp.getInventory().size());
            assertEquals(rp.getInventory().get(0).getQuantity(), 1 + 2);
        } catch (QuantityException e) {
            fail();
        }
    }
}
