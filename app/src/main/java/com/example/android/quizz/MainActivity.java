package com.example.android.quizz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                default:
                    return IntroFragment.newInstance("intro");
                case 0:
                    return IntroFragment.newInstance("Intro");
                case 1:
                    return Question1Fragment.newInstance("question 1");
                case 2:
                    return Question2Fragment.newInstance("question 2");
                case 3:
                    return Question3Fragment.newInstance("question 3");
                case 4:
                    return Question4Fragment.newInstance("question 4");
                case 5:
                    return Question5Fragment.newInstance("question 5");
                case 6:
                    return Question6Fragment.newInstance("question 6");
                case 7:
                    return Question7Fragment.newInstance("question 7");
                case 8:
                    return ResultsFragment.newInstance("results");
            }
        }

        @Override
        public int getCount() {
            return 9;
        }
    }
}