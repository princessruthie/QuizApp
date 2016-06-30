package com.ruthiefloats.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score;
    private boolean isQ1Right;
    private boolean isQ2Right;
    private boolean isQ3Right;
    private boolean isQ4Right;

    private boolean isQ2Katherine;
    private boolean isQ2Kunal;
    private boolean isQ2RuPaul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAnswerQ1True(View view) {
        isQ1Right = true;
    }

    public void onAnswerQ1False(View view) {
        isQ1Right = false;
    }

    public void onAnswerQ2Katherine(View view) {
        isQ2Katherine = !isQ2Katherine;
    }

    public void onAnswerQ2Rupaul(View view) {
        isQ2RuPaul = !isQ2RuPaul;
    }

    public void onAnswerQ2Kunal(View view) {
        isQ2Kunal = !isQ2Kunal;
    }


    public void onAnswerQ4Yes(View view) {
        isQ4Right = true;
    }

    public void onAnswerQ4No(View view) {
        isQ4Right = false;
    }


    private void calculateScore() {
        checkQ2();
        checkQ3();
        score = 0;
        if (isQ1Right) score += 1;
        if (isQ2Right) score += 1;
        if (isQ3Right) score += 1;
        if (isQ4Right) score += 1;

    }

    private void checkQ3() {
        EditText q3Answer = (EditText) findViewById(R.id.editText);
        String q3Text = q3Answer.getText().toString();
        String compare = getString(R.string.cat);
        isQ3Right = q3Text.equals(compare);
    }

    private void checkQ2() {
        isQ2Right = false;
        if (isQ2Katherine & isQ2Kunal & !isQ2RuPaul) {
            isQ2Right = true;
        }
    }

    public void onFinish(View view) {
        calculateScore();
        TextView summary = (TextView) findViewById(R.id.summary);
        summary.setText(getString(R.string.summary) + " " + score + ".");
        summary.setVisibility(View.VISIBLE);
    }
}
