package com.borombo.childhoursappdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.holders.MensualHistoryHolder;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;

import io.realm.RealmList;

/**
 * Created by Erwan on 17/11/2016.
 */

public class MensualHistoryAdapter extends RecyclerView.Adapter<MensualHistoryHolder>{

    private RealmList<DailyTimeSheet> dailyTimeSheets;

    public MensualHistoryAdapter(RealmList<DailyTimeSheet> dailyTimeSheets){this.dailyTimeSheets = dailyTimeSheets;}

    @Override
    public MensualHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mensualHistoryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mensual_history_row , parent, false);
        return new MensualHistoryHolder(mensualHistoryView);
    }

    @Override
    public void onBindViewHolder(MensualHistoryHolder holder, int position) {
        final DailyTimeSheet dailyTimeSheet = dailyTimeSheets.get(position);
        final Context context = holder.itemView.getContext();

        holder.updateUI(dailyTimeSheet);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {return dailyTimeSheets.size();}
}
