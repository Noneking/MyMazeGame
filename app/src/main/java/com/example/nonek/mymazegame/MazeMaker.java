package com.example.nonek.mymazegame;

import android.util.Log;

/**
 * Created by nonek on 18/02/2016.
 */
public class MazeMaker {

    public static Maze getMaze(int mazeNum){
        Maze maze=null;
        Log.i("tab1","Entra dentro del metodo");
        switch(mazeNum){
            case 1:
                Log.i("tab2","Entra dentro del switch 1");
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
//        Maze maze = null;
//        if(mazeNum == 1) {
//            maze = new Maze();
//            boolean[][] vLines = new boolean[][]{
//                    {true ,false,false,false,true ,false,false},
//                    {true ,false,false,true ,false,true ,true },
//                    {false,true ,false,false,true ,false,false},
//                    {false,true ,true ,false,false,false,true },
//                    {true ,false,false,false,true ,true ,false},
//                    {false,true ,false,false,true ,false,false},
//                    {false,true ,true ,true ,true ,true ,false},
//                    {false,false,false,true ,false,false,false}
//            };
//            boolean[][] hLines = new boolean[][]{
//                    {false,false,true ,true ,false,false,true ,false},
//                    {false,false,true ,true ,false,true ,false,false},
//                    {true ,true ,false,true ,true ,false,true ,true },
//                    {false,false,true ,false,true ,true ,false,false},
//                    {false,true ,true ,true ,true ,false,true ,true },
//                    {true ,false,false,true ,false,false,true ,false},
//                    {false,true ,false,false,false,true ,false,true }
//            };
//            maze.setVerticalLines(vLines);
//            maze.setHorizontalLines(hLines);
//            maze.setStartPosition(0, 0);
//            maze.setFinalPosition(7, 7);
//        }
//
//        return maze;
    }

}
