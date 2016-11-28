package com.borombo.childhoursappdemo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.activities.EditHistoryActivity;
import com.borombo.childhoursappdemo.adapters.DailyHistoryAdapter;
import com.borombo.childhoursappdemo.model.Profile;
import com.borombo.childhoursappdemo.singleton.FakeData;

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

    private Button modify;

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
        modify = (Button) view.findViewById(R.id.modify);
        dayDate = (TextView) view.findViewById(R.id.dayDate);
        totalDay = (TextView) view.findViewById(R.id.totalDay);

        profileName.setText(profile.getName());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        DailyHistoryAdapter adapter;

        adapter = new DailyHistoryAdapter(profile.getTimeSheets().get(0).getCommings());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditHistoryActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return view;

    }

}
