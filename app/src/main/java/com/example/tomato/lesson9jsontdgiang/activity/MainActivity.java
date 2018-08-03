package com.example.tomato.lesson9jsontdgiang.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomato.lesson9jsontdgiang.R;
import com.example.tomato.lesson9jsontdgiang.adapter.PostAdapter;
import com.example.tomato.lesson9jsontdgiang.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String LIST_POSITION = "1989";
    public static ArrayList<Post> arrPost;
    ListView lvPost;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getJson();
        initView();
        initAdapter();
        initEvent();

    }

    private void initEvent() {
        lvPost.setOnItemClickListener(this);
    }

    private void getJson() {
        new ReadJSON().execute("https://jsonplaceholder.typicode.com/posts");

    }

    private void initAdapter() {
        arrPost = new ArrayList<>();
        postAdapter = new PostAdapter(this, R.layout.item_listview_activity, arrPost);
        lvPost.setAdapter(postAdapter);

    }

    private void initView() {
        lvPost = findViewById(R.id.lv_post);
    }

    private void sendData(int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(LIST_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
        switch (view.getId()) {
            case R.id.lv_post:
                sendData(i);
                break;
            default:
                break;
        }
    }


    private class ReadJSON extends AsyncTask<String, Void, String> {

        StringBuilder content = new StringBuilder();

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray array = new JSONArray(s);

                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);

                    String userID = object.getString("userId");
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String body = object.getString("body");

                    int mId = Integer.parseInt(id);
                    int mUserID = Integer.parseInt(userID);

                    arrPost.add(new Post(mId, mUserID, title, body));
                }
                postAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
