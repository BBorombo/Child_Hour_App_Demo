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
import com.borombo.childhoursappdemo.adapters.DailyHistoryAdapter;
import com.borombo.childhoursappdemo.model.Comming;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;
import com.borombo.childhoursappdemo.model.Profile;
import com.borombo.childhoursappdemo.singleton.FakeData;

import io.realm.RealmList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyHistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PROFILE_ID = "PROFILE_ID";

    private int profileId;

    private Profile profile;
    private TextView profileName;
    private DailyTimeSheet dailyProfileDts;

    private TextView dayDate;
    private TextView totalDay;

    public DailyHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param profileId Profile.
     * @return A new instance of fragment DailyHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyHistoryFragment newInstance(int profileId) {
        DailyHistoryFragment fragment = new DailyHistoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PROFILE_ID, profileId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileId = getArguments().getInt(ARG_PROFILE_ID);
            profile = FakeData.getInstance().getById(profileId);
            Log.d("Profile name", profile.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_history, container, false);
        profileName = (TextView) view.findViewById(R.id.profileName);
        dayDate = (TextView) view.findViewById(R.id.dayDate);
        totalDay = (TextView) view.findViewById(R.id.totalDay);

        String currentDay = Constants.DAY_SDF.format(Calendar.getInstance());
        String day = Constants.SDF.format(Calendar.getInstance());

        dayDate.setText(Constants.formatDayDate(currentDay));
        profileName.setText(profile.getName());

        DailyHistoryAdapter adapter = new DailyHistoryAdapter(new RealmList<Comming>());

        dailyProfileDts = profile.getDTSByDay(day);
        if (dailyProfileDts != null){
            Log.d("DTS", dailyProfileDts.getDay() + dailyProfileDts.getMonth() + dailyProfileDts.getYears());
            totalDay.setText(dailyProfileDts.getTotalTime().toString());
            adapter = new DailyHistoryAdapter(dailyProfileDts.getCommings());
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        return view;

    }

}
