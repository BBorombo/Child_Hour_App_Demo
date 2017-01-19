package com.borombo.childhoursappdemo.holders;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
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
import com.borombo.childhoursappdemo.model.Time;

import io.realm.Realm;

/**
 * Created by Erwan on 28/11/2016.
 */

public class DailyHistoryHolder extends RecyclerView.ViewHolder {

    private TextView arrivalTime;
    private TextView derpatureTime;
    private Button modifyComming;
    private HistoryActivity activity;

    private static android.support.v4.app.FragmentManager fragmentManager;

    public DailyHistoryHolder(View itemView) {
        super(itemView);

        activity = (HistoryActivity) itemView.getContext();
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
                    public void onClick(final DialogInterface dialogInterface, int i) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(final Realm realm) {
                                final Time t = realm.createObject(Time.class);
                                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker timePicker, final int i, final int i1) {
                                        Log.d("Nouveau Arrivée ",String.valueOf(i) + "h" + String.valueOf(i1));
                                        realm.executeTransaction(new Realm.Transaction() {
                                            @Override
                                            public void execute(Realm realm) {
                                                t.setHours(i);
                                                t.setMinutes(i1);
                                                comming.setArrival(t);
                                            }
                                        });
                                        arrivalTime.setText(t.toString());
                                        setSnackUpdate();
                                    }
                                }, comming.getArrival().getHours(), comming.getArrival().getMinutes(), true);
                                timePickerDialog.show();
                            }
                    });
                    }
                });

                if (! derpatureTime.getText().equals(" ND ")){
                    builder.setPositiveButton(R.string.departure_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Realm realm = Realm.getDefaultInstance();
                            realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(final Realm realm) {
                                final Time t = realm.createObject(Time.class);
                                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker timePicker, final int i, final int i1) {
                                        Log.d("Nouveau Départ ",String.valueOf(i) + "h" + String.valueOf(i1));
                                        realm.executeTransaction(new Realm.Transaction() {
                                            @Override
                                            public void execute(Realm realm) {
                                                t.setHours(i);
                                                t.setMinutes(i1);
                                                comming.setDeparture(t);
                                            }
                                        });
                                        derpatureTime.setText(t.toString());
                                        setSnackUpdate();
                                    }
                                }, comming.getDeparture().getHours(), comming.getDeparture().getMinutes(), true);
                                timePickerDialog.show();
                            }
                        });
                        }
                    });
                }

                builder.show();
            }
        });
    }

    public void setSnackUpdate(){
        Snackbar snackbar = Snackbar.make(activity.findViewById(R.id.activity_history) , activity.getText(R.string.refreshText), Snackbar.LENGTH_LONG)
                .setAction(activity.getText(R.string.ok), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.refreshData();
                    }
                });

        snackbar.setDuration(5000);

        snackbar.show();
    }
}
