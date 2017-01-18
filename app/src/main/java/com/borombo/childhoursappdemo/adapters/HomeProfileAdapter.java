package com.borombo.childhoursappdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.activities.HistoryActivity;
import com.borombo.childhoursappdemo.holders.HomeProfileHolder;
import com.borombo.childhoursappdemo.model.Profile;

import io.realm.RealmResults;

/**
 * Created by Erwan on 12/11/2016.
 */

public class HomeProfileAdapter extends RecyclerView.Adapter<HomeProfileHolder> {


    private RealmResults<Profile> profiles;

    public HomeProfileAdapter(RealmResults<Profile> profiles) {this.profiles = profiles;}

    @Override
    public HomeProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_profile_row , parent, false);
        return new HomeProfileHolder(profileView);
    }

    @Override
    public void onBindViewHolder(final HomeProfileHolder holder, int position) {
        final Profile profile = profiles.get(position);
        final Context context = holder.itemView.getContext();

        holder.updateUI(profile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HistoryActivity.class);
                intent.putExtra("PROFILE_ID",profile.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return profiles.size();}
}
