package com.example.virtualmodel;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**---------- Fonction OnClick ----------**/

    public void LancerConstructionActivity(View view){
        Intent intent = new Intent(this, ConstructionActivity.class);
        startActivity(intent);
        Log.i("MainActivity", "LA CONSTRUCTION SE LANCE");
        Toast.makeText(MainActivity.this, "Vous lancez le mode construction !", Toast.LENGTH_SHORT).show();
    }

    public void LancerVisualisation(View view){
        Intent intent = new Intent(this, VisualisationActivity.class);
        startActivity(intent);
        Log.i("MainActivity", "LA VISUALISATION SE LANCE");
        Toast.makeText(MainActivity.this, "Vous lancez le mode visualisation !", Toast.LENGTH_SHORT).show();
    }
}