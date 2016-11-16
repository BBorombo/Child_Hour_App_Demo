package com.borombo.childhoursappdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.holders.DeleteProfilHolder;
import com.borombo.childhoursappdemo.model.Profile;

import java.util.ArrayList;

/**
 * Created by Erwan on 15/11/2016.
 */

public class DeleteProfileAdapter extends RecyclerView.Adapter<DeleteProfilHolder>{

    private ArrayList<Profile> profiles;

    public DeleteProfileAdapter(ArrayList<Profile> profiles) {this.profiles = profiles;}


    @Override
    public DeleteProfilHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_profil_row, parent, false);
        return new DeleteProfilHolder(profileView);
    }

    @Override
    public void onBindViewHolder(DeleteProfilHolder holder, int position) {
        final Profile profile = profiles.get(position);
        holder.updateUI(profile);
    }

    @Override
    public int getItemCount() {return profiles.size();}

}
