package com.borombo.childhoursappdemo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;

/**
 * Created by Erwan on 17/11/2016.
 */

public class MensualHistoryHolder extends RecyclerView.ViewHolder {

    private TextView dayDate;
    private TextView firstArrival;
    private TextView lastDeparture;
    private TextView totalTime;

    public MensualHistoryHolder(View itemView) {
        super(itemView);

        this.dayDate = (TextView) itemView.findViewById(R.id.dayDate);
        this.firstArrival = (TextView) itemView.findViewById(R.id.firstArrival);
        this.lastDeparture = (TextView) itemView.findViewById(R.id.lastDeparture);
        this.totalTime= (TextView) itemView.findViewById(R.id.totalHour);
    }

    public void updateUI(DailyTimeSheet dailyTimeSheet){

    }

}
