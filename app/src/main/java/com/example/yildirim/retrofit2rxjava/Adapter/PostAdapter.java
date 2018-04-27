package com.example.yildirim.retrofit2rxjava.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yildirim.retrofit2rxjava.Model.Post;
import com.example.yildirim.retrofit2rxjava.R;

import java.util.List;

/**
 * Created by Yildirim on 27.04.2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);


        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {

        holder.title.setText(String.valueOf(postList.get(position).name));
        holder.author.setText(String.valueOf(postList.get(position).username));
        holder.constant.setText(String.valueOf(postList.get(position).email));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
