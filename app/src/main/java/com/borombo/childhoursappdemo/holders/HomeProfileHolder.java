package com.borombo.childhoursappdemo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.Profile;

/**
 * Created by Erwan on 12/11/2016.
 */

public class HomeProfileHolder extends RecyclerView.ViewHolder{

    private TextView profileName;

    public HomeProfileHolder(View itemView) {
        super(itemView);

        this.profileName = (TextView) itemView.findViewById(R.id.porfileName);
    }

    public void updateUI(Profile profile){
        profileName.setText(profile.getName());
    }
}
