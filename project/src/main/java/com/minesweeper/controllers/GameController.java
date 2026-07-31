package com.minesweeper.controllers;

import com.minesweeper.model.Level;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML

    private Label level;

    public void displayLevel(Level level){
        this.level.setText("Level: " + level);
    }
}
