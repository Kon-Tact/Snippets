package com.example.snippets.a4_media;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.snippets.R;

public class A42_Video_Auto extends AppCompatActivity {

    VideoView myVideoView;
    MediaController mediaController;
    int position;

    //Méthodes d'initialisation de l'interface externe
    private void initUi(){
        myVideoView = findViewById(R.id.myVideoView);
        String uriPath = ("android.ressource://" + getPackageName() + "/raw/" + R.raw.mp_ts_drunk);
        Uri uri = Uri.parse(uriPath);
        myVideoView.setVideoURI(uri);
    }

    private void plase1_sansControle(){
        initUi();
        myVideoView.start();
    }

    private void phase2_avecControle(){
        initUi();
        myVideoView.start();

        if(this.mediaController == null){
            this.mediaController = new MediaController(A42_Video_Auto.this);
        }

        mediaController.setAnchorView(myVideoView);
        myVideoView.setMediaController(mediaController);
    }

    public void seektoPositionInVideo(){
        myVideoView.seekTo(position);
        myVideoView.start();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentPosition", position);
        myVideoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        seektoPositionInVideo();
    }

    //Gestion du mode plein écran
    //Cf manifest pour la configuration de l'orientation et de la taille de l'écran
    //On commence par initialiser un objet de type Configuration
    private Configuration newConfig;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a42_video_auto);

        phase2_avecControle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        seektoPositionInVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        position = myVideoView.getCurrentPosition();
    }
}