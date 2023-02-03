package com.example.snippets.a3_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.snippets.R;

public class A31_Splash_Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a31_splash_animation);

        ImageView imageView_loading = findViewById(R.id.imageView_loading);

        imageView_loading.animate().alpha(1).rotation(4000).setDuration(40000);

        imageView_loading.setOnClickListener(v -> {
            imageView_loading.animate().cancel();
        });
    }
}