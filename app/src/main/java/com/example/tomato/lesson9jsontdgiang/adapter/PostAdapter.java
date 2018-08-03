package com.example.tomato.lesson9jsontdgiang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tomato.lesson9jsontdgiang.R;
import com.example.tomato.lesson9jsontdgiang.model.Post;

import java.util.ArrayList;


public class PostAdapter extends ArrayAdapter<Post> {

    private Context context;
    private int resource;
    private ArrayList<Post> arrPost;


    public PostAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Post> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrPost = objects;
    }

    public class ViewHolder {
        TextView tvUserId;
        TextView tvTitle;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_activity, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvUserId = convertView.findViewById(R.id.tv_userid);
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_title);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Post post = arrPost.get(position);

        viewHolder.tvUserId.setText(String.valueOf(post.getUserId()));
        viewHolder.tvTitle.setText(post.getTitle());

        return convertView;
    }
}
