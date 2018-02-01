package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultsFragment extends Fragment {

    private static String arg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_results, container, false);

        TextView tv = v.findViewById(R.id.tvFragThird);
        tv.setText(getArguments().getString("msg"));

        TextView resultsTextView = (TextView) v.findViewById(R.id.resultsTextView);

        if (resultsTextView!=null) {
            resultsTextView.setText(arg);
        }

        return v;
    }

    public static ResultsFragment newInstance(String passedArg) {

        arg = passedArg;
        ResultsFragment f = new ResultsFragment();
        Bundle b = new Bundle();





        f.setArguments(b);

        return f;
    }

}
