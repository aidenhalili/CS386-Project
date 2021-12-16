package com.example.walkitoff;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainSpinner implements AdapterView.OnItemSelectedListener{

    public String selection = "";

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        selection = adapterView.getItemAtPosition( i ).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void fillSpinner( Context context, String[] array, int spinnerId ){

        Activity activity = (Activity)context;

        Spinner spinner = activity.findViewById( spinnerId );

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, array);

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter( adapter );
    }
    }
