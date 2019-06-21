package com.example.certificates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends ArrayAdapter {
    private static  final String TAG = "MyAdapter";

    public MyAdapter(Context context, int resource, ArrayList<HashMap<String, String>> list) {
        super(context, resource,list);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) { //获得view控件
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            //把布局文件转换成当前行对象
        }

        Map<String,String> map = (Map<String, String>) getItem(position);//获取当前行对象（position为下标）
        TextView title = (TextView) itemView.findViewById(R.id.itemTitle);

        title.setText("Title:" + map.get("ItemTitle")); //从map中取数据，与前面的名称Tltle合并构成布局文件

        return itemView;
    }
}
