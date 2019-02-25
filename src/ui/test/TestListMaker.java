//package ui.test;
//
//import model.exceptions.InvalidTypeException;
//import model.ingredients.Ingredient;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ui.ListMaker;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class TestListMaker {
//    ListMaker lm;
//
//    @BeforeEach
//    public void before(){
//        lm = new ListMaker();
//    }
//
//    @Test
//    public void testMakeIngredientValid() {
//        String[] parts = lm.parseInput("carrots produce 3");
//        try {
//            Ingredient ingredient = lm.makeIngredient(parts);
//            assertEquals("carrots", ingredient.getName());
//            assertEquals(3, ingredient.getQuantity());
//        } catch (InvalidTypeException e) {
//            fail("Caught unexpected InvalidTypeException");
//        } catch (NumberFormatException e) {
//            fail("Caught unexpected NumberFormatException");
//        }
//    }
//    @Test
//    public void testMakeIngredientValidIgnoreCase() {
//        String[] parts = lm.parseInput("carrots PrOduce 3");
//        try {
//            Ingredient ingredient = lm.makeIngredient(parts);
//            assertEquals("carrots", ingredient.getName());
//            assertEquals(3, ingredient.getQuantity());
//        } catch (InvalidTypeException e) {
//            fail("Caught unexpected InvalidTypeException");
//        } catch (NumberFormatException e) {
//            fail("Caught unexpected NumberFormatException");
//        }
//    }
//
//    @Test
//    public void testMakeIngredientInvalidType() {
//        String[] parts = lm.parseInput("carrots meat 3");
//        try {
//            lm.makeIngredient(parts);
//            fail("Failed to catch InvalidTypeException");
//        } catch (InvalidTypeException e) {
//            //nothing to do here
//        } catch (NumberFormatException e) {
//            fail("Caught unexpected NumberFormatException");
//        }
//    }
//
//    @Test
//    public void testMakeIngredientInvalidQuantity() {
//        String[] parts = lm.parseInput("carrots meat three");
//        try {
//            lm.makeIngredient(parts);
//            fail("Failed to catch NumberFormatException");
//        } catch (InvalidTypeException e) {
//            fail("Caught unexpected InvalidTypeException");
//        } catch (NumberFormatException e) {
//           //nothing to do here
//        }
//    }
//
//    @Test
//    public void testUserInput() {
//        lm.chooseAction("a");
//
//    }
//
//}