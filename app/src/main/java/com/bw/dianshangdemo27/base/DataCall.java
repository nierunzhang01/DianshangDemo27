package com.bw.dianshangdemo27.base;

import com.bw.dianshangdemo27.bean.Resutl;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public interface DataCall<T> {
    void sessecc(Resutl<T> resutl);
    void feil();
}
