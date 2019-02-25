package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainUI extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
        window = primaryStage;
        window.setTitle("FoodTracker");
        window.setScene(new Scene(root, 722, 511));
        window.show();
    }

}
