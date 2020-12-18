package com.example.day03.model;

import com.example.day03.bean.ImageBean;
import com.example.day03.bean.ItemBean;
import com.example.day03.bean.TuiBean;
import com.example.day03.bean.WenBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    //
    public static final  String BEAN_URL="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ImageBean> getImagebena();
    //http://123.56.232.18:8080/
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<ItemBean> getItemBean();
    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<WenBean> getWenBEAN();
    //http://123.56.232.18:8080/
    @GET("serverdemo//tag/queryTagList")
    Observable<TuiBean> getTuiBean();
}
