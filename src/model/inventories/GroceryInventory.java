package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.Ingredient;

import java.util.ArrayList;

public class GroceryInventory extends Inventory {
    private static KitchenInventory kitchen;

    public GroceryInventory() {
        super();
        kitchen = new KitchenInventory();
        ArrayList<Ingredient> kitchenInventory = kitchen.getInventory();
    }

    //REQUIRES: i must not be null
    //MODIFIES: this
    //EFFECTS: checks to see if there's already the same item in the inventory, and if it needs to be added to the list
    public void addToGroceries(Ingredient i) throws QuantityException {
        Double amountToAdd = amountNeeded(i);
        if (amountToAdd > 0) {
            i.setQuantity(amountToAdd);
        }

    }

    //REQUIRES: i must not be null
    //EFFECTS: checks to see the quantity needed to add to the grocery list
    private double amountNeeded(Ingredient i) {
        double inventoryAmount = 0;
        int indexToRemove = 0;

        for (Ingredient k: kitchen.getInventory()) {
            if (k.equals(i)) {
                inventoryAmount = Math.abs(k.getQuantity() - i.getQuantity());
                try {
                    k.removeQuantity(i.getQuantity());
                } catch (QuantityException e) {
                    kitchen.removeIngredient(indexToRemove);
                }
            }
            indexToRemove++;
        }
        return inventoryAmount;
    }

    @Override
    public String toString() {
        String res = "";
        int index = 1;

        for (Ingredient i: inventory) {
            res += index + ". " + i.getName() + ": " + (int) i.getQuantity() + "\n";
        }
        return res;
    }



}
