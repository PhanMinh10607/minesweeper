package com.model;

import java.util.*;

// 0 - 6 = safe
// -1 = bomb

public class Board {
    private int height = 10;
    private int width = 10;
    private int bombNumber = 20;
    private Cell[][] board;
    private int move;
    private int openedCellNumber;
    private Queue<int[]> bombCoordinate = new ArrayDeque<>();

     public Board(int height, int width, int bombNumber){
        this.height = height;
        this.width = width;
        this.bombNumber = bombNumber;
        this.board = new Cell[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                board[i][j] = new Cell();
            }
        }
        resetMove();
        resetOpenedCell();
    }
    public void setBomb(int x, int y){
        board[x][y].setValue(-1);
    }

    public void setOpen(int x, int y, boolean value){
        board[x][y].setOpened(value);
    }

    public void resetMove(){move = 0;}
    public void increaseMove(){move++;}
    public void resetOpenedCell(){
         openedCellNumber = 0;
    }
    public void increaseOpenedCell(){
         openedCellNumber++;
    }
    public void increaseCellValue(int x, int y){
         board[x][y].setValue(board[x][y].getValue()+1);
    }

    public boolean isBomb(int x, int y){
         return board[x][y].getValue() == -1;
    }
    public boolean checkOpen(int x, int y){return board[x][y].getOpened();}
    //getters

    public int getMove(){return move;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int getBombNumber(){return bombNumber;}
    public int getOpenedCellNumber(){return openedCellNumber;}
    public int getValue(int x, int y){return board[x][y].getValue();}
}
