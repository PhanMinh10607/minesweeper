package com.backend;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Initialize {
    private int height;
    private int width;
    private int bombNumber;
    private Random random = new Random();

    Initialize(int height, int width, int bombNumber){
        this.height = height;
        this.width = width;
        this.bombNumber = bombNumber;
        Grid.getIntance(height, width);
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Grid.setXY(i,j,0);
                Grid.setOpen(i,j,false);
            }
        }
    }

    public void firstClick(int initialX, int initialY){
        for (int i = 0; i < bombNumber; i++){
            int x = random.nextInt(height);
            int y = random.nextInt(width);
            while ((x == initialX && y == initialY) ||
                    Grid.getBombCoordinate().contains(new ArrayList<>(List.of(x,y)))){
                x = random.nextInt(height);
                y = random.nextInt(width);
            }
            Grid.addBombCoordinate(x,y);
        }
        Logic.choose(initialX,initialY);
    }

    // getters
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int getBombNumber() {return bombNumber;}
}
