package com.example.certificates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Runnable{
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("银行从业资格考试");

        //开启子线程
        Thread t = new Thread(this);
        t.start();

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 5) {
                    String str = (String) msg.obj;
                }
                super.handleMessage(msg);
            }
        };
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

    public void openNew(View btn) {
        Log.i("open","openNew:");
        Uri uri = Uri.parse("https://www.china-cba.net/Index/lists/catid/68.html");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //获取Msg对象，用于返回主线程
        Message msg = handler.obtainMessage(5);
        //msg.what(5);
        msg.obj = "";
        handler.sendMessage(msg);

        //获取网络数据
        try {
            URL url = new URL("http://www.233.com/ccbp/zhenti/");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream in = http.getInputStream();
            String html = inputStream2String(in);
            Document doc = Jsoup.parse(html);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "gb2312");
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }
}
