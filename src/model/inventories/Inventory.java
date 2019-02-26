package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.Ingredient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class Inventory implements Storage {
    protected static ArrayList<Ingredient> inventory = new ArrayList<>();
    protected String FILENAME;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    //EFFECTS: returns inventory
    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }

    private void outputStream() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
            os.writeObject(getInventory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //MODIFIES: this
    //EFFECTS: empties inventory
    public void clearInventory() {
        inventory.clear();
        outputStream();
    }

    //REQUIRES: ingredient must not be null
    //MODIFIES: this
    //EFFECTS: adds Ingredient to inventory, if already in inventory adds to the quantity
    public void add(Ingredient ingredient) throws QuantityException{
        boolean found = false;

        for (Ingredient i : inventory) {
            if (ingredient.equals(i)) {
                found = true;
                i.addToQuantity(ingredient.getQuantity());
            }
        }

        if (!found) {
            inventory.add(ingredient);
        }

        outputStream();
    }

    //REQUIRES: input must not be null
    //MODIFIES: this
    //EFFECTS: remove the ingredient entry with the same name as input
    public void removeIngredient(String name) {
        int index = 0;
        int toRemove;

        for (Ingredient i: inventory) {
            if (i.getName().equalsIgnoreCase(name)) {
                toRemove = index;
            }
            index++;
        }

        outputStream();
    }

    //REQUIRES: input must not be null
    //MODIFIES: this
    //EFFECTS: remove the ingredient entry with the same name as input
    public void removeIngredient(int index) {
        inventory.remove(index);
        outputStream();
    }

    //EFFECTS: prints a list of all items in inventory
    @Override
    public String toString() {
        String printString = "";
        for (Ingredient i : inventory) {
            printString += (i.getName() + ": " + (int) i.getQuantity() + "\n");
        }
        return printString;
    }
}
