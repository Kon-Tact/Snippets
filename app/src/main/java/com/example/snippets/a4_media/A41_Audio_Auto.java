package com.example.snippets.a4_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.snippets.R;

public class A41_Audio_Auto extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button uptownFunk;

    public void myPlay(View view){
        mediaPlayer.start();
    }

    public void myPause(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a41_audio_auto);

        uptownFunk.findViewById(R.id.uptownFunk);

        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);

        uptownFunk.setOnClickListener(v -> {
            mediaPlayer.start();
        });

        SeekBar sbVolume = findViewById(R.id.seekBar);
        SeekBar sbAutre = findViewById(R.id.seekBar2);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        //Volume max du téléphone
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setMax(volumeMax);

        //Definir le volume courant
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setProgress(currentVolume);

        sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}