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

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public void initialize(URL url, ResourceBundle rb) {
        for (Ingredient i: AddIngredientController.gl.getInventory()) {
            checklistView.getItems().add(i.getQuantity() + " " + i.getName());
        }
    }

    @FXML
    private Button addRecipe;

    @FXML
    private ListView checklistView;

    @FXML
    private Button currentInventory;

    @FXML
    private Button addIngredient;

    @FXML
    private Button checklist;

    @FXML
    private Button recipeIndex;

    @FXML
    private Pane body;

    @FXML
    void goToIndex(ActionEvent event) {

    }

    @FXML
    void fffffa(ActionEvent event) {

    }

    @FXML
    void addingIngredient(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("addIngredient.fxml"));
        Scene scene = new Scene(root);
        // Get the stage info, cast as a stage
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        //window.show();

    }


    @FXML
    void addingRecipe(ActionEvent event) {

    }


    @FXML
    void goToInventory(ActionEvent event) {

    }


    @FXML
    void goToChecklist(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
        Scene scene = new Scene(root);
        // Get the stage info, cast as a stage
        Stage window = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }

}