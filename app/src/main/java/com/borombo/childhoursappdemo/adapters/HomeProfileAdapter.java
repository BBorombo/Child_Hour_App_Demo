package com.borombo.childhoursappdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.holders.HomeProfileHolder;
import com.borombo.childhoursappdemo.model.Profile;

import java.util.ArrayList;

/**
 * Created by Erwan on 12/11/2016.
 */

public class HomeProfileAdapter extends RecyclerView.Adapter<HomeProfileHolder> {


    private ArrayList<Profile> profiles;

    public HomeProfileAdapter(ArrayList<Profile> profiles) {this.profiles = profiles;}

    @Override
    public HomeProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_profile_row , parent, false);
        return new HomeProfileHolder(profileView);
    }

    @Override
    public void onBindViewHolder(HomeProfileHolder holder, int position) {
        final Profile profile = profiles.get(position);
        holder.updateUI(profile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {return profiles.size();}
}
