package com.example.certificates;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.certificates.R;

import java.util.ArrayList;


public class WriteMainActivity extends AppCompatActivity {
    ListView listView;
    FloatingActionButton floatingActionButton;
    LayoutInflater layoutInflater;
    ArrayList<Data> arrayList;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_main);
        setTitle("学习笔记");
        listView = (ListView) findViewById(R.id.layout_listview);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.add_note);
        layoutInflater = getLayoutInflater();

        myDatabase = new MyDatabase(this);
        arrayList = myDatabase.getarray();
        MyAdapter2 adapter = new MyAdapter2(layoutInflater, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {   //点击一下跳转到编辑页面（编辑页面与新建页面共用一个布局）
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), WriteLesserActivity.class);
                intent.putExtra("ids", arrayList.get(position).getIds());
                startActivity(intent);
                WriteMainActivity.this.finish();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {   //长按删除
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(WriteMainActivity.this) //弹出一个对话框
                        .setMessage("确定要删除此条笔记？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myDatabase.toDelete(arrayList.get(position).getIds());
                                MyAdapter2 myAdapter = new MyAdapter2(layoutInflater, arrayList);
                                listView.setAdapter(myAdapter);
                            }
                        })
                        .create()
                        .show();
                return true;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {   //点击悬浮按钮时，跳转到新建页面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WriteLesserActivity.class);
                startActivity(intent);
                WriteMainActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.write, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_newnote:
                Intent intent = new Intent(getApplicationContext(), WriteLesserActivity.class);
                startActivity(intent);
                WriteMainActivity.this.finish();
                break;
            case R.id.menu_exit:
                WriteMainActivity.this.finish();
                break;
            default:
                break;
        }
        return true;
    }
}