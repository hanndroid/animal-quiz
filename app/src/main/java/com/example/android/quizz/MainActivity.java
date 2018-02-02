package com.example.android.quizz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int results = 0;
    private int[] areQuestionsAnswered = new int[7];

    public int getResults() {
        return results;
    }

    public int[] getAreQuestionsAnswered() {
        return areQuestionsAnswered;
    }

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

    private void questionHasBeenAnswered(int position) {
        areQuestionsAnswered[position] = areQuestionsAnswered[position] + 1;
    }

    public void guessReptile(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1alligator:
                if (checked) {
                    // by default Q1 is false, i.e., not answered
                    if (areQuestionsAnswered[0] == 0) {
                        results++;
                        // and now, since we HAVE answered Q1, we set it to TRUE
                        questionHasBeenAnswered(0);
                    }
                }
                break;
            case R.id.q1crocodile:
                if (checked) {
                    questionHasBeenAnswered(0);
                }
                break;
            case R.id.q1gharial:
                if (checked) {
                    questionHasBeenAnswered(0);
                }
                break;
            case R.id.q1caiman:
                if (checked) {
                    questionHasBeenAnswered(0);
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
                    if (areQuestionsAnswered[1] == 0) {
                        // and now, since we HAVE answered Q2, we set it to TRUE
                        questionHasBeenAnswered(1);
                        results++;
                    }
                }
                break;
            case R.id.q2Cheetah:
                if (checked) {
                    questionHasBeenAnswered(1);
                }
                break;
            case R.id.q2Jaguar:
                if (checked) {
                    questionHasBeenAnswered(1);
                }
                break;

        }
    }

    public void isPorpoiseOrDolphin(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q3dolphin:
                if (checked) {
                    if (areQuestionsAnswered[2] == 0) {
                        results++;
                        // and now, since we HAVE answered Q3, we set it to TRUE
                        questionHasBeenAnswered(2);
                    }
                }
                break;
            case R.id.q3porpoise:
                if (checked) {
                    questionHasBeenAnswered(2);
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
                    if (areQuestionsAnswered[3] == 0) {
                        results++;
                        // and now, since we HAVE answered Q4, we set it to TRUE
                        questionHasBeenAnswered(3);
                    }
                }
                break;
            case R.id.q4llamas:
                if (checked) {
                    questionHasBeenAnswered(3);
                }
                break;
        }
    }

    public void isToadOrFrog(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.q5toad:
                if (checked) {
                    if (areQuestionsAnswered[4] == 0 || areQuestionsAnswered[4] == 1) {
                        // and now, since we HAVE answered Q5, we set it to TRUE
                        results++;
                        questionHasBeenAnswered(4);
                    }
                }
                break;
            case R.id.q5frog:
                if (checked) {
                    questionHasBeenAnswered(4);
                }
                break;
            case R.id.q5prince:
                if (checked) {
                    if (areQuestionsAnswered[4] == 0 || areQuestionsAnswered[4] == 1) {
                        // and now, since we HAVE answered Q4, we set it to TRUE
                        displayToastie("You know your fairy tales!");
                        results++;
                        questionHasBeenAnswered(4);
                    }
                    break;
                }
        }
    }

    public void lizardOrReptile(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.q6salamander:
                if (checked) {
                    if (areQuestionsAnswered[5] == 0 || areQuestionsAnswered[5] == 1) {
                        // and now, since we HAVE answered Q6, we set it to TRUE
                        results++;
                        questionHasBeenAnswered(5);
                    }
                }
                break;
            case R.id.q6amphibian:
                if (checked) {
                    if (areQuestionsAnswered[5] == 0 || areQuestionsAnswered[4] == 1) {
                        // and now, since we HAVE answered Q6, we set it to TRUE
                        results++;
                        questionHasBeenAnswered(5);
                    }
                }
                break;
            case R.id.q6lizard:
                if (checked) {
                    questionHasBeenAnswered(5);
                }
                break;
            case R.id.q6reptile:
                if (checked) {
                    questionHasBeenAnswered(5);
                }
                break;

        }
    }


    public void sealOrSeaLion(View view) {
        EditText sealOrSeaLion = findViewById(R.id.q7seaOrSeaLion);
        String text = sealOrSeaLion.getText().toString().toLowerCase();

        if (text.contains("sea") && text.contains("lion")) {
            if (areQuestionsAnswered[6] == 0) {
                results++;
                // and now, since we HAVE answered Q7, we set it to TRUE
                questionHasBeenAnswered(6);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(sealOrSeaLion.getWindowToken(), 0);
            }
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
                    return Question1Fragment.newInstance();
                case 2:
                    return Question2Fragment.newInstance();
                case 3:
                    return Question3Fragment.newInstance();
                case 4:
                    return Question4Fragment.newInstance();
                case 5:
                    return Question5Fragment.newInstance();
                case 6:
                    return Question6Fragment.newInstance();
                case 7:
                    return Question7Fragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 8;
        }
    }

}