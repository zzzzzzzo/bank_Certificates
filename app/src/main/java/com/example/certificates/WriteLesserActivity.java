package com.example.certificates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.certificates.MainActivity;
import com.example.certificates.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteLesserActivity extends AppCompatActivity {
    EditText ed_title;
    EditText ed_content;
    FloatingActionButton floatingActionButton;
    MyDatabase myDatabase;
    Data data;
    int ids;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_lesser);
        setTitle("学习笔记");
        ed_title = (EditText)findViewById(R.id.title);
        ed_content = (EditText)findViewById(R.id.content);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.finish);
        myDatabase = new MyDatabase(this);
        Intent intent = this.getIntent();
        ids = intent.getIntExtra("ids",0);
        if (ids != 0){
            data = myDatabase.getTiandCon(ids);
            ed_title.setText(data.getTitle());
            ed_content.setText(data.getContent());
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {//为悬浮按钮设置监听事件
            @Override
            public void onClick(View v) {
                isSave();
            }
        });
    }

    @Override
    public void onBackPressed() {     //重写返回建方法，如果是属于新建则插入数据表并返回主页面，如果是修改，修改表中数据并返回主页面
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm");//编辑便签的时间，格式化
        Date date = new Date(System.currentTimeMillis());
        String time = simpleDateFormat.format(date);
        String title = ed_title.getText().toString();
        String content = ed_content.getText().toString();
        if(ids!=0){
            data=new Data(title,ids, content, time);
            myDatabase.toUpdate(data);
            Intent intent=new Intent(WriteLesserActivity.this,WriteMainActivity.class);
            startActivity(intent);
            WriteLesserActivity.this.finish();
        }
        //新建日记
        else{
            data=new Data(title,content,time);
            myDatabase.toInsert(data);
            Intent intent=new Intent(WriteLesserActivity.this,WriteMainActivity.class);
            startActivity(intent);
            WriteLesserActivity.this.finish();
        }

    }

    private void isSave(){   //写一个方法进行调用，如果是属于新建则插入数据表并返回主页面，如果是修改，修改表中数据并返回主页面
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH：mm");
        Date date = new Date(System.currentTimeMillis());
        String time = simpleDateFormat.format(date);
        Log.d("new_note", "isSave: "+time);
        String title = ed_title.getText().toString();
        String content = ed_content.getText().toString();
        if(ids!=0){
            data=new Data(title,ids, content, time);
            myDatabase.toUpdate(data);
            Intent intent=new Intent(WriteLesserActivity.this,WriteMainActivity.class);
            startActivity(intent);
            WriteLesserActivity.this.finish();
        }
        //新建日记
        else{
            data=new Data(title,content,time);
            myDatabase.toInsert(data);
            Intent intent=new Intent(WriteLesserActivity.this,WriteMainActivity.class);
            startActivity(intent);
            WriteLesserActivity.this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_share :  //分享功能
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,//分享类型设置为文本型
                        "标题："+ed_title.getText().toString()+"    " +
                                "内容："+ed_content.getText().toString());
                startActivity(intent);
                break;
            default:
                break;
        }
        return false;
    }

}