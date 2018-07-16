package com.ekzhu.jokerviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    TextView tvJokeViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        tvJokeViewer=findViewById(R.id.tv_joke_viewer);

        String joke=getIntent().getStringExtra(getString(R.string.joke_key));
        if (!TextUtils.isEmpty(joke)&&joke!=null){
            tvJokeViewer.setText(joke);
        }else{
            tvJokeViewer.setText(getString(R.string.joke_error));
        }

    }
}
