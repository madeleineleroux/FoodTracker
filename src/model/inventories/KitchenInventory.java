package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class KitchenInventory extends Inventory implements Serializable {
    private static ArrayList<Ingredient> kInventory = new ArrayList<>();

    public KitchenInventory(){
        //super();
        this.FILENAME = "kitchen.ser";
        this.inventory = kInventory;

        try {
            ObjectInputStream is = new ObjectInputStream (new FileInputStream(FILENAME));
            this.inventory = (ArrayList<Ingredient>) ((ObjectInputStream) is).readObject();
            System.out.println("Making" + toString());
        } catch (Exception e) {
            System.out.println("There wasn't a file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws QuantityException {
        KitchenInventory k = new KitchenInventory();
        k.clearInventory();
        Ingredient i1 = new Ingredient("carrot", GroceryCategory.DAIRY, 3, Measurement.NONE);
        Ingredient i2 = new Ingredient("888", GroceryCategory.DAIRY, 3, Measurement.NONE);
        Ingredient i3 = new Ingredient("9999", GroceryCategory.DAIRY, 3, Measurement.NONE);
        k.add(i1);
        System.out.println(k.toString());
        KitchenInventory k2 = new KitchenInventory();
        System.out.println(k2.toString());
    }
}
