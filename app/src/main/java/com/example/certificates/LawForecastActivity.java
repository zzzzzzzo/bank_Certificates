package com.example.certificates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LawForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_forecast);
        setTitle("模拟考试");
    }

    public void openForecast1(View btn) {
        Log.i("open","openForecast1:");
        Uri uri = Uri.parse("https://img3.233.com/2019-06/03/155952696974561.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void openForecast2(View btn) {
        Log.i("open","openForecast2:");
        Uri uri = Uri.parse("https://img3.233.com/2019-05/21/155841932227311.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
