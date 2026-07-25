package com.backend;

import com.Utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Logic {

    public static void choose(int x, int y, Board board){
        if (!Utility.checkInBoard(x,y,board) ||
                board.checkOpen(x,y)){
            invalidMoveHandle();
        }
        if (board.getHeight() * board.getWidth() - board.getBombNumber() == board.getOpenedCellNumber()){
            winHandle();
        }
        if (board.getCoordinate(x,y) != -1){
            safeClicked(x,y,board);
        }
        else{
            bombClicked();
        }
    }

    public static void invalidMoveHandle(){
        System.out.println("Invalid move");
    }

    public static void winHandle(){
        System.out.println("You won!!!");
    }

    public static void bombClicked(){
        System.out.println("You lost");
        //TODO: handle bomb clicked
    }

    public static void safeClicked(int x, int y, Board board){
        board.increaseMove();

        // travel and open adjacent cells
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        while (!q.isEmpty()){
            int[] cell = q.poll();
            board.setOpen(cell[0],cell[1],true);
            board.increaseOpenedCell();
            for (int i = -1; i <= 1; i++){
                for (int j = -1; j < 1; j++){
                    int a = cell[0]+i;
                    int b = cell[1]+j;
                    if (!Utility.checkInBoard(a,b,board) ||
                            board.checkOpen(a,b) ||
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
