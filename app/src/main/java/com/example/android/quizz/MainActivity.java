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

    public void guessReptile(View view) {
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
            case R.id.q1gharial:
                if (checked)
                    System.out.println("gharial");
                break;
            case R.id.q1caiman:
                if (checked)
                    System.out.println("caiman");
                break;
        }
    }

    public void isLeopardOrCheetah(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2leopard:
                if (checked)
                    System.out.println("leopard");
                break;
            case R.id.q2Cheetah:
                if (checked)
                    System.out.println("cheetah");
                break;
        }
    }

    public void isPorpoiseOrDolphin(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q3porpoise:
                if (checked)
                    System.out.println("porpoise");
                break;
            case R.id.q3dolphin:
                if (checked)
                    System.out.println("dolphin");
                break;
        }
    }

    public void isLlamaOrAlpaca(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q4llamas:
                if (checked)
                    System.out.println("llama");
                break;
            case R.id.q4alpacas:
                if (checked)
                    System.out.println("alpaca");
                break;
        }
    }

    public void isToadOrFrog(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q5toad:
                if (checked)
                    System.out.println("toad");
                break;
            case R.id.q5frog:
                if (checked)
                    System.out.println("frog");
                break;
            case R.id.q5prince:
                if (checked)
                    System.out.println("prince");
                break;
        }
    }
}