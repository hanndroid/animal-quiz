package com.example.android.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Question7Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_7, container, false);

        TextView tv = v.findViewById(R.id.tvFragSecond);
        tv.setText(getArguments().getString("msg"));

        Button submitAnswersBtn = v.findViewById(R.id.submit_answers);
        submitAnswersBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ResultsActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

        return v;
    }

    public static Question7Fragment newInstance(String text) {

        Question7Fragment f = new Question7Fragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
