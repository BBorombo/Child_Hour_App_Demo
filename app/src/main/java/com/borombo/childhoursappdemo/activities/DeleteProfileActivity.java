package com.borombo.childhoursappdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.DeleteProfileAdapter;
import com.borombo.childhoursappdemo.model.Profile;

import java.util.ArrayList;

public class DeleteProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profile);

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        DeleteProfileAdapter adapter;
        ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile("Superman","0606060606"));
        adapter = new DeleteProfileAdapter(profiles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
