package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Question4Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_4, container, false);

        TextView tv = v.findViewById(R.id.tvFragSecond);
        tv.setText(getArguments().getString("msg"));

        int results = getArguments().getInt("results");
        System.out.println("results = " + results);

        return v;
    }

    public static Question4Fragment newInstance(int results) {
        results++;
        System.out.println("results: " + results);

        Question4Fragment f = new Question4Fragment();
        Bundle b = new Bundle();
        b.putInt("results", results);

        f.setArguments(b);

        return f;
    }

}
