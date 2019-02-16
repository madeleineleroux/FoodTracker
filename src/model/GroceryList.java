package model;

import model.exceptions.QuantityException;
import model.ingredients.Ingredient;

import java.util.ArrayList;

// Class needs to store a grocery list, and when the items are purchased they are removed from the list
// also needs to print out the list

public class GroceryList {
    IngredientStorage inventory;
    static ArrayList<Ingredient> items = new ArrayList<>();

    public GroceryList() {
        inventory = new IngredientStorage();
    }

    // MODIFIES: items
    // EFFECTS: adds to items if not already in inventory, otherwise puts the amount needed
    public void addToList(Ingredient item){
        try {
            int itemQuantityNeeded = amountNeeded(item);
            item.setQuantity(itemQuantityNeeded);

            if (itemQuantityNeeded > 0) {
                boolean found = false;

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getName().equalsIgnoreCase(item.getName())) {
                        items.get(i).addToQuantity((int)item.getQuantity());
                        found = true;
                    }
                }
                if (!found) {
                    items.add(item);
                }
            }
        } catch (QuantityException e) {
            System.out.println("Item not added because the quantity is invalid. ");
        }
    }

    //MODIFIES: this
    //EFFECTS: clears items list
    public void clearList(){
        items.clear();
    }

    //REQUIRES: item must not be null
    //MODIFIES: inventory
    //EFFECTS: adds item to inventory
    public void addToInventory(Ingredient item) {
        inventory.add(item);
    }

    // MODIFIES: items & inventory
    //EFFECTS: removes item from items, and the quantity of itemName from inventory
    private void removeFromList(String itemName, int quantity) {
        if (items.contains(itemName)) {
            inventory.reduceQuantity(itemName, quantity);
            removeItem(itemName);
        }
    }

    // MODIFIES: items
    // EFFECTS: removes item from items
    public void removeItem(String item) {
        int removeIndex = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(item)) {
                removeIndex = i;
            }
        }
        if (removeIndex >= 0) {
            items.remove(removeIndex);
        }
    }

    // REQUIRES: index to be a valid index
    // MODIFIES: items
    // EFFECTS: removes item at index i
    public void removeItem(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Please enter a valid number.");
        }
        items.remove(index);
    }


    //EFFECTS: returns true if there isn't enough of the item in inventory to meet item quantity
    private int amountNeeded(Ingredient item) {
        double difference = item.getQuantity() - inventory.getQuantity(item.getName());

        if (difference <= 0) {
            return 0;
        } else {
            return Math.abs((int) difference);
        }
    }

    @Override
    public String toString() {
        String printString = "";
        for (Ingredient i : items) {
            printString += (i.getName() + ": " + i.getQuantity() + "\n");
        }
        return printString;
    }

    public String toPrint() {
        String printString = "";
        for (int i = 0; i < items.size(); i++) {
            printString += (i + 1) + ". " + items.get(i).getName() + ": " + items.get(i).getQuantity() + "\n";
        }
        return printString;
    }

    public IngredientStorage getInventory() {
        return inventory;
    }

    public ArrayList<Ingredient> getItems() {
        return items;
    }
}



// Needs to store items, their quantities