package com.minesweeper.exceptions;

public class InvalidBombNumber extends RuntimeException {
    public InvalidBombNumber() {
        System.err.println("Invalid bomb number");
    }
}
