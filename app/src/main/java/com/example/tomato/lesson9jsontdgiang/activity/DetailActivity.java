package com.example.tomato.lesson9jsontdgiang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tomato.lesson9jsontdgiang.R;
import com.example.tomato.lesson9jsontdgiang.model.Post;

public class DetailActivity extends AppCompatActivity {

    TextView tvBody;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        getData();
        loadData();
    }

    private void loadData() {
        tvBody.setText(post.getBody());
    }

    private void getData() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.LIST_POSITION, 1);
        post = MainActivity.arrPost.get(position);
    }

    private void initView() {
        tvBody = findViewById(R.id.tv_body);
    }
}
