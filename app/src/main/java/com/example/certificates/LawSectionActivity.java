package com.example.certificates;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LawSectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_section);
    }

    public void openFirst(View btn) {
        Log.i("open","openFirst:");
        Intent config = new Intent(this,FirstActivity.class);
        startActivityForResult(config,1);
    }

    public void openSecond(View btn) {
        Log.i("open","openSecond:");
        Intent config = new Intent(this,SecondActivity.class);
        startActivityForResult(config,2);
    }

    public void openThird(View btn) {
        Log.i("open","openThird:");
        Intent config = new Intent(this,ThirdActivity.class);
        startActivityForResult(config,3);
    }

    public void openFourth(View btn) {
        Log.i("open","openFourth:");
        Intent config = new Intent(this,FourthActivity.class);
        startActivityForResult(config,4);
    }

    public void openFifth(View btn) {
        Log.i("open","openFifth:");
        Intent config = new Intent(this,FifthActivity.class);
        startActivityForResult(config,5);
    }
}
