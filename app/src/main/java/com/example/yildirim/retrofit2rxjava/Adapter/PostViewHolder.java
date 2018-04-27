package com.example.yildirim.retrofit2rxjava.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yildirim.retrofit2rxjava.R;

/**
 * Created by Yildirim on 27.04.2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView title, author, constant;

    public PostViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.txtTitle);
        author = itemView.findViewById(R.id.txtAuthor);
        constant = itemView.findViewById(R.id.txtContent);
    }
}
