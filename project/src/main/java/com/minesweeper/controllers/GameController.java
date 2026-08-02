package com.minesweeper.controllers;

import com.minesweeper.model.Board;
import com.minesweeper.model.Level;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {

    public GameController(){
        //TODO: Set fullscreen
    }

    @FXML
    private Label level;
    private Board board;

    public void displayLevel(Level level){
        this.level.setText("Level: " + level);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    @FXML
    public void initialize(){
        //TODO: CREATE BOARD
    }
}
