package com.borombo.childhoursappdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.DeleteProfileAdapter;
import com.borombo.childhoursappdemo.model.Profile;

import io.realm.Realm;

public class DeleteProfileActivity extends AppCompatActivity {

    private DeleteProfileAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profile);

        Realm realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        adapter = new DeleteProfileAdapter(realm.where(Profile.class).findAll());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}
