package com.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// 0 - 6 = safe
// -1 = bomb

public class Grid {
    private static int height = 10;
    private static int width = 10;
    private static int[][] grid;
    private static boolean[][] open;
    private static Set<ArrayList<Integer>> bombCoordinate;
    private static Grid instance;


    private Grid(int height, int width){
        this.height = height;
        this.width = width;
        this.grid = new int[height][width];
    }

    public static void setXY(int x, int y, int value){
        grid[x][y] = value;
    }
    public static void addBombCoordinate(int x, int y){
        grid[x][y] = -2;
        bombCoordinate.add(new ArrayList<>(List.of(x,y)));
    }
    public static void setOpen(int x, int y, boolean value){
        open[x][y] = value;
    }

    //getters

    public static Grid getIntance(int height, int width){
        if (instance == null) {instance = new Grid(height, width);}
        return instance;
    }
    public static boolean getOpen(int x, int y){return open[x][y];}
    public static int getCoordinate(int x, int y){return grid[x][y];}
    public static Set<ArrayList<Integer>> getBombCoordinate(){return bombCoordinate;}
    public static int getHeight(){return height;}
    public static int getWidth(){return width;}
}
