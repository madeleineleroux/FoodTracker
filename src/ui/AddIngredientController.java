package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ingredients.GroceryCategory;
import model.ingredients.Ingredient;
import model.ingredients.Measurement;
import model.inventories.GroceryInventory;

import java.io.Serializable;
import java.util.ArrayList;

public class AddIngredientController implements Serializable {

    private GroceryCategory category;
    public static GroceryInventory gl = new GroceryInventory();
    private double quantity;
    private String name;

    @FXML
    private Button addRecipe;

    @FXML
    private Button currentInventory;

    @FXML
    private Button recipeIndex;

    @FXML
    private Button checklist;

    @FXML
    private Button addToGroceryList;

    @FXML
    private Button BAKING;

    @FXML
    private TextField input;


    @FXML
    private Button PANTRY;

    @FXML
    private Button PROTEIN;

    @FXML
    private Slider QUANTITY;

    @FXML
    private Button PRODUCE;


    @FXML
    private Button DAIRY;

    private Button[] buttons = {DAIRY, PANTRY, PROTEIN, PRODUCE, BAKING};

    @FXML
    void goToIndex(ActionEvent event) {

    }

    @FXML
    void addingRecipe(ActionEvent event) {

    }


    @FXML
    void goToInventory(ActionEvent event) {

    }

    @FXML
    void goToChecklist(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
        Scene scene = new Scene(root);
        // Get the stage info, cast as a stage
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    @FXML
    void setQuantity() {
        this.quantity = QUANTITY.getValue();
        System.out.println(QUANTITY.getValue());

    }

    @FXML
    void addDairy(ActionEvent event) {
        this.category = GroceryCategory.DAIRY;
    }

    @FXML
    void addProtein(ActionEvent event) {
        this.category = GroceryCategory.PROTEIN;
    }

    @FXML
    void addProduce(ActionEvent event) {
        this.category = GroceryCategory.PRODUCE;
    }

    @FXML
    void addBaking(ActionEvent event) {
        this.category = GroceryCategory.PANTRY_BAKING;
    }

    @FXML
    void addPantry(ActionEvent event) {
        this.category = GroceryCategory.DRIED_GOODS;
    }


    @FXML
    void addToList(ActionEvent event) throws Exception {
        this.name = input.getText();
        Ingredient i = new Ingredient(name, category, quantity, Measurement.NONE);
        gl.add(i);
        //System.out.println(gl.toString());
    }

    public ArrayList<Ingredient> getChecklist() {
        return gl.getInventory();
    }
}
