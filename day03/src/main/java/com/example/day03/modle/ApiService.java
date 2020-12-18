package com.example.day03.modle;

import com.example.day03.modle.bean.ListBean;
import com.example.day03.modle.bean.PicsBean;
import com.example.day03.modle.bean.TextBean;
import com.example.day03.modle.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics
    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video
    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275
    //http://123.56.232.18:8080/serverdemo//tag/queryTagList

    String BASE_URL = "http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<PicsBean> getPics();

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<VideoBean> getVideo();


    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<TextBean> getText();


    @GET("serverdemo//tag/queryTagList")
    Observable<ListBean> getList();//


}
