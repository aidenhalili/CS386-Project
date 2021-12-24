package com.example.walkitoff;

import android.content.Context;
import android.media.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm {

    private String alarmSound;
    private int wakeUpTime;

    Context context;

    public Alarm( Context context, int time, String sound ){

        // set member data to parameters
        wakeUpTime = time;
        alarmSound = sound;
        this.context = context;
    }

    /**
     * plays alarm sound on a loop until distance reached
     */
    private void playAlarm(){

        MediaPlayer sound = MediaPlayer.create( context, SoundFacade.getSound( alarmSound ) );

        // start alarm sound
        sound.start();
        sound.setLooping( true );

        // initialize alarm stop
        stopAlarm( sound );
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
    public void stopAlarm( MediaPlayer sound ){

        int defaultDistance = 30;

        // start tracking distance at test distance of 30 feet
        new Distance( context, defaultDistance ).trackDistance();

        // stop alarm sound
        sound.setLooping( false );
        sound.release();
    }

}
