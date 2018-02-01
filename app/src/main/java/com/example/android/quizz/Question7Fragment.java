package com.example.android.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.quizz.ResultsActivity.ARG_FROM_MAIN;

public class Question7Fragment extends Fragment {

    public static Question7Fragment newInstance(int results, boolean[] areQuestionsAnswered) {

        Question7Fragment f = new Question7Fragment();
        Bundle b = new Bundle();
        b.putInt("results", results);
        b.putBooleanArray("areQuestionsAnswered", areQuestionsAnswered);
        f.setArguments(b);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_7, container, false);

        final int results = getArguments().getInt("results");
        final boolean[] areQuestionsAnswered = getArguments().getBooleanArray("areQuestionsAnswered");

        Button submitAnswersBtn = v.findViewById(R.id.submit_answers);
        submitAnswersBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // ResultsActivity.class is our second activity
                // we want to send results from MainActivity to ResultsActivity
                Intent intent = new Intent(view.getContext(), ResultsActivity.class);
                Bundle values = new Bundle();
                values.putInt("results", results);
                values.putBooleanArray("areQuestionsAnswered", areQuestionsAnswered);
                System.out.println("values = " + values);
                intent.putExtra(ARG_FROM_MAIN, values);
                startActivity(intent);
                startActivityForResult(intent, 0);
            }

        });

        return v;
    }

}
