package com.example.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.snippets.R;

public class A16_GridLayoutXML extends AppCompatActivity {

    private static final String TAG = "A16_GridLayoutXML";

    public void playSound(View view){
        Button btnPress = (Button) view;
        String tag = btnPress.getTag().toString();
        Log.i(TAG, "playSound: " + btnPress.getId());

        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(tag, "raw", getPackageName()));

        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a16_grid_layout_xml);


    }
}