package model.ingredients;

import java.io.Serializable;

public enum GroceryCategory implements Serializable {
    PRODUCE("PRODUCE"),
    PROTEIN("PROTEIN"),
    DAIRY("DAIRY"),
    PANTRY_BAKING("PANTRY"),
    DRIED_GOODS("DRIED GOODS");

    private String description;

    // EFFECTS: sets description of GroceryCategory
    GroceryCategory(String description) {
        this.description = description;
    }

    // EFFECTS: returns description of GroceryCategory
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns description of GroceryCategory
    @Override
    public String toString() {
        return description;
    }
}