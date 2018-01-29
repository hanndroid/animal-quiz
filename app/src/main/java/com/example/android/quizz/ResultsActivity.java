package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ViewPager pager = findViewById(R.id.viewPager);
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
                        return IntroFragment.newInstance();
                    case 0:
                        return ResultsFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        }
}