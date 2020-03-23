package com.bw.dianshangdemo27.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bw.dianshangdemo27.R;
import com.bw.dianshangdemo27.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class MyAdapter extends BaseAdapter {
    private List<NewsBean> list=new ArrayList<>();
    @Override
    public int getCount() {
        return list.size();
    }
public void addAll(List<NewsBean> data){
        list.addAll(data);
}
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_top, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.textView1=convertView.findViewById(R.id.textviwwwww);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final NewsBean newsBean = list.get(position);
        viewHolder.textView1.setText(newsBean.desc);
        return convertView;
    }
    public void clear(){
        list.clear();
    }
    class ViewHolder{
        TextView textView1;
    }
}
