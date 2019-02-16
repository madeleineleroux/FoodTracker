package ui;

import model.GroceryList;
import model.exceptions.InvalidTypeException;
import model.ingredients.*;

import java.util.Scanner;

public class ListMaker {
    GroceryList gl;
    public ListMaker() {
        gl = new GroceryList();
    }

    //EFFECTS: reads a line fo text from standard input and returns it
    public String userResponse() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    // EFFECTS: creates an Ingredient instance with the user entered information
    public Ingredient getIngredient() throws InvalidTypeException {
        String input;
        Ingredient i;
        String[] ingredientParts;

        System.out.println("Please enter your item like so: item type quantity");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        ingredientParts = parseInput(input);
        i = makeIngredient(ingredientParts);

        if (i == null) {
            throw new InvalidTypeException("Sorry. That isn't a valid food type.");
        }
        return i;
    }

    //REQUIRES: input must not be null, and must be input as "item type quantity"
    //EFFECTS: parses input to make ingredient.
    public String[] parseInput(String input) {
        String[] ingredientParts = input.split(" ");
        for (int j = 0; j < ingredientParts.length; j++) {
            ingredientParts[j] = ingredientParts[j].trim();
        }
        return ingredientParts;
    }


    //REQUIRES: ingredientParts[1] is one of "protein", "dairy", "produce", or "pantry
    //EFFECTS: make an ingredient from information from ingredientParts
    public Ingredient makeIngredient(String[] ingredientParts) throws InvalidTypeException, NumberFormatException {

        if (ingredientParts[2].matches("[a-zAz]*")) {
            throw new NumberFormatException("Please enter a valid number.");
        }

        String type = ingredientParts[1];
        int quantity = Integer.valueOf(ingredientParts[2]);
        String name = ingredientParts[0];

        if (type.equalsIgnoreCase("protein")) {
            return new Protein(name, quantity);
        } else if (type.equalsIgnoreCase("dairy")) {
            return new Dairy(name, quantity);
        } else if (type.equalsIgnoreCase("produce")) {
            return new Produce(name, quantity);
        } else if (type.equalsIgnoreCase("pantry")) {
            return new Pantry(name, quantity);
        } else {
            throw new InvalidTypeException("That's not a valid food type");
        }

    }


    //EFFECTS: prints out checklist choices
    public void menu() {
        System.out.println("Here's what's on your list: ");
        System.out.println(gl.toPrint());
        System.out.println("\ta: to add an item\n" +
                "\tr: to remove an item\n" +
                "\tc: to check off on item\n" +
                "\tq: to quit\n" +
                "\td: to delete the list\n");
    }

    //TODO: refactor so manual input is possible
    //MODIFIES: gl
    //EFFECTS: removes item from gl at given checklist index
    public void removeFromChecklist() {
        if (gl.getItems().isEmpty()) {
            System.out.println("There's nothing to remove.");
        } else {
            System.out.println("What item number would you like to remove?");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            try{
                gl.removeItem(input - 1);
                System.out.println("Item has been removed.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("That's not a valid number index.");
                removeFromChecklist();
            }
        }

    }

    //TODO: refactor so manual input is possible
    //REQUIRES: the given index to be valid
    //MODIFIES: gl and ingredient at given index
    public void checkOff() {
        if (gl.getItems().isEmpty()) {
            System.out.println("There's nothing to checkoff!");
        } else {
            System.out.println("What have you purchased?");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            input--;

            if (input < 0 || input >= gl.getItems().size()) {
                System.out.println("That's not a valid index.");
                checkOff();
            }
            Ingredient itemToPurchase = gl.getItems().get(input);
            itemToPurchase.purchase();
            gl.removeItem(input);

            System.out.println("Item has been purchased.");
        }
    }

    //TODO: refactor so manual input is possible
    //REQUIRES: Y or N as the entry
    //MODIFIES: checklist and grocery list
    //EFFECTS: empties grocery list without purchasing items
    public void deleteGroceryList() {
        System.out.println("Are you sure?. Y/N?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            gl.clearList();
            System.out.println("List erased.");
        } else {
            System.out.println("List not erased");
        }
    }

    //EFFECTS: Launches the action as decided by the user
    public void chooseAction(String input) {
        if (input.equalsIgnoreCase("a")) {
            try {
                gl.addToList(getIngredient());
            } catch (InvalidTypeException invalidType) {
                System.out.println("Sorry. That wasn't a valid food type. Try again.");
            } catch (NumberFormatException invalidType) {
                System.out.println("You didn't enter a valid number.");
            }

        } else if (input.equalsIgnoreCase("r")) {
            removeFromChecklist();
        } else if (input.equalsIgnoreCase("c")) {
            checkOff();
        } else if (input.equalsIgnoreCase("d")) {
           deleteGroceryList();
        }
    }

    public void launchChecklist() throws InvalidTypeException {
        String input;
        System.out.println("Welcome!\n");
        menu();
        input = userResponse();
        chooseAction(input);

        while (!input.equalsIgnoreCase("q")) {
            menu();
            input = userResponse();
            chooseAction(input);
        }
    }


    public static void main(String[] args) throws InvalidTypeException {
        ListMaker listmaker = new ListMaker();
        listmaker.launchChecklist();


    }
        }
