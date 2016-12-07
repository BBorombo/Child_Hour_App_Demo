package com.borombo.childhoursappdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.DeleteProfileAdapter;
import com.borombo.childhoursappdemo.singleton.FakeData;

public class DeleteProfileActivity extends AppCompatActivity {

    private DeleteProfileAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profile);

        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);


//        ArrayList<Profile> profiles = new ArrayList<Profile>();
//        profiles.add(new Profile("Superman","0606060606"));

        adapter = new DeleteProfileAdapter(FakeData.getInstance().getProfiles());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void profileDeleted(int position){
        recyclerView.removeViewAt(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, FakeData.getInstance().getProfiles().size());
    }
}
