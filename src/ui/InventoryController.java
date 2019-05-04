package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ingredients.Ingredient;
import model.inventories.KitchenInventory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    private static KitchenInventory ki = new KitchenInventory();

    //TODO: look up string formatting
    public void initialize(URL url, ResourceBundle rb) {
        for (Ingredient i: ki.getInventory()) {
            inventoryView.getItems().add(i.getName()+ ", " + i.getExpiryDate());
        }
    }

    @FXML
    private ListView inventoryView;

    @FXML
    private Button addIngredient;

    @FXML
    private Button checklist;

    @FXML
    private Pane body;


    @FXML
    void fffffa(ActionEvent event) {

    }

    @FXML
    void addingIngredient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addIngredient.fxml"));
        Scene scene = new Scene(root);
        // Get the stage info, cast as a stage
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }


    @FXML
    void goToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
        Scene scene = new Scene(root);
        // Get the stage info, cast as a stage
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }


    public void removeItem(ActionEvent actionEvent) {
        int toRemove = inventoryView.getSelectionModel().getSelectedIndex();
        ki.removeIngredient(toRemove);
        inventoryView.getItems().remove(toRemove);
    }
}
