package com.example.walkitoff;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

public class SoundSpinner extends MainSpinner{

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemSelected( adapterView, view, i, l );

        MainActivity.chosenSound = selection;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        super.onNothingSelected( adapterView );

    }

    /**
     * fills the drop down spinner menu with unlocked sounds
     */
    public static void fillSoundSpinner( Context context ){

        String[] soundArray = SoundFacade.getSoundArray( MainActivity.level );

        MainSpinner.fillSpinner( context, soundArray, R.id.soundspinner );
    }
}
