package com.example.android.quizz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ARG_FROM_MAIN = "arg";
    private int results = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


    }

    private void displayToastie(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void guessReptile(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1alligator:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q1crocodile:
                if (checked) {
                    displayToastie("This is not a crocodile");
                }
                break;
            case R.id.q1gharial:
                if (checked) {
                    displayToastie("This is not a gharial");
                }
                break;
            case R.id.q1caiman:
                if (checked) {
                    displayToastie("This is not a caiman");
                }
                break;
        }
    }

    public void isLeopardOrCheetah(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q2leopard:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q2Cheetah:
                if (checked) {
                    displayToastie("This is not a cheetah");
                }
                break;
            case R.id.q2Jaguar:
                if (checked) {
                    displayToastie("This is not a cheetah");
                }
                break;

        }
    }

    public void isPorpoiseOrDolphin(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q3dolphin:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q3porpoise:
                if (checked) {
                    displayToastie("This is not a porpoise");
                }
                break;
        }
    }

    public void isLlamaOrAlpaca(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.q4alpacas:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q4llamas:
                if (checked) {
                    displayToastie("These are not llamas");
                }
                break;
        }
    }

    public void isToadOrFrog(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.q5toad:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q5frog:
                if (checked) {
                    displayToastie("This is not a Toad");
                }
                break;
            case R.id.q5prince:
                if (checked) {
                    displayToastie("+ 1 point for knowing your fairy tales! \uD83D\uDC4F");
                }
                break;
        }
    }

    public void lizardOrReptile(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.q6salamander:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;
            case R.id.q6amphibian:
                if (checked) {
                    results++;
                    displayToastie("Correct! Score updated to: " + results);
                }
                break;

            case R.id.q6lizard:
                if (checked) {
                    displayToastie("This is not a lizard");
                }
                break;
            case R.id.q6reptile:
                if (checked) {
                    displayToastie("This is not a reptile");
                }
                break;

            /*if(R.id.q6amphibian.isChecked() && R.id.q6salamander.isChecked()){
                results = results+2;*/
            }
        }
    

    public void sealOrSeaLion(View v) {
        EditText sealOrSeaLion = findViewById(R.id.q7seaOrSeaLion);
        String text = sealOrSeaLion.getText().toString().toLowerCase();

        if (text.contains("sea") && text.contains("lion")) { /*results ++;*/
        } else {
        }
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

}