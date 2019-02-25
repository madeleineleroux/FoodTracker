package model.ingredients;

import java.io.Serializable;

public enum Measurement implements Serializable {
    NONE(""),
    TBSP("tbsp"),
    TSP("tsp"),
    CUP("cup");

    private String description;

    // EFFECTS: sets description of Measurement
    Measurement (String description) {
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
