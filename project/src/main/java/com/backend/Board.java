package com.backend;

import java.util.*;

// 0 - 6 = safe
// -1 = bomb

public class Board {
    private int height = 10;
    private int width = 10;
    private int bombNumber = 20;
    private int[][] board;
    private boolean[][] open;
    private int move;
    private int openedCellNumber;
    private Queue<int[]> bombCoordinate = new ArrayDeque<>();

     public Board(int height, int width, int bombNumber){
        this.height = height;
        this.width = width;
        this.bombNumber = bombNumber;
        this.board = new int[height][width];
        this.open = new boolean[height][width];
    }

    public void createCell(int x, int y){
        board[x][y] = 0;
    }
    public void addBombCoordinate(int x, int y){
        board[x][y] = -1;
        bombCoordinate.add(new int[]{x,y});
    }

    public void setOpen(int x, int y, boolean value){
        open[x][y] = value;
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
         board[x][y]++;
    }

    //getters

    public boolean checkOpen(int x, int y){return open[x][y];}
    public int getCoordinate(int x, int y){return board[x][y];}
    public Queue<int[]> getBombCoordinate(){return bombCoordinate;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int getBombNumber(){return bombNumber;}
    public int getOpenedCellNumber(){return openedCellNumber;}
}
