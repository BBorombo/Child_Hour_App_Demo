package com.borombo.childhoursappdemo.holders;

import android.icu.util.Calendar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.Data.Constants;
import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;
import com.borombo.childhoursappdemo.model.Profile;

/**
 * Created by Erwan on 12/11/2016.
 */

public class HomeProfileHolder extends RecyclerView.ViewHolder{

    private TextView profileName;
    private Button arrival;
    private Button departure;
    private Profile profile;




    public HomeProfileHolder(View itemView) {
        super(itemView);

        this.profileName = (TextView) itemView.findViewById(R.id.porfileName);
        this.arrival= (Button) itemView.findViewById(R.id.arrivalButton);
        this.departure= (Button) itemView.findViewById(R.id.departureButton);
        this.departure.setEnabled(false);

        this.arrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
                departure.setEnabled(true);

                String cal = Constants.SDF.format(Calendar.getInstance().getTime());
                String dateTime[] = cal.split("_");
                DailyTimeSheet dailyTimeSheet = new DailyTimeSheet(dateTime);
                profile.setPresent(true);
                profile.getTimeSheets().add(dailyTimeSheet);
                Log.d("Date Time", dateTime[0] + dateTime[1] + dateTime[2] + " " + dateTime[3] + dateTime[4]);
                Log.d("Profil", profile.getName());
                Log.d("Arrival profil", profile.getTimeSheets().get(0).getCommings().get(0).getArrival().toString());
            }
        });

        this.departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (profile.isPresent()){
                    arrival.setEnabled(true);
                    view.setEnabled(false);
                    profile.setPresent(false);
                    String cal = Constants.SDF.format(Calendar.getInstance().getTime());
                    String dateTime[] = cal.split("_");
                    DailyTimeSheet dts = profile.getTimeSheets().get(profile.getTimeSheets().size() -1);
                    dts.getCommings().get(dts.getCommings().size() -1).setDeparture(dateTime[3], dateTime[4]);
                    Log.d("Profil", profile.getName());
                    Log.d("Departure profil", profile.getTimeSheets().get(0).getCommings().get(0).getDeparture().toString());
                    Log.d("Time profil", profile.getTimeSheets().get(0).getCommings().get(0).getTime().toString());
                }
            }
        });
    }

    public void updateUI(Profile profile){
        profileName.setText(profile.getName());
        this.profile = profile;
    }
}
