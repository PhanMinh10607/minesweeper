package com.minesweeper.service;

import com.minesweeper.Utility;
import com.minesweeper.exceptions.InvalidBombNumber;
import com.minesweeper.model.Board;

import java.util.*;

public class Initialize {
    private Random random = new Random();

    public void firstClick(int initialX, int initialY, Board board){
        Queue<int[]> bombPlace = new ArrayDeque<>();
        for (int i = 0; i < board.getBombNumber(); i++){
            int x = random.nextInt(board.getHeight());
            int y = random.nextInt(board.getWidth());
            while ((x == initialX && y == initialY) ||
                    board.isBomb(x,y)){
                x = random.nextInt(board.getHeight());
                y = random.nextInt(board.getWidth());
            }
            board.setBomb(x,y);
            bombPlace.offer(new int[]{x,y});
        }


        // initialize board
        while (!bombPlace.isEmpty()){
            int[] cell = bombPlace.poll();
            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    int a = cell[0] + i;
                    int b = cell[1] + j;
                    if (!Utility.checkInBoard(a,b,board) || (i == 0 && j == 0) || board.isBomb(a,b)) continue;
                    board.increaseCellValue(a,b);
                }
            }
        }

        Logic.choose(initialX,initialY, board);
    }

}
