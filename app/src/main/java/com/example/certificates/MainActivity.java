package com.example.certificates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rate,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_law) {
            Intent config = new Intent(this,LawActivity.class);
            startActivityForResult(config,1);
        }else if(item.getItemId()==R.id.menu_manage) {
            Intent config = new Intent(this,ManageActivity.class);
            startActivityForResult(config,2);
        }else if(item.getItemId()==R.id.menu_risk) {
            Intent config = new Intent(this,RiskActivity.class);
            startActivityForResult(config,3);
        }
        else if(item.getItemId()==R.id.menu_credit) {
            Intent config = new Intent(this,CreditActivity.class);
            startActivityForResult(config,4);
        }
        else if(item.getItemId()==R.id.menu_loan) {
            Intent config = new Intent(this,LoanActivity.class);
            startActivityForResult(config,5);
        }else if(item.getItemId()==R.id.menu_bank) {
            Intent config = new Intent(this,BankActivity.class);
            startActivityForResult(config,6);
        }
        return super.onOptionsItemSelected(item);
    }
}
