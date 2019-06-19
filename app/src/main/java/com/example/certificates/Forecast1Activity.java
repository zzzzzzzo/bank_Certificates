package com.example.certificates;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Forecast1Activity extends ListActivity implements Runnable {
    String data[] = {"one","tow","three"};
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_forecast1);

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
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
                doc = Jsoup.connect("http://www.boc.cn/sourcedb/whpj").get();
                Elements tables = doc.getElementsByTag("table");
                Element table2 = tables.get(1);
                Elements tds = table2.getElementsByTag("td");
                for (int j = 0; j < tds.size(); j += 8) {
                    Element td1 = tds.get(j);
                    Element td2 = tds.get(j + 5);
                    String str1 = td1.text();
                    String val = td2.text();
                    retList.add(str1 + "==>" + val);//带回数据库
                    retList.add(str1 + "==>" + val);//保存数据库
                }
        }catch (IOException e) {
                e.printStackTrace();
        }
        Message msg = handler.obtainMessage(7);
        //msg.what(5);
        msg.obj = "";
        msg.obj = retList;
        handler.sendMessage(msg);

    }
}
