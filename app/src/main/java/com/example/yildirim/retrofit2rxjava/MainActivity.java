package com.example.yildirim.retrofit2rxjava;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yildirim.retrofit2rxjava.Adapter.PostAdapter;
import com.example.yildirim.retrofit2rxjava.Model.Post;
import com.example.yildirim.retrofit2rxjava.Retrofit.IMyApi;
import com.example.yildirim.retrofit2rxjava.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IMyApi myApi;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myApi = retrofit.create(IMyApi.class);

        recyclerView = findViewById(R.id.recyclerPost);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        getData();
    }

    private void getData() {

        compositeDisposable.add(myApi.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) throws Exception {

                displayData(posts);
            }
        }));

    }

    private void displayData(List<Post> posts) {

        PostAdapter postAdapter =  new PostAdapter(this, posts) ;
        recyclerView.setAdapter(postAdapter);
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        compositeDisposable.clear();
        super.onSupportActionModeStarted(mode);
    }
}
