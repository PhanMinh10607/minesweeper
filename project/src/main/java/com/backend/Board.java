package com.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// 0 - 6 = safe
// -1 = bomb

public class Board {
    private int height = 10;
    private int width = 10;
    private int bombNumber = 20;
    private int[][] grid;
    private boolean[][] open;
    private int move;
    private Set<ArrayList<Integer>> bombCoordinate;

     public Board(int height, int width, int bombNumber){
        this.height = height;
        this.width = width;
        this.bombNumber = bombNumber;
        this.grid = new int[height][width];
    }

    public void setXY(int x, int y, int value){
        grid[x][y] = value;
    }
    public void addBombCoordinate(int x, int y){
        grid[x][y] = -2;
        bombCoordinate.add(new ArrayList<>(List.of(x,y)));
    }
    public void setOpen(int x, int y, boolean value){
        open[x][y] = value;
    }

    public void resetMove(){move = 0;}
    public void increaseMove(){move++;}

    //getters

    public boolean getOpen(int x, int y){return open[x][y];}
    public int getCoordinate(int x, int y){return grid[x][y];}
    public Set<ArrayList<Integer>> getBombCoordinate(){return bombCoordinate;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int getBombNumber(){return bombNumber;}
}
