package com.example.nonek.mymazegame;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by nonek on 21/02/2016.
 */
public class MusicService extends Activity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    static MediaPlayer player;
    private final IBinder musicBind = new MusicBinder();

//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//
//        return musicBind;
//    }
//
//    @Override
//    public boolean onUnbind(Intent intent){
//        player.stop();
//        player.release();
//        return false;
//    }

    public static void playSong(int number){
        switch(number){
            case 1:
                player=new MediaPlayer().create(null, R.raw.intro);
                player.start();

//                player.setOnPreparedListener();
//                player.setOnCompletionListener();
                break;
            case 2:

                break;
            case 3:

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

    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }


}
