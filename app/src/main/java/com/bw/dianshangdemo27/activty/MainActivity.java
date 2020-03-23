package com.bw.dianshangdemo27.activty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.dianshangdemo27.R;
import com.bw.dianshangdemo27.adapter.MyAdapter;
import com.bw.dianshangdemo27.base.BaseActivity;
import com.bw.dianshangdemo27.base.DataCall;
import com.bw.dianshangdemo27.bean.NewsBean;
import com.bw.dianshangdemo27.bean.Resutl;
import com.bw.dianshangdemo27.presenter.NewsPresent;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity implements DataCall<NewsBean> {
PullToRefreshListView pullToRefreshListView;
NewsPresent newsPresent;
MyAdapter myAdapter;
int page=1;

    @Override
    protected void destory() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    newsPresent=new NewsPresent(this);
    pullToRefreshListView=findViewById(R.id.pulllllllll);
    myAdapter=new MyAdapter();
    pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    pullToRefreshListView.setAdapter(myAdapter);
    pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            page=1;
            newsPresent.request(page);
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
        newsPresent.request(page);
        }
    });
    newsPresent.request(page);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void sessecc(Resutl<NewsBean> resutl) {
        pullToRefreshListView.onRefreshComplete();
        if (resutl.code==200){
            if (page==1){
                myAdapter.clear();
            }
            myAdapter.addAll(resutl.result);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void feil() {
        pullToRefreshListView.onRefreshComplete();
        Toast.makeText(this,"加载失败",Toast.LENGTH_LONG).show();
    }
}
