package com.example.android.quizz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int results = 0;

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
                case 1:
                    return Question1Fragment.newInstance(results);
                case 2:
                    return Question2Fragment.newInstance(results);
                case 3:
                    return Question3Fragment.newInstance(results);
                case 4:
                    return Question4Fragment.newInstance(results);
                case 5:
                    return Question5Fragment.newInstance(results);
                case 6:
                    return Question6Fragment.newInstance(results);
                case 7:
                    return Question7Fragment.newInstance(results);
            }
        }

        @Override
        public int getCount() {
            return 8;
        }
    }

    public void isAlligatorOrCrocodile(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1alligator:
                if (checked)
                    System.out.println("ALLI");
                break;
            case R.id.q1crocodile:
                if (checked)
                    System.out.println("Geoff");
                break;
        }
    }
}