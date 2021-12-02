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

        String currentTime;

        String[] inputArray = new String[3];
        String[] outputArray = new String[3];

        int arraySize = 0;
        int offSet = 0;

        String input = initInput(offSet);

        while( offSet < 3 ){

            inputArray[arraySize] = input;

            currentTime = formatTime.format( time );

            while( !input.equals( currentTime ) ){

                time = new Date();

                currentTime = formatTime.format( time );
            }

            offSet++;

            outputArray[arraySize] = currentTime;

            arraySize++;

        }

        assertArrayEquals(inputArray, outputArray);
    }

    private String initInput(int offSet){

        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");

        int intInput = Integer.valueOf( formatTime.format( time ) ) + offSet;

        return String.valueOf( intInput );
    }
}