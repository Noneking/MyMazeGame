package com.example.nonek.mymazegame;

/**
 * Created by nonek on 18/02/2016.
 */
public class MazeMaker {

    private Maze maze;

    public Maze getMaze(int mazeNum){
        switch(mazeNum){
            case 1:
                maze = new Maze();
                boolean[][] vLines = new boolean[][]{
                        {true ,false,false,false,true ,false,false},
                        {true ,false,false,true ,false,true ,true },
                        {false,true ,false,false,true ,false,false},
                        {false,true ,true ,false,false,false,true },
                        {true ,false,false,false,true ,true ,false},
                        {false,true ,false,false,true ,false,false},
                        {false,true ,true ,true ,true ,true ,false},
                        {false,false,false,true ,false,false,false}
                };
                boolean[][] hLines = new boolean[][]{
                        {false,false,true ,true ,false,false,true ,false},
                        {false,false,true ,true ,false,true ,false,false},
                        {true ,true ,false,true ,true ,false,true ,true },
                        {false,false,true ,false,true ,true ,false,false},
                        {false,true ,true ,true ,true ,false,true ,true },
                        {true ,false,false,true ,false,false,true ,false},
                        {false,true ,false,false,false,true ,false,true }
                };
                maze.setVerticalLines(vLines);
                maze.setHorizontalLines(hLines);
                maze.setStartPosition(0, 0);
                maze.setFinalPosition(7, 7);
                break;
            case 2:

                break;
            case 3:

                break;
        }
        return maze;
    }

}
