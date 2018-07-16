package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.ekzhu.jokerviewer.JokeViewerActivity;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    ProgressBar pbJoke = null;
    Button btnJoke;
    public String fetchedJoke = null;


    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);



        btnJoke=root.findViewById(R.id.btn_joke);
        btnJoke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pbJoke.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        pbJoke =  root.findViewById(R.id.pb_joke);
        pbJoke.setVisibility(View.GONE);

        return root;
    }
    public void getJoke(){
        new EndPointTask().execute(this);
    }

    public void launchJokeViewer(){
            Context context = getActivity();
            Intent intent = new Intent(context, JokeViewerActivity.class);
            intent.putExtra(context.getString(R.string.joke_key), fetchedJoke);
            //Toast.makeText(context, fetchedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
            pbJoke.setVisibility(View.GONE);

    }

}
