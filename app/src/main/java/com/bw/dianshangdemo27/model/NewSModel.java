package com.bw.dianshangdemo27.model;

import com.bw.dianshangdemo27.bean.NewsBean;
import com.bw.dianshangdemo27.bean.Resutl;
import com.bw.dianshangdemo27.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class NewSModel {
    public static Resutl<NewsBean> getnews(int page){
        final String json = NetUtil.getInstance().doGet("http://47.94.132.125/baweiapi/gank_android?page="+page+"&pageSize=5");
        if (json==null){
            return null;
        }
        final Gson gson = new Gson();
        final Type type = new TypeToken<Resutl<NewsBean>>() {}.getType();
      Resutl<NewsBean> data= gson.fromJson(json, type);
    return data;
    }
}
