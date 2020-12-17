package com.example.day03.modle;

import android.util.Log;

import com.example.day03.back.HomeBack;
import com.example.day03.modle.bean.ListBean;
import com.example.day03.modle.bean.PicsBean;
import com.example.day03.modle.bean.TextBean;
import com.example.day03.modle.bean.VideoBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeGson {
    public void start(final HomeBack back) {

        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getPics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PicsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PicsBean value) {
                        if (back != null) {
                            back.showdui(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (back != null) {
                            back.showcuo(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean value) {
                        if (back != null) {
                            back.showdui(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (back != null) {
                            back.showcuo(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getText()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean value) {
                        if (back != null) {
                            back.showdui(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (back != null) {
                            back.showcuo(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean value) {
                        if (back != null) {
                            back.showdui(value);
                        }

                        Log.e("TAG", "推荐请求成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (back != null) {
                            back.showcuo(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
