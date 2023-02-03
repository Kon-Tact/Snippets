package com.example.snippets.a4_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.example.snippets.R;

import java.util.Timer;
import java.util.TimerTask;

public class A41_Audio_Auto extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button uptownFunk;
    ImageButton imagePlay, imagePause;

    public void myPlay(View view){
        mediaPlayer.start();
    }

    public void myPause(View view){
        mediaPlayer.pause();
    }

    private void position() {
        SeekBar sbControle = findViewById(R.id.seekBar2);
        sbControle.setMax(mediaPlayer.getDuration());
        sbControle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                myPause(sbControle);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myPlay(sbControle);
                mediaPlayer.seekTo(sbControle.getProgress());

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sbControle.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 300);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a41_audio_auto);


        imagePlay = findViewById(R.id.imagePlay);
        imagePause = findViewById(R.id.imagePause);

        uptownFunk = findViewById(R.id.uptownFunk);

        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);
        position();

        imagePlay.setOnClickListener(v -> mediaPlayer.start());
        imagePause.setOnClickListener(v -> mediaPlayer.pause());

        SeekBar sbVolume = findViewById(R.id.seekBar);
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