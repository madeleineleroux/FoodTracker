package test;

import model.GroceryList;
import model.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroceryList {
    private GroceryList gl;

    @BeforeEach
    public void before() {
        gl = new GroceryList();
        gl.clearList();
        gl.getInventory().clear();
    }


    @Test
    public void testToString() {
        Ingredient a = new Produce("a", 1);
        gl.addToInventory(a);
        Ingredient b = new Produce("b", 1);
        Ingredient c = new Produce("c", 1);
        Ingredient d = new Produce("d", 1);
        gl.addToList(a);
        gl.addToList(b);
        gl.addToList(c);
        gl.addToList(d);

        assertEquals("b: 1\n" +
                "c: 1\n" +
                "d: 1\n", gl.toString());
    }

    @Test
    public void testInInventory() {
        Ingredient a = new Produce("a", 1);
        Ingredient b = new Produce("b", 1);
        Ingredient c = new Produce("c", 1);
        Ingredient d = new Produce("d", 1);
        gl.addToList(a);
        gl.addToList(b);
        gl.addToList(c);
        gl.addToList(d);
        assertEquals("a: 1\n" +
                "b: 1\n" +
                "c: 1\n" +
                "d: 1\n", gl.toString());
    }

    @Test
    public void testMany() {
        Ingredient a = new Produce("a", 1);
        Ingredient b = new Produce("a", 1);
        Ingredient c = new Produce("a", 1);
        Ingredient d = new Produce("a", 1);
        gl.addToList(a);
        gl.addToList(b);
        gl.addToList(c);
        gl.addToList(d);

        assertEquals("a: 4\n", gl.toString());
    }

    @Test
    public void testInInventoryMulti() {
        Ingredient a = new Produce("a", 1);
        Ingredient b = new Produce("b", 1);
        Ingredient b2 = new Produce("b", 7);
        Ingredient c = new Produce("c", 1);
        Ingredient d = new Produce("d", 1);
        gl.addToInventory(b2);
        gl.addToInventory(a);
        gl.addToList(a);
        gl.addToList(b);
        gl.addToList(c);
        gl.addToList(d);

        assertEquals("c: 1\n" +
                "d: 1\n", gl.toString());
    }

    @Test
    public void testInInventoryMultiWExcess() {
        Ingredient a = new Produce("a", 1);
        Ingredient b = new Produce("b", 10);
        Ingredient b2 = new Produce("b", 7);
        Ingredient c = new Produce("c", 1);
        Ingredient d = new Produce("d", 1);
        gl.addToInventory(b2);
        gl.addToInventory(a);
        gl.addToList(a);
        gl.addToList(b);
        gl.addToList(c);
        gl.addToList(d);

        assertEquals("b: 3\n" +
                "c: 1\n" +
                "d: 1\n", gl.toString());
    }
}
