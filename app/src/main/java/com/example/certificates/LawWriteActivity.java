package com.example.certificates;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LawWriteActivity extends ListActivity implements Runnable{
    String data[] = {"one","two","three"};
    Handler handler;
    private String logDate = "";
    private final String DATE_SP_KEY = "lastRateDateStr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rate_list);

        SharedPreferences sp = getSharedPreferences("myrate",Context.MODE_PRIVATE);
        logDate = sp.getString(DATE_SP_KEY,"");
        Log.i("List","lastRateDateStr=" + logDate);

        Thread t = new Thread(this);
        t.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==7){
                    List<String> list = (List<String>) msg.obj;
                    ListAdapter adapter = new ArrayAdapter<String>(LawWriteActivity.this,android.R.layout.simple_list_item_1,list);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
    }

    @Override
    public void run() {
        //获取网络数据，放入list带回到主线程中
        List<String> retList = new ArrayList<String>();
            Document doc = null;
            try {
                Thread.sleep(3000);
                doc = Jsoup.connect("http://www.chinaacc.com/ccbp/fxzd/me20190316113445.shtml").get();
                Elements tables = doc.getElementsByTag("table");
                Element table2 = tables.get(0);
                //获取TD中的数据
                Elements strongs = table2.getElementsByTag("strong");
                for (int j = 0; j < strongs.size(); j += 1) {
                    Element sg1 = strongs.get(j);
                    String str1 = sg1.text();
                    retList.add(str1);//带回数据库
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        Message msg = handler.obtainMessage(7);
        //msg.what(5);
        msg.obj = "";
        msg.obj = retList;
        handler.sendMessage(msg);
    }
}
