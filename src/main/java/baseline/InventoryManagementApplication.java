/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jonathan O'Leary
 */
package baseline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class InventoryManagementApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GUIApp.fxml")));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Inventory List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {launch();}
}
