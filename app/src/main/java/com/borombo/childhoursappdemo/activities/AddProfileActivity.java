package com.borombo.childhoursappdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.Profile;

public class AddProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText phone = (EditText) findViewById(R.id.phone);

        Button valid = (Button) findViewById(R.id.valid);
        Button cancel = (Button) findViewById(R.id.cancel);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().length() >= 2 && phone.getText().length() >= 8){
                    Profile profile = new Profile(name.getText().toString(), phone.getText().toString());
                    // Ajout du profil en BD

                }else{
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.activity_add_profile), getText(R.string.notValidAdd), Snackbar.LENGTH_LONG)
                            .setAction("Ok", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });
                    snackbar.show();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
