package model.inventories.test;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;
import model.inventories.GroceryInventory;
import model.inventories.KitchenInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testGroceryInventory {
    private GroceryInventory gl;
    private KitchenInventory k;

    @BeforeEach
    public void before(){
        gl = new GroceryInventory();
        gl.clearInventory();
        k = new KitchenInventory();
        k.clearInventory();
    }

    @Test
    public void testConstructor() {
        assertTrue(gl.getInventory().isEmpty());
        assertTrue(k.getInventory().isEmpty());
    }

    @Test
    public void testNotInKitchen() {
        try {
            assertTrue(k.getInventory().isEmpty());
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            gl.add(i);
            assertTrue(k.getInventory().isEmpty());
            assertEquals(1, gl.getInventory().size());
        } catch (QuantityException e) {
            fail();
        }

    }


    @Test
    public void testNotInKitchenDouble() {
        try {
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            Ingredient i2 = new Ingredient("carrot", GroceryCategory.PRODUCE, 2, Measurement.NONE);
            gl.add(i);
            gl.add(i2);
            assertEquals(gl.getKitchenInventory().size(), 0);
            assertEquals(1, gl.getInventory().size());
            assertEquals(5.0, gl.getInventory().get(0).getQuantity());
        } catch (QuantityException e) {
            fail();
        }
    }

    @Test
    public void testInKitchen() {
        try {
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            k.add(i);
            gl.add(i);
            //assertTrue(gl.getInventory().isEmpty());
            assertTrue(k.getInventory().isEmpty());
        } catch (QuantityException e) {
            fail();
        }
    }

    @Test
    public void testInKitchenMulti() {
        try {
            KitchenInventory k = new KitchenInventory();
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            k.add(i);
            gl.add(i);
            gl.add(i);
            assertTrue(gl.getKitchenInventory().isEmpty());
            assertEquals(1, gl.getInventory().size());
            assertEquals(3, gl.getInventory().get(0).getQuantity());
        } catch (QuantityException e) {
            fail();
        }
    }

    @Test
    public void testInKitchenMulti2() {
        try {
            KitchenInventory k = new KitchenInventory();
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            Ingredient i2 = new Ingredient("carrot", GroceryCategory.PRODUCE, 10, Measurement.NONE);
            k.add(i2);
            gl.add(i);
            assertEquals(0, gl.getInventory().size());
            assertEquals(10 - 3, k.getInventory().get(0).getQuantity());
        } catch (QuantityException e) {
            fail();
        }
    }

    @Test
    public void testInKitchenMulti3() {
        try {
            KitchenInventory k = new KitchenInventory();
            Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
            Ingredient i2 = new Ingredient("carrot", GroceryCategory.PRODUCE, 4, Measurement.NONE);
            Ingredient i3 = new Ingredient("beets", GroceryCategory.PRODUCE, 2, Measurement.NONE);
            Ingredient i4 = new Ingredient("meat", GroceryCategory.PROTEIN, 1, Measurement.NONE);
            k.add(i2);
            gl.add(i);
            gl.add(i3);
            gl.add(i4);
            assertEquals(2, gl.getInventory().size());
            assertEquals(4 - 3, k.getInventory().get(0).getQuantity());
        } catch (QuantityException e) {
            fail();
        }
    }
}
