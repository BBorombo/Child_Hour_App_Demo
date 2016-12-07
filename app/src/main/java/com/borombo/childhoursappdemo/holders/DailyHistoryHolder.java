package com.borombo.childhoursappdemo.holders;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.activities.HistoryActivity;
import com.borombo.childhoursappdemo.fragments.MensualHistoryFragment;
import com.borombo.childhoursappdemo.model.Comming;

/**
 * Created by Erwan on 28/11/2016.
 */

public class DailyHistoryHolder extends RecyclerView.ViewHolder {

    private TextView arrivalTime;
    private TextView derpatureTime;
    private Button modifyComming;

    private static android.support.v4.app.FragmentManager fragmentManager;

    public DailyHistoryHolder(View itemView) {
        super(itemView);

        HistoryActivity activity = (HistoryActivity) itemView.getContext();
        fragmentManager = activity.getSupportFragmentManager();

        this.arrivalTime = (TextView) itemView.findViewById(R.id.arrivalTime);
        this.derpatureTime = (TextView) itemView.findViewById(R.id.departureTime);
        this.modifyComming = (Button) itemView.findViewById(R.id.modifyComming);
    }

    public void updateUI(final Comming comming){
        this.arrivalTime.setText(comming.getArrival().toString());
        if (null != comming.getDeparture()){
            this.derpatureTime.setText(comming.getDeparture().toString());
        }

        modifyComming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle(view.getContext().getString(R.string.modify));
                builder.setMessage(view.getContext().getString(R.string.modifyText));

                builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tag = "android:switcher" + R.id.pager + ":" + 1;
                        MensualHistoryFragment f = (MensualHistoryFragment) fragmentManager.findFragmentByTag(tag);
                        if (f != null)
                            Log.d("Fragment ", f.toString());
                    }
                });

                builder.setNegativeButton(R.string.arrival_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                Log.d("Nouveau Arrivée ",String.valueOf(i) + "h" + String.valueOf(i1));
                                arrivalTime.setText(String.valueOf(i) + "h" + String.valueOf(i1));
                            }
                        }, comming.getArrival().getHours(), comming.getArrival().getMinutes(), true);
                        timePickerDialog.show();
                    }
                });

                if (! derpatureTime.getText().equals(" ND ")){
                    builder.setPositiveButton(R.string.departure_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                    Log.d("Nouveau Départ ",String.valueOf(i) + "h" + String.valueOf(i1));
                                }
                            }, comming.getDeparture().getHours(), comming.getDeparture().getMinutes(), true);
                            timePickerDialog.show();
                        }
                    });
                }

                builder.show();
            }
        });
    }
}
