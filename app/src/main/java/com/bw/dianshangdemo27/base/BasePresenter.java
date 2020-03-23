package com.bw.dianshangdemo27.base;

import android.os.Handler;
import android.os.Message;

import com.bw.dianshangdemo27.bean.Resutl;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public abstract class BasePresenter {
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj==null){
                dataCall.feil();
            }else {
                Resutl resutl= (Resutl) msg.obj;
                dataCall.sessecc(resutl);
            }
        }
    };
    public void request(final Object...args){
        new Thread(new Runnable(){
            @Override
            public void run() {
               Resutl resutl = getModel(args);
                final Message message = Message.obtain();
                message.obj=resutl;
                handler.sendMessage(message);
            }
        }).start();
    }

    protected abstract Resutl getModel(Object...args);
}
