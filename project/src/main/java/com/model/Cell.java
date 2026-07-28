package com.model;

public class Cell {
    private int value;
    private boolean opened;
    private boolean flagged;

    public Cell(){
        value = 0;
        opened = false;
        flagged = false;
    }

    //setters
    public void setValue(int value){this.value = value;}
    public void setOpened(boolean opened){this.opened = opened;}
    public void setFlagged(boolean flagged){this.flagged = flagged;}

    //getters
    public int getValue(){return value;}
    public boolean isOpened(){return opened;}
    public boolean isFlagged(){return flagged;}
}
