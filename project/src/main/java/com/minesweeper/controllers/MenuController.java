package com.minesweeper.controllers;

import com.minesweeper.model.Board;
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
        Board board = new Board(10,10,10);
        switchToGame(event, Level.EZ, board);
    }
    @FXML
    private void normalHandle(ActionEvent event) throws IOException {
        Board board = new Board(16,16,40);
        switchToGame(event, Level.NORMAL, board);
    }

    @FXML
    private void hardHandle(ActionEvent event) throws IOException {
        Board board = new Board(16,30,99);
        switchToGame(event, Level.HARD, board);
    }

    @FXML
    private void customHandle(ActionEvent event) throws IOException {
        //TODO: create user input session
        Board board = new Board(10,10,10);
        switchToGame(event, Level.CUSTOM, board);
    }

    private void switchToGame(ActionEvent event, Level level, Board board) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/minesweeper/game.fxml"));
        root = loader.load();
        GameController gameController = loader.getController();
        gameController.displayLevel(level);
        gameController.setBoard(board);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
