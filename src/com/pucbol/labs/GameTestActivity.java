package com.pucbol.labs;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class GameTestActivity extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new MyGame(), false);
        //setContentView(R.layout.main);
        
    }
}