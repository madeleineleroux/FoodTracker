package model.ingredients.test;

import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testIngredient {
    Ingredient iTest;

    @BeforeEach
    public void before() {
        iTest = new Ingredient("Carrot", GroceryCategory.PRODUCE, 2, Measurement.NONE);
    }

    @Test
    public void testAddQuantity() {
        assertEquals(2, iTest.getQuantity());
        iTest.addToQuantity(1);
        assertEquals(2 + 1, iTest.getQuantity());

    }

    @Test
    public void testEqualsCorrect() {
        Ingredient iTest2 = new Ingredient("Carrot", GroceryCategory.PRODUCE, 4, Measurement.NONE);
        assertTrue(iTest2.equals(iTest));
    }
}
