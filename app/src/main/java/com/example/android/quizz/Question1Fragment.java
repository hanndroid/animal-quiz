package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Question1Fragment extends Fragment {

    public static Question1Fragment newInstance(int results) {
        results++;

        Question1Fragment f = new Question1Fragment();
        Bundle b = new Bundle();
        b.putInt("results", results);
        f.setArguments(b);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_1, container, false);

        TextView tv = v.findViewById(R.id.tvFragSecond);
        tv.setText(getArguments().getString("msg"));

        int results = getArguments().getInt("results");
        return v;
    }

}