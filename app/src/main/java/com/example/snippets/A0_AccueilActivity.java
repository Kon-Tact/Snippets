package com.example.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.snippets.a1_layout_xml.A11_LinearLayoutXml;
import com.example.snippets.a1_layout_xml.A12_FrameLayoutXml;
import com.example.snippets.a4_media.A41_Audio_Auto;

public class A0_AccueilActivity extends AppCompatActivity {

    TextView linearLayout, frameLayout, relativeLayout, audioAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_activity_accueil);

        linearLayout.findViewById(R.id.linearLayout);
        frameLayout.findViewById(R.id.frameLayout);
        relativeLayout.findViewById(R.id.relativeLayout);
        audioAuto.findViewById(R.id.audioAuto);

        linearLayout.setOnClickListener(v -> {
            Intent itLinearLayoutAct = new Intent(A0_AccueilActivity.this, A11_LinearLayoutXml.class);
            startActivity(itLinearLayoutAct);
        });

        frameLayout.setOnClickListener(v -> {
            Intent itFrameLayoutAct = new Intent(A0_AccueilActivity.this, A12_FrameLayoutXml.class);
            startActivity(itFrameLayoutAct);
        });

//        relativeLayout.setOnClickListener(v -> {
//            Intent itRelativeLayoutAct = new Intent(A0_AccueilActivity.this, RelativeLayoutAct.class);
//            startActivity(itRelativeLayoutAct);
//        });

        audioAuto.setOnClickListener(v -> {
            Intent itAudioAuto = new Intent(A0_AccueilActivity.this, A41_Audio_Auto.class);
            startActivity(itAudioAuto);
        });

    }


}