package model.ingredients;

import model.exceptions.QuantityException;

import java.time.LocalDate;

public class Ingredient {
    private double quantity;
    private GroceryCategory category;
    private Measurement measurement;
    private LocalDate purchaseDate;
    private int lifespan;
    // Days in lifespan
    private int DEFAULT_LIFESPAN = 5;
    private String name;
    private LocalDate expiryDate;
    private boolean purchased;

    // Stores purchase date, expiry date, category, quantity, and name

    public Ingredient(String name, GroceryCategory category, double quantity, Measurement measurement) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.measurement = measurement;
        this.purchased = false;
    }


    public boolean equals(Ingredient other) {
        return other.getClass() == this.getClass() && getName().equalsIgnoreCase(other.getName());
    }


    //MODIFIES: this
    //EFFECTS: sets Ingredient's purchase date today, and corresponding expiry date
    public void purchase() {
        purchased = true;
        purchaseDate = LocalDate.now();
        setExpiryDate(purchaseDate);
    }

    //MODIFIES: this
    //EFFECTS: sets Ingredient's purchase date today, and corresponding expiry date
    public void purchase(LocalDate date) {
        purchased = true;
        setPurchaseDate(date);
        setExpiryDate(purchaseDate);
    }

    //MODIFIES: this
    //EFFECTS: sets Ingredient's expiry date
    public void setExpiryDate(LocalDate date) {
        expiryDate = date.plusDays(DEFAULT_LIFESPAN);
    }


    //MODIFIES: this
    //EFFECTS: sets Ingredient's purchase date
    public void setPurchaseDate(LocalDate date) {
        purchaseDate = date;
    }


    //REQUIRES: 0 >= amount <= current quantity
    //MODIFIES: this
    //EFFECTS: removes quantity amount from ingredient
    public void removeQuantity(int amount) throws QuantityException {
        if ((quantity -= amount) <= 0 || amount > getQuantity()) {
            throw new QuantityException("You can't remove that much.");
        }

        quantity -= amount;
    }

    //REQUIRES: amount >= 0
    //MODIFIES: this
    //EFFECTS: adds amount to quantity
    public void addToQuantity(int amount) throws QuantityException {
        if (amount < 0) {
            throw new QuantityException("Amount must be greater or equal to 0");
        }
        quantity += amount;
    }

    //EFFECTS: returns quantity
    public int getQuantity() {
        return quantity;
    }

    //EFFECTS: returns name
    public String getName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: sets name
    public void setName(String name) {
        this.name = name;
    }

    //REQUIRES: quantity >= 0
    //MODIFIES: this
    //EFFECTS: sets quantity
    public void setQuantity(int quantity) throws QuantityException {
        if (quantity < 0) {
            throw new QuantityException("Amount must be greater than or equal to 0.");
        }
        this.quantity = quantity;
    }


}
