package com.example.virtualmodel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VisualisationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation);
        Toast.makeText(VisualisationActivity.this, "Visualisation", Toast.LENGTH_SHORT).show();
    }
}
