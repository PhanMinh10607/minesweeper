package com.minesweeper.controllers;

import com.minesweeper.model.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void ezHandle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/minesweeper/game.fxml"));
        root = loader.load();
        GameController gameController = loader.getController();
        gameController.displayLevel(Level.EZ);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void normalHandle(){}

    @FXML
    private void hardHandle(){}

    @FXML
    private void customHandle(){}

}
