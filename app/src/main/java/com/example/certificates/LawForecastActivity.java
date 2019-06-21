package com.example.certificates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LawForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_forecast);
        setTitle("预测试卷");
    }

    public void openFore(View btn) {
        Log.i("open","openForecast1:");
        Intent config = new Intent(this,LawWriteActivity.class);
        startActivityForResult(config,1);
    }

    public void openForec(View btn) {
        Log.i("open","openForecast1:");
        Intent config = new Intent(this,LawNoteActivity.class);
        startActivityForResult(config,1);
    }
}
