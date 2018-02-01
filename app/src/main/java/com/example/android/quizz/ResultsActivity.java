package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    public static final String ARG_FROM_MAIN = "arg";
    String passedArg = "";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            passedArg = getIntent().getStringExtra(ARG_FROM_MAIN);

            /*TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
            if (passedArg!=null && resultsTextView!=null) {
                resultsTextView.setText(passedArg);
            }*/

            ViewPager pager = findViewById(R.id.viewPager);
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }

        private class MyPagerAdapter extends FragmentPagerAdapter {

            public MyPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int pos) {
                return ResultsFragment.newInstance(passedArg);
            }

            @Override
            public int getCount() {
                return 1;
            }
        }
}