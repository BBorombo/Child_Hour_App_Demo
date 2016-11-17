package com.borombo.childhoursappdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.adapters.MensualHistoryAdapter;
import com.borombo.childhoursappdemo.model.DailyTimeSheet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MensualHistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public MensualHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DailyHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MensualHistoryFragment newInstance(String param1, String param2) {
        MensualHistoryFragment fragment = new MensualHistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mensual_history, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        MensualHistoryAdapter adapter;

        ArrayList<DailyTimeSheet> dailyTimeSheets = new ArrayList<>();

        dailyTimeSheets.add(new DailyTimeSheet());

        adapter = new MensualHistoryAdapter(dailyTimeSheets);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }

}
