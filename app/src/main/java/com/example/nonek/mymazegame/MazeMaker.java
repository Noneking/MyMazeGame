package com.example.nonek.mymazegame;

import android.util.Log;

/**
 * Created by nonek on 18/02/2016.
 */
public class MazeMaker {

    public static Maze getMaze(int mazeNum){
        Maze maze=null;
        switch(mazeNum){
            case 1:
                maze = new Maze();
                boolean[][] vLines = new boolean[][]{
                        {false ,false,true,false,false ,false,true},
                        {false ,true,false,true,true ,false,false},
                        {true ,true,true,false,true ,false,true},
                        {false ,false,true,false,true ,true,true},
                        {true ,true,true,true,true ,true,false},
                        {false ,true,false,true,false ,false,false},
                        {true ,false,false,true,true ,false,false},
                        {false ,false,false,false,false ,true,false},
                };
                boolean[][] hLines = new boolean[][]{
                        {true ,false,true,false,true ,false,true,false},
                        {false ,false,false,true,false ,false,true,false},
                        {false ,true,false,true,false ,false,false,true},
                        {false ,false,false,false,true ,false,false,false},
                        {true ,false,false,false,false ,true,true,false},
                        {false ,true,true,true,false ,true,true,true},
                        {false ,true,true,false,true ,false,true,false}
                };
                maze.setVerticalLines(vLines);
                maze.setHorizontalLines(hLines);
                maze.setStartPosition(3, 2);
                maze.setFinalPosition(6, 7);

                break;
            case 2:
                maze = new Maze();
                boolean[][] vLines2 = new boolean[][]{
                        {true ,false,false,false,true ,false,false},
                        {true ,false,false,true ,false,true ,true },
                        {false,true ,false,false,true ,false,false},
                        {false,true ,true ,false,false,false,true },
                        {true ,false,false,false,true ,true ,false},
                        {false,true ,false,false,true ,false,false},
                        {false,true ,true ,true ,true ,true ,false},
                        {false,false,false,true ,false,false,false}
                };
                boolean[][] hLines2 = new boolean[][]{
                        {false,false,true ,true ,false,false,true ,false},
                        {false,false,true ,true ,false,true ,false,false},
                        {true ,true ,false,true ,true ,false,true ,true },
                        {false,false,true ,false,true ,true ,false,false},
                        {false,true ,true ,true ,true ,false,true ,true },
                        {true ,false,false,true ,false,false,true ,false},
                        {false,true ,false,false,false,true ,false,true }
                };
                maze.setVerticalLines(vLines2);
                maze.setHorizontalLines(hLines2);
                maze.setStartPosition(0, 0);
                maze.setFinalPosition(7, 7);
                break;
            case 3:
                maze = new Maze();
                boolean[][] vLines3 = new boolean[][]{
                        {false,false,true,false,false,false,false,false,false,false,false,false},
                        {true,false,false,true,false,false,false,true,false,false,false,true},
                        {false,true,false,true,true,true,false,true,true,true,true,true},
                        {true,false,true,false,false,false,true,true,false,false,true,true},
                        {true,false,false,true,true,true,true,false,true,true,true,false},
                        {false,false,false,false,true,true,false,false,false,true,false,false},
                        {false,false,false,false,false,false,true,true,false,false,false,false},
                        {false,false,true,true,true,false,true,true,true,true,true,false},
                        {true,false,true,true,false,true,true,false,false,true,false,true},
                        {false,true,false,true,true,false,false,false,true,false,false,true},
                        {true,false,true,false,false,false,false,false,true,true,false,true},
                        {false,false,true,false,true,false,true,false,false,true,true,false},
                        {false,true,false,false,false,true,false,true,false,true,false,false}
                };
                boolean[][] hLines3 = new boolean[][]{
                        {false ,true,true,false,true,true,true,true,true,true,true,true,false},
                        {false ,false,false,true,false,true,true,false,false,false,true,true,false},
                        {true ,false,true,true,false,false,true,false,false,true,false,false,false},
                        {false ,false,true,false,true,true,false,false,true,true,false,false,false},
                        {false ,false,true,true,false,false,false,true,true,false,false,true,true},
                        {true ,true,true,false,true,false,true,false,true,true,false,false,true},
                        {true ,true,true,false,true,false,true,false,false,true,false,false,true},
                        {false ,true,false,false,false,true,false,false,true,false,false,true,false},
                        {false ,true,true,false,false,true,false,true,true,true,true,false,false},
                        {false ,false,true,false,false,true,true,true,false,false,true,false,false},
                        {false ,true,true,true,false,true,true,false,true,false,true,true,false},
                        {false ,true,false,true,true,false,false,false,true,false,false,true,false}
                };
                maze.setVerticalLines(vLines3);
                maze.setHorizontalLines(hLines3);
                maze.setStartPosition(0, 6);
                maze.setFinalPosition(12, 6);
                break;
        }
        return maze;
    }

}
