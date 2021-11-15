package com.teamfour.motcacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        Bundle _textexport = getIntent().getExtras();

        TextView Score = findViewById(R.id.finalscore);

        Score.setText("Score: " + _textexport.getString("score") );
    }
}