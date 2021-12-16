package com.example.walkitoff;

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
}
