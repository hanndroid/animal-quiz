package com.example.android.quizz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int results = 0;
    private boolean[] areQuestionsAnswered = new boolean[7];

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
        areQuestionsAnswered[position] = true;
    }

    public void guessReptile(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1alligator:
                if (checked) {
                    // if the question 1 has not yet been answered, update results
                    // !false == true           ( not false is true )
                    // !true == false           ( not true is false )

                    // false && false == false  ( false and false is false )
                    // false && true == false   ( false and true is false )
                    // true && false == false   ( true and false is false )
                    // true && true == true     ( true and true is true )

                    // false || false == false  ( false or false is false )
                    // false || true == true    ( false or true is true )
                    // true || false == true    ( true or false is true )
                    // true || true == true     ( true or true is true )

                    // Q1 = areQuestionsAnswered[0]
                    // Q2 = areQuestionsAnswered[1]
                    // Q3 = areQuestionsAnswered[2]
                    // Q4 = areQuestionsAnswered[3]
                    // ...

                    // by default Q1 is false, i.e., not answered
                    if (!areQuestionsAnswered[0]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q1, we set it to TRUE
                        questionHasBeenAnswered(0);
                    }
                }
                break;
            case R.id.q1crocodile:
                if (checked) {
                    displayToastie("This is not a crocodile");
                    questionHasBeenAnswered(0);
                }
                break;
            case R.id.q1gharial:
                if (checked) {
                    displayToastie("This is not a gharial");
                    questionHasBeenAnswered(0);
                }
                break;
            case R.id.q1caiman:
                if (checked) {
                    displayToastie("This is not a caiman");
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
                    if (!areQuestionsAnswered[1]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q2, we set it to TRUE
                        questionHasBeenAnswered(1);

                    }
                }
                break;
            case R.id.q2Cheetah:
                if (checked) {
                    displayToastie("This is not a cheetah");
                    questionHasBeenAnswered(1);
                }
                break;
            case R.id.q2Jaguar:
                if (checked) {
                    displayToastie("This is not a cheetah");
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
                    if (!areQuestionsAnswered[2]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q3, we set it to TRUE
                        questionHasBeenAnswered(2);

                    }
                }
                break;
            case R.id.q3porpoise:
                if (checked) {
                    displayToastie("This is not a porpoise");
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
                    if (!areQuestionsAnswered[3]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q4, we set it to TRUE
                        questionHasBeenAnswered(3);
                    }

                }
                break;
            case R.id.q4llamas:
                if (checked) {
                    displayToastie("These are not llamas");
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
                    if (!areQuestionsAnswered[4]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q5, we set it to TRUE
                        questionHasBeenAnswered(4);
                    }
                }
                break;
            case R.id.q5frog:
                if (checked) {
                    displayToastie("This is not a Toad");
                    questionHasBeenAnswered(4);
                }
                break;
            case R.id.q5prince:
                if (checked) {
                    results++;
                    displayToastie("+ 1 point for knowing your fairy tales! \uD83D\uDC4F");
                    questionHasBeenAnswered(4);
                }
                break;
        }
    }

    public void lizardOrReptile(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.q6salamander:
                if (checked) {
                    if (!areQuestionsAnswered[4]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q5, we set it to TRUE
                        questionHasBeenAnswered(4);
                    }
                }
                break;
            case R.id.q6amphibian:
                if (checked) {
                    if (!areQuestionsAnswered[4]) {
                        results++;
                        displayToastie("Correct! Score updated to: " + results);
                        // and now, since we HAVE answered Q5, we set it to TRUE
                        questionHasBeenAnswered(4);
                    }
                }
                break;

            case R.id.q6lizard:
                if (checked) {
                    displayToastie("This is not a lizard");
                    questionHasBeenAnswered(5);
                }
                break;
            case R.id.q6reptile:
                if (checked) {
                    displayToastie("This is not a reptile");
                    questionHasBeenAnswered(5);
                }
                break;

            /*if(R.id.q6amphibian.isChecked() && R.id.q6salamander.isChecked()){
                results = results+2;*/
        }
    }


    public void sealOrSeaLion(View v) {
        EditText sealOrSeaLion = findViewById(R.id.q7seaOrSeaLion);
        String text = sealOrSeaLion.getText().toString().toLowerCase();

        if (text.contains("sea") && text.contains("lion")) {
            if (!areQuestionsAnswered[6]) {
                results++;
                displayToastie("Correct! Score updated to: " + results);
                // and now, since we HAVE answered Q7, we set it to TRUE
                questionHasBeenAnswered(6);
                questionHasBeenAnswered(6);
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
                    return Question1Fragment.newInstance(results, areQuestionsAnswered);
                case 2:
                    return Question2Fragment.newInstance(results, areQuestionsAnswered);
                case 3:
                    return Question3Fragment.newInstance(results, areQuestionsAnswered);
                case 4:
                    return Question4Fragment.newInstance(results, areQuestionsAnswered);
                case 5:
                    return Question5Fragment.newInstance(results, areQuestionsAnswered);
                case 6:
                    return Question6Fragment.newInstance(results, areQuestionsAnswered);
                case 7:
                    return Question7Fragment.newInstance(results, areQuestionsAnswered);
            }
        }

        @Override
        public int getCount() {
            return 8;
        }
    }

}