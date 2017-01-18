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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private TextView currentTime;

    HomeProfileAdapter adapter;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Realm instance
        realm = Realm.getDefaultInstance();

        currentTime = (TextView) findViewById(R.id.currentTime);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        // Affichage / MAJ de l'Heure

        final Handler someHandler = new Handler(getMainLooper());
        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentTime.setText(new SimpleDateFormat("HH:mm", Locale.FRANCE).format(new Date()));
                someHandler.postDelayed(this, 1000);
            }
        }, 10);

        // Set Adapter / Recycler View

        adapter = new HomeProfileAdapter(getProfiles());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        //  Add / Delete Listener

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

    /**
     * Recupère la liste des profils de la DB Locale
     * @return Liste des profils
     */
    public RealmResults<Profile> getProfiles(){
        return realm.where(Profile.class).findAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
