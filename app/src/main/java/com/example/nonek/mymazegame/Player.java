package com.example.nonek.mymazegame;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by nonek on 25/02/2016.
 */
public class Player {

    public static MediaPlayer player;

    //Reproduce el audio que se le indica
    public synchronized static void play(int num,Context context){

        try {
            player.reset();
            player.pause();
        } catch(Exception ex){}
        switch(num){
            case 1:
                player=MediaPlayer.create(context ,R.raw.intro);
                player.start();
                break;
            case 2:
                player=MediaPlayer.create(context ,R.raw.maze1);
                player.start();
                break;
            case 3:
                player=MediaPlayer.create(context ,R.raw.pacman_intro);
                try {
                    player.start();
                    Thread.sleep(player.getDuration());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player=MediaPlayer.create(context ,R.raw.maze2);
                player.start();
                break;
            case 4:
                player=MediaPlayer.create(context, R.raw.sonido_final);
                try {
                    player.start();
                    Thread.sleep(player.getDuration());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
