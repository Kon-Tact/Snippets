package com.example.snippets.a3_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.snippets.R;

public class A32_Simpsons_Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a32_simpsons_animation);

        ImageView ivSimpsonTitre = findViewById(R.id.ivSimpsonTitre);
        ImageView ivHomer = findViewById(R.id.ivHomer);
        ImageView ivBart = findViewById(R.id.ivBart);

        ivBart.setTranslationX(1000);
        ivHomer.setTranslationX(1500);


        ivSimpsonTitre.setOnClickListener(v -> {
            ivSimpsonTitre.animate().alpha(1).rotation(1000).setDuration(2000);
            ivSimpsonTitre.animate().alpha(0.0f).setStartDelay(1000);
            ivBart.animate().translationX(- 3000).setDuration(4000).setStartDelay(1500);
            ivHomer.animate().translationX(- 3000).setDuration(4000).setStartDelay(1500);
        });
    }
}