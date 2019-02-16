package model.recipes;

import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;

import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    private String title;
    private int servings;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> steps;

    public Recipe (String title) {
        this.title = title;
        steps = new ArrayList<>();
        ingredients = new ArrayList<>();

    }

    //EFFECTS: returns title
    public String getTitle() {
        return title;
    }

    //MODIFIES: this
    //EFFECTS: changes title name
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();


    }

    public void launchStepsGetter() {
        String input = "";

        while (!input.equals("q")) {
            System.out.println("What's the next step in the recipe? Press q to quit.");
            input = getUserInput();
            if (!input.equals("q")) {
                stepByStepInput(input);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: gets user to input recipe steps, step by step
    public void stepByStepInput(String input) {
        steps.add(input);
    }

    //MODIFIES: this
    //EFFECTS: sets the recipe steps
    public void setSteps() {}

    //MODIFIES: this
    //EFFECTS: sets servings
    public void setServings(int amount) {
        servings = amount;
    }

    //EFFECTS: returns amount of servings
    public int getServings() {
        return servings;
    }

    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }

    public void addIngredient(Ingredient i) {
        ingredients.add(i);
    }

    public String ingredientsToPrint() {
        String res = "";
        for (Ingredient i: ingredients) {
            res += i.getName() + ": " + i.getQuantity() + "\n";
        }
        return res;
    }

    public String stepsToPrint() {
        String res = "";
        int num = 1;
        for (String s: steps) {
            String step = num + ". " + s + "\n";
            num++;
            res += step;
        }
        return res;
    }

    public String recipeToPrint() {
        return getTitle() + "\n\n" + ingredientsToPrint() + "\n" + stepsToPrint();
    }


    public static void main(String[] args) {
        Recipe r = new Recipe("title");
        r.launchStepsGetter();
        r.addIngredient(new Ingredient("carrot", GroceryCategory.PRODUCE, 1, Measurement.NONE));
        System.out.println(r.ingredientsToPrint());
        System.out.println(r.stepsToPrint());
        System.out.println(r.recipeToPrint());
    }

}
