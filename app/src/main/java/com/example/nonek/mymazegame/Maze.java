package com.example.nonek.mymazegame;

/**
 * Created by nonek on 18/02/2016.
 */
public class Maze {

    private final int UP=0, DOWN=1, RIGHT=2, LEFT=3;//Each number represent a direction

    private boolean[][] verticalLines;
    private boolean[][] horizontalLines;
    private int sizeX, sizeY;         //stores the width and height of the maze
    private int currentX, currentY;   //stores the current location of the ball
    private int finalX, finalY;       //stores the finishing of the maze

    private boolean gameFinished=false;

    public boolean canMove(int direction){
        boolean movement=false;
        switch(direction){
            case UP:
                if(currentY!=0 && !horizontalLines[currentY-1][currentX]){
                    currentY--;
                    movement=true;
                }
                break;
            case DOWN:
                if(currentY!=sizeY-1 && !horizontalLines[currentY][currentX]){
                    currentY++;
                    movement=true;
                }
                break;
            case RIGHT:
                if(currentX!=sizeX-1 && verticalLines[currentY][currentX]){
                    currentX++;
                    movement=true;
                }
                break;
            case LEFT:
                if(currentX!=0 && verticalLines[currentY][currentX-1]){
                    currentX--;
                    movement=true;
                }
                break;
        }

        if(currentY==finalY && currentX==finalX){
            gameFinished=true;
        }

        return movement;
    }

    public void setStartPosition(int x, int y) {
        currentX = x;
        currentY = y;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public boolean[][] getVerticalLines() {
        return verticalLines;
    }

    public boolean[][] getHorizontalLines() {
        return horizontalLines;
    }

    public void setHorizontalLines(boolean[][] lines) {
        horizontalLines = lines;
        sizeX = horizontalLines[0].length;
    }

    public void setVerticalLines(boolean[][] lines) {
        verticalLines = lines;
        sizeY = verticalLines.length;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public void setFinalPosition(int x, int y) {
        finalX = x;
        finalY = y;
    }

    public boolean isGameComplete() {
        return gameFinished;
    }

}
