package com.example.certificates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LawHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_history);
        setTitle("历年真题");
    }

    public void openHistory1(View btn) {
        Log.i("open","openHistory1:");
        Uri uri = Uri.parse("http://www.233.com/ccbp/zhenti/ggjc/201905/01091052578-2.html");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void openHistory2(View btn) {
        Log.i("open","openHistory12:");
        Uri uri = Uri.parse("http://www.233.com/ccbp/zhenti/ggjc/201711/21094906918.html");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

}
