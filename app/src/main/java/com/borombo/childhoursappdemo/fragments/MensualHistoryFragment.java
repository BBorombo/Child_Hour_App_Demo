package com.borombo.childhoursappdemo.fragments;


import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.borombo.childhoursappdemo.Data.Constants;
import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.MensualHistoryAdapter;
import com.borombo.childhoursappdemo.model.Profile;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class MensualHistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PROFILE_ID = "profileId";

    private int profileId;
    private Profile profile;
    private TextView profileName;

    private TextView monthDate;
    private TextView totalMonth;

    private MensualHistoryAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private Realm realm;

    public MensualHistoryFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param profileId Parameter 1.
     * @return A new instance of fragment DailyHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MensualHistoryFragment newInstance(int profileId) {
        MensualHistoryFragment fragment = new MensualHistoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PROFILE_ID, profileId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        if (getArguments() != null) {
            profileId = getArguments().getInt(ARG_PROFILE_ID);
            profile = realm.where(Profile.class).equalTo("id", profileId).findFirst();
            Log.d("Profile name", profile.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mensual_history, container, false);

        profileName = (TextView) view.findViewById(R.id.profileName);
        monthDate = (TextView) view.findViewById(R.id.monthDate);
        totalMonth = (TextView) view.findViewById(R.id.totalMonth);

        String currentMonth = Constants.MONTH_SDF.format(Calendar.getInstance());
        String date = Constants.SDF.format(Calendar.getInstance());

        String total = profile.totalByMonth(date.split("_")[1], date.split("_")[2]);
        totalMonth.append(" " + total);

        monthDate.setText(Constants.formatMonthDate(currentMonth));
        profileName.setText(profile.getName());



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        adapter = new MensualHistoryAdapter(profile.getTimeSheets());

        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }

    public  void updateData(){
        adapter = new MensualHistoryAdapter(profile.getTimeSheets());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        Log.d("Update","OK");
    }

}
