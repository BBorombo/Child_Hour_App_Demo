package com.borombo.childhoursappdemo.holders;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.DeleteProfileAdapter;
import com.borombo.childhoursappdemo.model.Profile;
import com.borombo.childhoursappdemo.singleton.FakeData;

/**
 * Created by Erwan on 15/11/2016.
 */

public class DeleteProfilHolder extends RecyclerView.ViewHolder{

    private TextView profileName;
    private int profileId;
    private Button deleteButton;
    private int position;


    public DeleteProfilHolder(final DeleteProfileAdapter adapter, final View itemView) {
        super(itemView);

        this.profileName = (TextView) itemView.findViewById(R.id.porfileName);
        this.deleteButton = (Button) itemView.findViewById(R.id.deleteButton);
        this.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Suppression du profil
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle(view.getContext().getString(R.string.deleteProfileTitle));
                builder.setMessage(view.getContext().getString(R.string.deleteText, profileName.getText().toString()));

                builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });

                builder.setPositiveButton(R.string.valid, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FakeData.getInstance().removeById(profileId);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.show();

            }
        });
    }

    public void updateUI(Profile profile, int position){
        profileName.setText(profile.getName());
        profileId = profile.getId();
        this.position = position;
    }
}
