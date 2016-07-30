package com.example.matthew.componentsandroid.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.example.matthew.componentsandroid.Controller.Adapters.AdapterTestComponent;
import com.example.matthew.componentsandroid.Controller.Adapters.rxJava.RxJavaCallAdapterFactory;
import com.example.matthew.componentsandroid.Gestor.AndroidSettings;
import com.example.matthew.componentsandroid.Model.Test;
import com.example.matthew.componentsandroid.Model.TestComponents;
import com.example.matthew.componentsandroid.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gonde on 30/07/2016.
 */
public class Persistency {
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Retrofit url;
    private Test test;

    public Persistency(Context context) {
        this.context = context;
        if (url == null) {
            url = new Retrofit.Builder().baseUrl(AndroidSettings.getAPI()).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }

    static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AndroidSettings.getAPI())
                .build();
        T service = retrofit.create(clazz);
        return service;
    }

    public void GetTest(final ListView lv, final AdapterTestComponent adapter) throws IOException {

        if (test == null) {
            test = createRetrofitService(Test.class, AndroidSettings.getAPI());
        }

        test.listReposAll().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<TestComponents>>() {


                    @Override
                    public void onCompleted() {
                        //lv.refreshDrawableState();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<TestComponents> testComponentses) {
                        for (TestComponents test : testComponentses) {
                            adapter.add(test);
                            adapter.notifyDataSetChanged();
                        }
                    }


                });


    }
}
