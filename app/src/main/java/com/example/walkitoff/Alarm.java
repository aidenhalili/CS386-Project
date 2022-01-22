package com.example.walkitoff;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm {

    private MediaPlayer alarmSound;
    private int wakeUpTime;

    private static Context context;

    public Alarm( Context context, int time, String sound ){

        // set member data to parameters
        wakeUpTime = time;
        this.context = context;
        alarmSound = MediaPlayer.create(context, SoundFacade.getSound( sound ) );
    }

    /**
     * plays alarm sound on a loop until distance reached
     */
    private void playAlarm(){

        // start alarm sound
        alarmSound.start();
        alarmSound.setLooping( true );

        context.stopService( new Intent( context, BackgroundService.class ) );
    }

    /**
     * waits until wake-up time to play the alarm sound
     */
    public void setAlarm(){

        // initialize date objects
        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat( "HHmm" );

        // get the current time as a integer
        int currentTime = Integer.parseInt( formatTime.format( time ) );

        // loop until current time equals wake-up time
        while( currentTime != wakeUpTime ){

            time = new Date();

            currentTime = Integer.parseInt( formatTime.format( time ) );
        }

        playAlarm();
    }

    /**
     * stops the alarm sound
     */
    public void stopAlarm(){

        int defaultDistance = 30;

        // start tracking distance at test distance of 30 feet
        new Distance( context, defaultDistance ).trackDistance();

        // stop alarm sound
        alarmSound.setLooping( false );
        alarmSound.release();
    }

}
