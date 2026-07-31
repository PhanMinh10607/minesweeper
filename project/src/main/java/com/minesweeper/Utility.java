package com.minesweeper;

import com.minesweeper.model.Board;

public class Utility {
    public static boolean checkInBoard(int x, int y, Board board){
        return x >= 0 &&
                x < board.getHeight() &&
                y >= 0 &&
                y < board.getWidth();
    }
}
