package com.example.walkitoff;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class LoginButtonPress extends ButtonPress {

    private Context context;

    public LoginButtonPress( Context context ){

        this.context = context;
    }
    @Override
    public void onClick(View view) {
        connectDataBase();
    }

    private void connectDataBase(){

        Intent intent = new Intent( context, ConnectDB.class );

        context.startActivity( intent );
    }
}
