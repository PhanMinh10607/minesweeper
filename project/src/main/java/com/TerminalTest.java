package com;

import com.backend.Board;
import com.backend.Initialize;
import com.backend.Logic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class TerminalTest {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int height, width, bombNumber;
        height = scanner.nextInt();
        width = scanner.nextInt();
        bombNumber = scanner.nextInt();

        Initialize initialize = new Initialize();

        Board board = initialize.createBoard(height, width, bombNumber);
        System.out.print("Move 1: ");

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        initialize.firstClick(x, y, board);
        int move = 2;
        while (board.getCoordinate(x,y) != -1 ){
            displayBoard(board);
            System.out.print("Move " + move + ": ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            Logic.choose(x,y,board);
            move++;

        }
    }

    public static void displayBoard(Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (!board.checkOpen(i, j)) {
                    System.out.print("xx ");
                } else if (board.getCoordinate(i, j) == -1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print("0" + board.getCoordinate(i, j) + " ");
                }
            }
            System.out.println();
        }
    }
}
