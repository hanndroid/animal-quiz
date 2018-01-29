package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
                    return IntroFragment.newInstance("");
                case 0:
                    return IntroFragment.newInstance("");
                case 1:
                    return Question1Fragment.newInstance("");
                case 2:
                    return Question2Fragment.newInstance("");
                case 3:
                    return Question3Fragment.newInstance("");
                case 4:
                    return Question4Fragment.newInstance("");
                case 5:
                    return Question5Fragment.newInstance("");
                case 6:
                    return Question6Fragment.newInstance("");
                case 7:
                    return Question7Fragment.newInstance("");
            }
        }

        @Override
        public int getCount() {
            return 9;
        }
    }
}