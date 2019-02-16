package model.ingredients;

public enum GroceryType {
    PRODUCE("PRODUCE"),
    PROTEIN("PROTEIN"),
    DAIRY("DAIRY"),
    PANTRY_BAKING("PANTRY"),
    DRIED_GOODS("DRIED GOODS");

    private String description;

    // EFFECTS: sets description of Status
    GroceryType(String description) {
        this.description = description;
    }

    // EFFECTS: returns description of Status
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns description of Status
    @Override
    public String toString() {
        return description;
    }
}