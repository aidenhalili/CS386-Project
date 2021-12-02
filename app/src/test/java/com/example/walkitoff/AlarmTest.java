package com.example.walkitoff;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmTest {

    @Test
    public void setAlarm() throws Exception {

        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");

        int offSet = 0;

        String currentTime, input = initInput(offSet);


            currentTime = formatTime.format( time );

            while( !input.equals( currentTime ) ){

                time = new Date();

                currentTime = formatTime.format( time );
            }
    }

    @Test
    public void setAlarm2() throws Exception {

        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");

        int offSet = 1;

        String currentTime, input = initInput(offSet);


        currentTime = formatTime.format( time );

        while( !input.equals( currentTime ) ){

            time = new Date();

            currentTime = formatTime.format( time );
        }
    }

    @Test
    public void setAlarm3() throws Exception {

        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");

        int offSet = 2;

        String currentTime, input = initInput(offSet);


        currentTime = formatTime.format( time );

        while( !input.equals( currentTime ) ){

            time = new Date();

            currentTime = formatTime.format( time );
        }
    }

    private String initInput(int offSet){

        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");

        int intInput = Integer.valueOf( formatTime.format( time ) ) + offSet;

        return String.valueOf( intInput );
    }
}