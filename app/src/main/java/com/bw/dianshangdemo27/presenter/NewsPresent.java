package com.bw.dianshangdemo27.presenter;

import com.bw.dianshangdemo27.base.BasePresenter;
import com.bw.dianshangdemo27.base.DataCall;
import com.bw.dianshangdemo27.bean.Resutl;
import com.bw.dianshangdemo27.model.NewSModel;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class NewsPresent extends BasePresenter {
    public NewsPresent(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Resutl getModel(Object... args) {
        return NewSModel.getnews((int)args[0]);
    }
}
