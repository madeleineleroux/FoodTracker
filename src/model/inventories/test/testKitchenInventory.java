package model.inventories.test;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;
import model.inventories.KitchenInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class testKitchenInventory {
    KitchenInventory testKitchen;

    @BeforeEach
    public void before() {
        testKitchen = new KitchenInventory();
        testKitchen.clearInventory();

    }

    @Test
    public void testStatic() {
        Ingredient i = new Ingredient("beets", GroceryCategory.PRODUCE, 2, Measurement.NONE);
        Ingredient i2 = new Ingredient("meat", GroceryCategory.PROTEIN, 1, Measurement.NONE);
        KitchenInventory testKitchen2 = new KitchenInventory();
        try {
            testKitchen2.add(i);
            testKitchen.add(i2);
            //assertEquals(testKitchen2.toString(), testKitchen.toString());

        } catch (QuantityException e) {
           fail();
        }

    }
}
