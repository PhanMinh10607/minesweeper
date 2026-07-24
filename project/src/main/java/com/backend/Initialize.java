package com.backend;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Initialize {
    private Random random = new Random();

    public Board createGrid(int height, int width, int bombNumber){
        Board board = new Board(height, width, bombNumber);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board.setXY(i, j, 0);
                board.setOpen(i, j, false);
            }
        }
        board.resetMove();
        //TODO: Notify to frontend
        return board;
    }

    public void firstClick(int initialX, int initialY, Board board){
        for (int i = 0; i < board.getBombNumber(); i++){
            int x = random.nextInt(board.getHeight());
            int y = random.nextInt(board.getWidth());
            while ((x == initialX && y == initialY) ||
                    board.getBombCoordinate().contains(new ArrayList<>(List.of(x,y)))){
                x = random.nextInt(board.getHeight());
                y = random.nextInt(board.getWidth());
            }
            board.addBombCoordinate(x,y);
        }
        Logic.choose(initialX,initialY, board);
    }

}
