package com.example.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.snippets.R;

public class A11_LinearLayoutXml extends AppCompatActivity {

    Button exemple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a11_linear_layout_xml);

        exemple.findViewById(R.id.exemple);

        exemple.setOnClickListener(v -> {
            Intent itLinearVertical = new Intent(A11_LinearLayoutXml.this,
                    A11_1_LinearVerticalActivity.class);
        });
    }
}