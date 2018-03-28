package com.example.android.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.android.quizz.ResultsActivity.ARG_FROM_MAIN;

public class Question7Fragment extends Fragment {

    public static Question7Fragment newInstance() {
        return new Question7Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_7, container, false);

        Button submitAnswersBtn = v.findViewById(R.id.bt_submitAnswers);
        submitAnswersBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // we want make sure we get results ONLY after the last fragment actually updated stuff
                final int results = ((MainActivity) getActivity()).getResults();
                final int[] areQuestionsAnswered = ((MainActivity) getActivity()).getAreQuestionsAnswered();

                // ResultsActivity.class is our second activity
                // we want to send results from MainActivity to ResultsActivity
                Intent intent = new Intent(view.getContext(), ResultsActivity.class);
                Bundle values = new Bundle();
                values.putInt("results", results);
                values.putIntArray("areQuestionsAnswered", areQuestionsAnswered);
                intent.putExtra(ARG_FROM_MAIN, values);

                startActivity(intent);
                startActivityForResult(intent, 0);
            }

        });

        return v;
    }

}
