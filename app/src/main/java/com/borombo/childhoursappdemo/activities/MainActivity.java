package com.borombo.childhoursappdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.HomeProfileAdapter;
import com.borombo.childhoursappdemo.model.Profile;
import com.borombo.childhoursappdemo.singleton.FakeData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Profile> profiles = new ArrayList<>();

        profiles.add(new Profile("Moi"));
        profiles.add(new Profile("Toi"));
        profiles.add(new Profile("Lui"));
        profiles.add(new Profile("Elle"));
        profiles.add(new Profile("Nous"));
        profiles.add(new Profile("Vous"));
        profiles.add(new Profile("Ils"));
        profiles.add(new Profile("Elo"));
        profiles.add(new Profile("Truc"));
        profiles.add(new Profile("Machin"));

        currentTime = (TextView) findViewById(R.id.currentTime);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        final Handler someHandler = new Handler(getMainLooper());
        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentTime.setText(new SimpleDateFormat("HH:mm", Locale.FRANCE).format(new Date()));
                someHandler.postDelayed(this, 1000);
            }
        }, 10);

        HomeProfileAdapter adapter;

        adapter = new HomeProfileAdapter(FakeData.getInstance().getProfiles());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        Button addProfile = (Button) findViewById(R.id.addProfile);
        Button deleteProfile = (Button) findViewById(R.id.deleteProfile);

        addProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProfileActivity.class);
                startActivity(intent);
            }
        });

        deleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteProfileActivity.class);
                startActivity(intent);
            }
        });

    }


}
