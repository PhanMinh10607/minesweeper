package com.backend;

import java.util.ArrayList;

public class Logic {

    public static void choose(int x, int y){
        if (x < 0 || x >= Grid.getHeight() || y < 0 || y >= Grid.getWidth() || Grid.getOpen(x,y)){return;}
        if (Grid.getCoordinate(x,y) != -1){
            Grid.setOpen(x,y,true);
            // TODO: notify to frontend
            //TODO: use bfs instead
            choose(x-1,y-1);
            choose(x-1,y);
            choose(x-1,y+1);
            choose(x,y-1);
            choose(x,y+1);
            choose(x+1,y-1);
            choose(x+1,y);
            choose(x+1,y+1);
        }
    }
    public static void bombClicked(){
        System.out.println("You lost");
        //TODO: handle bomb clicked
    }
}
