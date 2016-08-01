package com.example.matthew.componentsandroid.Model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gonde on 30/07/2016.
 */
public interface Test {
    @GET("posts/{id}")
    Call<TestComponents> listRepos(@Path("id") String id);

    @GET("posts")
    Observable<List<TestComponents>> listReposAll();

}
