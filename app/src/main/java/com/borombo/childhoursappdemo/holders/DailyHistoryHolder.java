package com.borombo.childhoursappdemo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.model.Comming;

/**
 * Created by Erwan on 28/11/2016.
 */

public class DailyHistoryHolder extends RecyclerView.ViewHolder {

    private TextView arrivalTime;
    private TextView derpatureTime;

    public DailyHistoryHolder(View itemView) {
        super(itemView);

        this.arrivalTime= (TextView) itemView.findViewById(R.id.arrivalTime);
        this.derpatureTime= (TextView) itemView.findViewById(R.id.departureTime);
    }

    public void updateUI(Comming comming){
        this.arrivalTime.setText(comming.getArrival().toString());
        if (null != comming.getDeparture()){
            this.derpatureTime.setText(comming.getDeparture().toString());
        }
    }
}
