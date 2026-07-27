package com.exceptions;

public class InvalidMove extends RuntimeException {
    public InvalidMove() {
        System.err.println("Invalid move");
    }
}
