package com.borombo.childhoursappdemo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.Profile;
import com.borombo.childhoursappdemo.singleton.FakeData;

/**
 * Created by Erwan on 15/11/2016.
 */

public class DeleteProfilHolder extends RecyclerView.ViewHolder{

    private TextView profileName;
    private int profileId;
    private Button deleteButton;


    public DeleteProfilHolder(View itemView) {
        super(itemView);

        this.profileName = (TextView) itemView.findViewById(R.id.porfileName);
        this.deleteButton = (Button) itemView.findViewById(R.id.deleteButton);
        this.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Suppression du profil
                FakeData.getInstance().removeById(profileId);
            }
        });
    }

    public void updateUI(Profile profile){
        profileName.setText(profile.getName());
        profileId = profile.getId();
    }
}
