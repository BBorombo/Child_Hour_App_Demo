package com.borombo.childhoursappdemo.holders;

import android.icu.util.Calendar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.Data.Constants;
import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;
import com.borombo.childhoursappdemo.model.Profile;

import io.realm.Realm;

/**
 * Created by Erwan on 12/11/2016.
 */

public class HomeProfileHolder extends RecyclerView.ViewHolder{

    private TextView profileName;
    private Button arrival;
    private Button departure;
    private Profile profile;

    private Realm realm;

    public HomeProfileHolder(View itemView) {
        super(itemView);

        realm = Realm.getDefaultInstance();

        this.profileName = (TextView) itemView.findViewById(R.id.porfileName);
        this.arrival= (Button) itemView.findViewById(R.id.arrivalButton);
        this.departure= (Button) itemView.findViewById(R.id.departureButton);
        this.departure.setEnabled(false);


        this.arrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
                departure.setEnabled(true);

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        profile.setPresent(true);

                        DailyTimeSheet dailyTimeSheet;
                        String day = Constants.SDF.format(Calendar.getInstance().getTime());
                        String dateTime[] = day.split("_");

                        dailyTimeSheet = profile.getDTSByDay(day);

                        if (dailyTimeSheet != null){
                            dailyTimeSheet.addComming(dateTime);
                        }else{
                            dailyTimeSheet = new DailyTimeSheet(dateTime);
                            profile.getTimeSheets().add(dailyTimeSheet);
                        }
                    }
                });


            }
        });

        this.departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (profile.isPresent()){
                    arrival.setEnabled(true);
                    view.setEnabled(false);

                    realm.executeTransaction(new Realm.Transaction() {
                         @Override
                         public void execute(Realm realm) {
                             profile.setPresent(false);

                             String day = Constants.SDF.format(Calendar.getInstance().getTime());
                             String dateTime[] = day.split("_");
                             DailyTimeSheet dts = profile.getDTSByDay(day);
                             if (dts != null){
                                 dts.getCommings().get(dts.getCommings().size() -1).setDeparture(dateTime[3], dateTime[4]);
                             }
                         }
                     });

                }
            }
        });
    }

    public void updateUI(Profile profile){
        profileName.setText(profile.getName());
        this.profile = profile;

        if (profile.isPresent()){
            arrival.setEnabled(false);
            departure.setEnabled(true);
        }else {
            arrival.setEnabled(true);
            departure.setEnabled(false);
        }
    }
}
