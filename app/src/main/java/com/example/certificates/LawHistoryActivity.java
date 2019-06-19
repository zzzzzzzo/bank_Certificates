package com.example.certificates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LawHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_history);
        setTitle("历史试卷");
    }

    public void openHistory1(View btn) {
        Log.i("open","openHistory1:");
        Intent config = new Intent(this,History1Activity.class);
        startActivityForResult(config,1);
    }
}
