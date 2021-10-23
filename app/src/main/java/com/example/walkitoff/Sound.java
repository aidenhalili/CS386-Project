package com.example.walkitoff;

import android.media.MediaPlayer;

public class Sound extends MainActivity{

    /*
    this class is to be used by the Alarm class. it functions as a library
    of sounds that the user can choose from, all stored in an array
     */

    // constants
    private static int DEFAULT_CAPACITY = 10;

    // array of alarm sounds that the user can choose from and array of every alarm sound
    private MediaPlayer[] unlockedSoundArray, everySoundArray;

    // sounds
    private MediaPlayer defaultSound;

    private int arraySize, arrayCapacity;

    /**
     * default constructor
     */
    public Sound(){

    }

    /**
     * appends a single sound to the array
     *
     * @param sound - alarm sound to add to array
     */
    private void addSound( MediaPlayer sound ){


    }

    /**
     * adds all unlocked sounds to the array.
     * <p>
     * note: uses score object to determine which sounds to add
     */
    @SuppressWarnings("unused")
    private void addAllUnlockedSounds(){

        // add the base sound
        addSound( defaultSound );

        // TODO: add all other sounds accordingly once we have other sounds
    }

    /**
     * checks if the user has the required score to use the sound (called before adding sound to
     * unlocked sound array)
     *
     * @param sound - alarm sound that may or may not be added to unlocked sound array
     */
    private void checkWithScore( MediaPlayer sound ){

    }

    /**
     * finds sound in unlocked sound array
     *
     * @param Sound - alarm sound to match to array
     *
     * @return sound if found in unlocked sound array, null otherwise
     */
    public Sound chooseSound( MediaPlayer Sound ){

        return null;
    }

}
