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
        setTitle("银行业法律法规与综合能力");
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

    public void openNote(View btn) {
        Log.i("open","openNote:");
        Intent config = new Intent(this,LawNoteActivity.class);
        startActivityForResult(config,4);
    }

    public void openWrite(View btn) {
        Log.i("open","openWrite:");
        Intent config = new Intent(this,LawWriteActivity.class);
        startActivityForResult(config,5);
    }
}
