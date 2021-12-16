package com.example.walkitoff;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

public class MainSpinner implements AdapterView.OnItemSelectedListener{

    public String selection = "";

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        selection = adapterView.getItemAtPosition( i ).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void initializeSpinner(Context context) {

        Activity activity = (Activity)context;

        // declare spinners
        android.widget.Spinner soundSpinner = activity.findViewById( R.id.soundspinner );
        android.widget.Spinner presetSpinner = activity.findViewById( R.id.presetspinner );

        // set listeners
        presetSpinner.setOnItemSelectedListener( new PresetSpinner() );
        soundSpinner.setOnItemSelectedListener( new SoundSpinner() );
    }
    }
