package com;

import com.backend.Board;

public class Utility {
    public static boolean checkInBoard(int x, int y, Board board){
        if (x < 0 ||
                x >= board.getHeight() ||
                y < 0 ||
                y >= board.getWidth()){
            return false;
        }
        return true;
    }
}
