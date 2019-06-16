package com.example.certificates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law);
    }

    public void openSection(View btn) {
        Log.i("open","openSection:");
        Intent config = new Intent(this,LawSectionActivity.class);
        startActivityForResult(config,1);
    }

    public void openHistory(View btn) {
        Log.i("open","openHistory:");
        Intent config = new Intent(this,LawHistoryActivity.class);
        startActivityForResult(config,2);
    }

    public void openForecast(View btn) {
        Log.i("open","openForecast:");
        Intent config = new Intent(this,LawForecastActivity.class);
        startActivityForResult(config,3);
    }
}
