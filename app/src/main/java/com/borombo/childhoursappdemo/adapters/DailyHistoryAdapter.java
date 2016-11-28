package com.borombo.childhoursappdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.holders.DailyHistoryHolder;
import com.borombo.childhoursappdemo.model.Comming;

import io.realm.RealmList;

/**
 * Created by Erwan on 28/11/2016.
 */

public class DailyHistoryAdapter extends RecyclerView.Adapter<DailyHistoryHolder> {

    private RealmList<Comming> commings;

    public DailyHistoryAdapter(RealmList<Comming> commings) { this.commings = commings; }

    @Override
    public DailyHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mensualHistoryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_history_row , parent, false);
        return new DailyHistoryHolder(mensualHistoryView);
    }

    @Override
    public void onBindViewHolder(DailyHistoryHolder holder, int position) {
        final Comming comming = commings.get(position);
        holder.updateUI(comming);

    }

    @Override
    public int getItemCount() { return commings.size(); }

}
