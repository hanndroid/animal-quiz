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

        int number = 1;
        int numberTwo = 5;
        int result = (number + numberTwo);
        System.out.println(result);


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

    private void questionHasBeenAnswered(int position, boolean isCorrectAnswer) {
        int currentValue = areQuestionsAnswered[position];
        if (isCorrectAnswer) {
            areQuestionsAnswered[position] = currentValue + 1;
        } else {
            areQuestionsAnswered[position] = currentValue - 1;
        }

    }

    public void guessReptile(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        boolean questionNotAnswered = areQuestionsAnswered[0] == 0;

        switch (view.getId()) {
            case R.id.rb_q1alligator:
                if (checked) {
                    if (questionNotAnswered) {
                        // and now, since we HAVE answered the question, we set it to TRUE
                        questionHasBeenAnswered(0, true);
                        results++;
                    }
                }
        }
    }


    public void isLeopardOrCheetah(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        boolean questionNotAnswered = areQuestionsAnswered[1] == 0;
        switch (view.getId()) {
            case R.id.rb_q2leopard:
                if (checked) {
                    if (questionNotAnswered) {
                        questionHasBeenAnswered(1, true);
                        results++;
                    }
                }
        }
    }

    public void isPorpoiseOrDolphin(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        boolean questionNotAnswered = areQuestionsAnswered[2] == 0;
        switch (view.getId()) {
            case R.id.rb_q3dolphin:
                if (checked) {
                    if (questionNotAnswered) {
                        questionHasBeenAnswered(2, true);
                        results++;
                    }
                }
        }
    }

    public void isLlamaOrAlpaca(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        boolean questionNotAnswered = areQuestionsAnswered[3] == 0;
        switch (view.getId()) {
            case R.id.rb_q4alpacas:
                if (checked) {
                    if (questionNotAnswered) {
                        questionHasBeenAnswered(3, true);
                        results++;
                    }
                }

        }
    }

    public void isToadOrFrog(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.cb_q5toad:
                if (checked) {
                    if (areQuestionsAnswered[4] == 1) {
                        displayToastie("You know your fairy tales!");
                        results++;
                    }
                    questionHasBeenAnswered(4, true);
                }
                break;
            case R.id.cb_q5frog:
                if (checked) {
                    if (areQuestionsAnswered[4] == 2) {
                        results--;
                    }
                    questionHasBeenAnswered(4, false);
                }
                break;
            case R.id.cb_q5prince:
                if (checked) {
                    if (areQuestionsAnswered[4] == 1) {
                        displayToastie("You know your fairy tales!");
                        results++;
                    }
                    questionHasBeenAnswered(4, true);
                    break;
                }
        }

        ((CheckBox) view).setEnabled(false); // disable unchecking
    }

    public void lizardOrReptile(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.cb_q6salamander:
                if (checked) {
                    if (areQuestionsAnswered[5] == 1) {
                        results++;
                    }
                    questionHasBeenAnswered(5, true);
                }
                break;
            case R.id.cb_q6amphibian:
                if (checked) {
                    if (areQuestionsAnswered[5] == 1) {
                        results++;
                    }
                    questionHasBeenAnswered(5, true);
                }
                break;
            case R.id.cb_q6lizard:
                if (checked) {
                    if (areQuestionsAnswered[5] == 2) {
                        results--;
                    }
                    questionHasBeenAnswered(5, false);
                }
                break;
            case R.id.cb_q6reptile:
                if (checked) {
                    if (areQuestionsAnswered[5] == 2) {
                        results--;
                    }
                    questionHasBeenAnswered(5, false);
                }
                break;
        }

        ((CheckBox) view).setEnabled(false); // disable unchecking
    }


    public void sealOrSeaLion(View view) {
        EditText sealOrSeaLion = findViewById(R.id.et_q7seaOrSeaLion);
        String text = sealOrSeaLion.getText().toString().toLowerCase();

        if (text.equalsIgnoreCase("sea lion")) {
            if (areQuestionsAnswered[6] == 0) {
                results++;
                questionHasBeenAnswered(6, true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(sealOrSeaLion.getWindowToken(), 0);
            }
        }

        displayToastie("Your total score is:\n" + results);
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