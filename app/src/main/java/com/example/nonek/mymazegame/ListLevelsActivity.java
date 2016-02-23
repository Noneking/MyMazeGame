package com.example.nonek.mymazegame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ListLevelsActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, Button.OnClickListener {

    MediaPlayer player;
    Window window;

    Button level01, level02, level03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_levels);
        getSupportActionBar().hide();

        player=new MediaPlayer().create(this, R.raw.maze2);
        player.start();

        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);

        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.game_background));

        level01= (Button) findViewById(R.id.button_level01);
        level02= (Button) findViewById(R.id.button_level02);
        level03= (Button) findViewById(R.id.button_level03);

        level01.setOnClickListener(this);
        level02.setOnClickListener(this);
        level03.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.button_level01:
                intent=new Intent(getApplicationContext(), StartGame.class);
                Maze maze=MazeMaker.getMaze(1);
                intent.putExtra("MAZE", maze);
                startActivity(intent);
                break;
            case R.id.button_level02:

                break;
            case R.id.button_level03:

                break;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
    }
}
