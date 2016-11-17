package com.borombo.childhoursappdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.borombo.childhoursappdemo.R;

public class EditHistoryActivity extends AppCompatActivity {

    private Button valid;
    private Button cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_history);

        valid = (Button) findViewById(R.id.valid);
        cancel = (Button) findViewById(R.id.cancel);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
