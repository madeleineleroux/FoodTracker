package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;

import java.io.*;
import java.util.ArrayList;

public class KitchenInventory implements Serializable, Storage {
    private static ArrayList<Ingredient> inventory = new ArrayList<>();
    private final static String FILENAME = "kitchen.ser";

    public KitchenInventory(){

        try {
            ObjectInputStream is = new ObjectInputStream (new FileInputStream(FILENAME));
            this.inventory = (ArrayList<Ingredient>) ((ObjectInputStream) is).readObject();
            System.out.println(toString());
        } catch (Exception e) {
            System.out.println("There wasn't a file");
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }

    @Override
    public void clearInventory() {
        inventory.clear();
        outputStream();
    }

    public void outputStream() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
            os.writeObject(getInventory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Ingredient ingredient) throws QuantityException {
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

    @Override
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

    @Override
    public void removeIngredient(int index) {
        inventory.remove(index);
        outputStream();
    }

    @Override
    public String toString() {
        String printString = "";
        for (Ingredient i : inventory) {
            printString += (i.getName() + ": " + (int) i.getQuantity() + "\n");
        }
        return printString;
    }

    public static void main(String[] args) throws Exception {
        KitchenInventory k = new KitchenInventory();
        Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
        k.add(i);
    }
}
