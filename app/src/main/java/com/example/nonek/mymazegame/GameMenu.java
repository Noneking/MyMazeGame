package com.example.nonek.mymazegame;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class GameMenu extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, View.OnClickListener {

    Intent intent;

    MediaPlayer player;
    Button newGame, exit;
    Window window;

    private MusicService musicSrv;
    private Intent playIntent;
    private boolean musicBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        getSupportActionBar().hide();

        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.game_background));

        newGame= (Button) findViewById(R.id.buttonNewGame);
        exit= (Button) findViewById(R.id.buttonExit);

        newGame.setOnClickListener(this);
        exit.setOnClickListener(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "PressStart2P.ttf");
        newGame.setTypeface(typeface);
        exit.setTypeface(typeface);

        player=new MediaPlayer().create(this, R.raw.intro);
        player.start();

        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);

//        musicSrv.playSong(1);

    }

//    private ServiceConnection musicConnection = new ServiceConnection(){
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
//            //get service
//            musicSrv = binder.getService();
//            musicBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            musicBound = false;
//        }
//    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(playIntent==null){
//            playIntent = new Intent(this, MusicService.class);
//            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
//            startService(playIntent);
//        }
//    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonNewGame:
                intent=new Intent(getApplicationContext(), ListLevelsActivity.class);
                if(player!=null) {
                    player.stop();
                    player.release();
                }
                startActivity(intent);
                break;
            case R.id.buttonExit:
                this.finish();
                break;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        player.start();
    }
}
