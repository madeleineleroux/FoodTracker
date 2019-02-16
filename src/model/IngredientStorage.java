package model;

import model.exceptions.QuantityException;
import model.ingredients.Ingredient;

import java.util.ArrayList;

public  class IngredientStorage {
    static ArrayList<Ingredient> storage = new ArrayList<>();

    public IngredientStorage() {
    }

    //MODIFIES: items
    // EFFECTS: adds item to items if not in the list already, otherwise updates the quantity
    public void add(Ingredient item) {
        boolean found = false;
        for (Ingredient i : storage) {
            if (i.equals(item)) {
                try {
                    i.addToQuantity(item.getQuantity());
                    found = true;
                } catch (QuantityException e) {
                    System.out.println("Failed to add item because it is an invalid quantity.");
                }
            }
        }

        if (!found) {
            storage.add(item);
        }
    }

    public void clear() {
        storage.clear();
    }


    //MODIFIES: items
    // EFFECTS: removes quantity from itemName, and removes it from the list if itemName quantity reaches 0
    public void reduceQuantity(String itemName, int quantity) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getName().equalsIgnoreCase(itemName)) {
                try {
                    storage.get(i).removeQuantity(quantity);
                } catch (QuantityException e) {
                    storage.remove(i);
                    break;
                }
            }
        }
    }

    //MODIFIES: items
    //EFFECTS: removes item from items
    public void remove(String itemName) {
        int toRemove = -1;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getName().equalsIgnoreCase(itemName)) {
                toRemove = i;
            }
        }
        if (toRemove >= 0) {
            storage.remove(toRemove);
        }
    }


    public int getQuantity(String name) {
        for (Ingredient i: storage) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i.getQuantity();
            }
        }
        return 0;
    }
}
