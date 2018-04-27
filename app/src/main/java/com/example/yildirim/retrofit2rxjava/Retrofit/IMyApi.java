package com.example.yildirim.retrofit2rxjava.Retrofit;

import com.example.yildirim.retrofit2rxjava.Model.Post;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Yildirim on 9.04.2018.
 */

public interface IMyApi {

    @GET("users")
    Observable<List<Post>> getPosts();
}
