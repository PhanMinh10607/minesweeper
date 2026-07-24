package com.backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Logic {

    public static void choose(int x, int y, Board board){
        if (x < 0 || x >= board.getHeight() || y < 0 || y >= board.getWidth() || board.getOpen(x,y)){return;}
        if (board.getCoordinate(x,y) != -1){
            board.increaseMove();

            // travel and open adjacent cells
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{x,y});
            while (!q.isEmpty()){
                int[] cell = q.poll();
                board.setOpen(cell[0],cell[1],true);
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j < 1; j++){
                        int a = x+i;
                        int b = y+j;
                        if (a < 0 ||
                                a >= board.getHeight() ||
                                b < 0 ||
                                b >= board.getWidth() ||
                                board.getOpen(a,b) ||
                                board.getCoordinate(a,b) == -1){
                            continue;
                        }
                        q.offer(new int[]{a,b});
                    }
                }
            }
            //TODO: notify to frontend
        }
    }
    public static void bombClicked(){
        System.out.println("You lost");
        //TODO: handle bomb clicked
    }
}
