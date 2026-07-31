package com.minesweeper;

import com.minesweeper.model.Board;
import com.minesweeper.service.Initialize;
import com.minesweeper.service.Logic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalTest {

    public static void main(String[] args){

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("height, width, bomb number:");
            int height, width, bombNumber;
            height = scanner.nextInt();
            width = scanner.nextInt();
            bombNumber = scanner.nextInt();

            Initialize initialize = new Initialize();

            Board board = initialize.createBoard(height, width, bombNumber);
            System.out.print("Move " + board.getMove() + ": ");

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            initialize.firstClick(x, y, board);
            int move = 2;
            while (!board.isBomb(x, y)) {
                displayBoard(board);
                System.out.print("Move " + move + ": ");
                x = scanner.nextInt();
                y = scanner.nextInt();
                Logic.choose(x, y, board);
                move++;

            }
        } catch (InputMismatchException e) {
            System.out.println("you must type again");
        }

    }

    public static void displayBoard(Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (!board.isOpened(i, j)) {
                    System.out.print("xx ");
                } else if (board.isBomb(i, j)) {
                    System.out.print("-1 ");
                } else {
                    System.out.print("0" + board.getValue(i, j) + " ");
                }
            }
            System.out.println();
        }
    }
}
