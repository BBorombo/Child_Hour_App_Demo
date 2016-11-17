package com.borombo.childhoursappdemo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.borombo.childhoursappdemo.R;
import com.borombo.childhoursappdemo.activities.EditHistoryActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyHistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private Button modify;

    public DailyHistoryFragment() {
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
    public static DailyHistoryFragment newInstance(String param1, String param2) {
        DailyHistoryFragment fragment = new DailyHistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_daily_history, container, false);
        modify = (Button) view.findViewById(R.id.modify);

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
