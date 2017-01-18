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

import io.realm.Realm;

/**
 * Created by Erwan on 15/11/2016.
 */

public class DeleteProfilHolder extends RecyclerView.ViewHolder{

    private TextView profileName;
    private int profileId;
    private Button deleteButton;

    public DeleteProfilHolder(final DeleteProfileAdapter adapter, final View itemView) {
        super(itemView);

        final Realm realm = Realm.getDefaultInstance();

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
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.where(Profile.class).findAll().get(profileId - 1).deleteFromRealm();
                            }
                        });
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.show();

            }
        });
    }

    public void updateUI(Profile profile){
        profileName.setText(profile.getName());
        profileId = profile.getId();
    }
}
