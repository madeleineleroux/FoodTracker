package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;

import java.io.*;
import java.util.ArrayList;

public class GroceryInventory extends Inventory implements Serializable {
    private KitchenInventory kitchen = new KitchenInventory();
    //private static ArrayList<Ingredient> inventory = new ArrayList<>();


    public GroceryInventory() {
        this.FILENAME = "groceryList.ser";

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
            this.inventory = (ArrayList<Ingredient>) ((ObjectInputStream) is).readObject();
            //System.out.println(toString());
            //System.out.println(inventory.toString());
        } catch (Exception e) {
            System.out.println("grocery list");
        }
    }


    private void removeFromKitchen(int index) {
        kitchen.removeIngredient(index);
    }

    public ArrayList<Ingredient> getKitchenInventory (){
        return kitchen.getInventory();
    }

    @Override
    //REQUIRES: i must not be null
    //MODIFIES: this
    //EFFECTS: checks to see if there's already the same item in the inventory, and if it needs to be added to the list
    public void add(Ingredient i) throws QuantityException {
        double boundary = amountNeeded(i);
        if (boundary > 0) {
            super.add(i);
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
            os.writeObject(getInventory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //TODO: Refactor, make gregor happy (doing two things)
    //REQUIRES: i must not be null
    //EFFECTS: checks to see the quantity needed to add to the grocery list
    private double amountNeeded(Ingredient i) throws QuantityException{
        double inventoryAmount;
        double difference = i.getQuantity();
        Ingredient inKitchen;

        for (int k = 0; k < getKitchenInventory().size(); k++) {
            if (getKitchenInventory().get(k).equals(i)) {
                inventoryAmount = getKitchenInventory().get(k).getQuantity();
                difference = i.getQuantity() - inventoryAmount;
                inKitchen = getKitchenInventory().get(k);

                if (difference < 0) {
                    // if there is more in the kitchen, then in the grocerylist
                    getKitchenInventory().get(k).removeQuantity(i.getQuantity());
                } else if (difference >= 0) {
                    // if more is needed than in the inventory
                    // set the quantity amount needed in i, and then remove it from the kitchen inventory
                    removeFromKitchen(k);
                    i.removeQuantity(inKitchen.getQuantity());

                }
                }

        }
        return difference;
    }

    public static void main(String[] args) throws QuantityException{
        GroceryInventory gl = new GroceryInventory();
        System.out.println("1");
        KitchenInventory k = new KitchenInventory();
        KitchenInventory k3 = new KitchenInventory();
        gl.clearInventory();
        System.out.println("2");
        k.clearInventory();

        Ingredient i = new Ingredient("carrot", GroceryCategory.PRODUCE, 3, Measurement.NONE);
        Ingredient k2 = new Ingredient("mango", GroceryCategory.PRODUCE, 3, Measurement.NONE);
        System.out.println("3");
        k.add(i);
        System.out.println(k.toString());
        k3.add(k2);
        //gl.add(i);
        System.out.println(k3.toString());

    }


    @Override
    public String toString() {
        String res = "";
        int index = 1;

        for (Ingredient i: inventory) {
            res += index + ". " + i.getName() + ": " + (int) i.getQuantity() + "\n";
            index++;
        }
        return res;
    }



}
