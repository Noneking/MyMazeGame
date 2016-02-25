package com.example.nonek.mymazegame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by nonek on 21/02/2016.
 */
public class GameView extends View implements View.OnTouchListener {

    private int width, height, lineWidth;
    private int mazeSizeX, mazeSizeY;
    float cellWidth, cellHeight;
    float totalCellWidth, totalCellHeight;
    private int mazeFinishX, mazeFinishY;
    private Maze maze;
    private Activity context;
    private Paint line, ball, background;
    private int AnchoPantalla;
    private int AltoPantalla;

    public GameView(Context context, Maze maze){
        super(context);

        this.context= (Activity) context;
        this.maze = maze;
        mazeFinishX = maze.getFinalX();
        mazeFinishY = maze.getFinalY();
        mazeSizeX = maze.getMazeWidth();
        mazeSizeY = maze.getMazeHeight();
        line = new Paint();
        line.setColor(getResources().getColor(R.color.game_line));
        ball = new Paint();
        ball.setColor(getResources().getColor(R.color.game_ball));
        background = new Paint();
        background.setColor(getResources().getColor(R.color.game_background));
//        setFocusable(true);
//        this.setFocusableInTouchMode(true);
        this.setOnTouchListener(this);

        Player.play(3, context);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = (w < h)?w:h;
        height = width;
        lineWidth = 1;
        cellWidth = (width - ((float)mazeSizeX*lineWidth)) / mazeSizeX;
        totalCellWidth = cellWidth+lineWidth;
        cellHeight = (height - ((float)mazeSizeY*lineWidth)) / mazeSizeY;
        totalCellHeight = cellHeight+lineWidth;
        ball.setTextSize(cellHeight * 0.75f);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    protected void onDraw(Canvas canvas) {
        //fill in the background
        canvas.drawRect(0, 0, width, height, background);

        boolean[][] hLines = maze.getHorizontalLines();
        boolean[][] vLines = maze.getVerticalLines();
        //iterate over the boolean arrays to draw walls
        for(int i = 0; i < mazeSizeX; i++) {
            for(int j = 0; j < mazeSizeY; j++){
                float x = j * totalCellWidth;
                float y = i * totalCellHeight;
                if(j < mazeSizeX - 1 && vLines[i][j]) {
                    //we'll draw a vertical line
                    canvas.drawLine(x + cellWidth,   //start X
                            y,               //start Y
                            x + cellWidth,   //stop X
                            y + cellHeight,  //stop Y
                            line);
                }
                if(i < mazeSizeY - 1 && hLines[i][j]) {
                    //we'll draw a horizontal line
                    canvas.drawLine(x,               //startX
                            y + cellHeight,  //startY
                            x + cellWidth,   //stopX
                            y + cellHeight,  //stopY
                            line);
                }
            }
        }
        int currentX = maze.getCurrentX(),currentY = maze.getCurrentY();
        //draw the ball
        canvas.drawCircle((currentX * totalCellWidth) + (cellWidth / 2),   //x of center
                (currentY * totalCellHeight) + (cellWidth / 2),  //y of center
                (cellWidth * 0.45f),                           //radius
                ball);
        //draw the finishing point indicator
        canvas.drawText("F",
                (mazeFinishX * totalCellWidth) + (cellWidth * 0.25f),
                (mazeFinishY * totalCellHeight) + (cellHeight * 0.75f),
                ball);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            boolean moved=false;
            CalculaTamañoPantalla();
            int x= (int) MotionEventCompat.getX(event, 0);
            int y= (int) MotionEventCompat.getY(event, 0);

            Log.i("POSITION","X="+x+"Y="+y);

            //Y
            if(y<(AnchoPantalla*0.2)){
                if(x>(AltoPantalla*0.2) && x<AltoPantalla*0.8){//GOOD
                    moved=maze.canMove(Maze.UP);
                    Log.i("MOVEMENT","UP");
                }
            } else if(y>(AnchoPantalla*0.8)){
                if(x>(AltoPantalla*0.2) && x<AltoPantalla*0.8){//GOOD
                    moved=maze.canMove(Maze.DOWN);
                    Log.i("MOVEMENT","DOWN");
                }
            }else if(x<(AltoPantalla*0.2)){
                if(y>(AnchoPantalla*0.2) && y<AnchoPantalla*0.8){//GOOD
                    moved=maze.canMove(Maze.LEFT);
                    Log.i("MOVEMENT","LEFT");
                }
            } else{
                moved=maze.canMove(Maze.RIGHT);
                Log.i("MOVEMENT","RIGHT");
            }

            if(moved) {
                //the ball was moved so we'll redraw the view
                invalidate();
                if(maze.isGameComplete()) {
                    Player.play(4, context);
                    Intent intent=new Intent(getContext(), ListLevelsActivity.class);
                    getContext().startActivity(intent);
                }
            }else{
                MediaPlayer player;
                switch((int) (Math.random()*9+1)){
                    case 1:
                        player=MediaPlayer.create(context, R.raw.punch1);
                        player.start();
                        break;
                    case 2:
                        player=MediaPlayer.create(context, R.raw.punch2);
                        player.start();
                        break;
                    case 3:
                        player=MediaPlayer.create(context, R.raw.punch3);
                        player.start();
                        break;
                    case 4:
                        player=MediaPlayer.create(context, R.raw.punch4);
                        player.start();
                        break;
                    case 5:
                        player=MediaPlayer.create(context, R.raw.punch5);
                        player.start();
                        break;
                    case 6:
                        player=MediaPlayer.create(context, R.raw.punch6);
                        player.start();
                        break;
                    case 7:
                        player=MediaPlayer.create(context, R.raw.punch7);
                        player.start();
                        break;
                    case 8:
                        player=MediaPlayer.create(context, R.raw.punch8);
                        player.start();
                        break;
                    case 9:
                        player=MediaPlayer.create(context, R.raw.punch9);
                        player.start();
                        break;
                }
            }
        }
        return true;
    }

    public void CalculaTamañoPantalla(){
        if(Build.VERSION.SDK_INT > 13) {
            Display display = this.getDisplay();
            Point size = new Point();
            display.getSize(size);
            AnchoPantalla = size.x;
            AltoPantalla = size.y;
        }
        else{
            Display display = this.getDisplay();
            AnchoPantalla = display.getWidth();
            AltoPantalla = display.getHeight();
        }
    }
}
