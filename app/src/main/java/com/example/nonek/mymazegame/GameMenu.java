package com.example.nonek.mymazegame;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class GameMenu extends AppCompatActivity implements View.OnClickListener {

    Intent intent;

    MediaPlayer player;
    Button newGame, exit;
    Window window;

    private Intent playIntent;
    private boolean musicBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Cambio el color del StatusBar
        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.game_background));

        newGame= (Button) findViewById(R.id.buttonNewGame);
        exit= (Button) findViewById(R.id.buttonExit);

        newGame.setOnClickListener(this);
        exit.setOnClickListener(this);

        //Establezco la tipografía importada en mi proyecto sobre los botones
        Typeface typeface = Typeface.createFromAsset(getAssets(), "PressStart2P.ttf");
        newGame.setTypeface(typeface);
        exit.setTypeface(typeface);

        Player.play(1, this);//Llamo a la clase estática Player para que reproduzca el audio que le indico según un valor entero
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonNewGame:
                intent=new Intent(getApplicationContext(), ListLevelsActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonExit:
                this.finish();
                break;
        }
    }
}
