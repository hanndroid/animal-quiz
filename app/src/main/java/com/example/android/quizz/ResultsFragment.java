package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultsFragment extends Fragment {

    private static Bundle arg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_results, container, false);
        TextView resultsTextView = v.findViewById(R.id.resultsTextView);

        if (resultsTextView!=null) {
            // 1) which questions have been answered
            // get int array containing info on which questions were answered
            int[] areQuestionsAnswered = arg.getIntArray("areQuestionsAnswered");
            // iterate over each and print out true/false
            for (int i = 0; i < areQuestionsAnswered.length; i++) {
                System.out.println("Was Q" + (i + 1) + " answered? " + areQuestionsAnswered[i]);
            }

            // 2) results
            int results = arg.getInt("results");
            resultsTextView.setText(String.valueOf(results));
        }
        return v;
    }

    public static ResultsFragment newInstance(Bundle passedArg) {
        arg = passedArg;
        return new ResultsFragment();
    }

}
