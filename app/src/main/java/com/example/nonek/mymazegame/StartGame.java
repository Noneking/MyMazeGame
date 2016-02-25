package com.example.nonek.mymazegame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StartGame extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent=getIntent();
        Bundle b=intent.getExtras();
        Maze maze= (Maze) b.get("MAZE");
        GameView gameView=new GameView(this, maze);

        setContentView(gameView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Player.play(3, this);
    }
}
