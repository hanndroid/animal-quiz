package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Question5Fragment extends Fragment {

    public static Question5Fragment newInstance(int results, boolean[] areQuestionsAnswered) {

        Question5Fragment f = new Question5Fragment();
        Bundle b = new Bundle();
        b.putInt("results", results);
        f.setArguments(b);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_question_5, container, false);
        return v;
    }

}
