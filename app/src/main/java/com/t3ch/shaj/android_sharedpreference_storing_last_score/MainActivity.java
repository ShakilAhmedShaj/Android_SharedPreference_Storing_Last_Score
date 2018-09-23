package com.t3ch.shaj.android_sharedpreference_storing_last_score;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plusBTN, minusBTN;
    private TextView scoreTV;

    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBTN = findViewById(R.id.buttonPlusId);
        minusBTN = findViewById(R.id.buttonMinusId);

        scoreTV = findViewById(R.id.scoreTV_id);

        if(loadScore()!=0)
        {
            scoreTV.setText("Score : " + loadScore());
            score = loadScore();
        }





        plusBTN.setOnClickListener(this);
        minusBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonPlusId) {

            score = score + 10;
            scoreTV.setText("Score : " + score);

            saveScore(score);

        } else if (v.getId() == R.id.buttonMinusId)

        {
            score = score - 10;
            scoreTV.setText("Score : " + score);
            saveScore(score);


        }


    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.commit();


    }

    private int loadScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);

        int score = sharedPreferences.getInt("lastScore", 0);
        return score;
    }


}
