package model.inventories;

import model.exceptions.QuantityException;
import model.ingredients.Ingredient;

import java.util.ArrayList;

public interface Storage {
    public ArrayList<Ingredient> inventory = new ArrayList<>();


    //EFFECTS: returns inventory
    public ArrayList<Ingredient> getInventory();

    //MODIFIES: this
    //EFFECTS: empties inventory
    public void clearInventory();

    //REQUIRES: ingredient must not be null
    //MODIFIES: this
    //EFFECTS: adds Ingredient to inventory, if already in inventory adds to the quantity
    public void add(Ingredient ingredient) throws QuantityException;

    //REQUIRES: input must not be null
    //MODIFIES: this
    //EFFECTS: remove the ingredient entry with the same name as input
    public void removeIngredient(String name);

    //REQUIRES: input must not be null
    //MODIFIES: this
    //EFFECTS: remove the ingredient entry with the same name as input
    public void removeIngredient(int index) ;

    //EFFECTS: prints a list of all items in inventory
    @Override
    public String toString();
}

