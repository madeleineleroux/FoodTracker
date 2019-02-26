package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.ingredients.Ingredient;
import model.inventories.KitchenInventory;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    private static KitchenInventory ki = new KitchenInventory();

    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(ki.toString());
        for (Ingredient i: ki.getInventory()) {
            inventoryView.getItems().add(i.getQuantity() + " " + i.getName()+ ", expires " );
        }
    }

    @FXML
    private Button addRecipe;

    @FXML
    private ListView inventoryView;

    @FXML
    private Button addIngredient;

    @FXML
    private Button checklist;

    @FXML
    private Button recipeIndex;

    @FXML
    private Pane body;

    @FXML
    void goToRecipeIndex(ActionEvent event) {

    }

    @FXML
    void fffffa(ActionEvent event) {

    }

    @FXML
    void addingIngredient(ActionEvent event) {

    }

    @FXML
    void goToAddRecipe(ActionEvent event) {

    }


    @FXML
    void goToMain(ActionEvent event) {

    }


}
