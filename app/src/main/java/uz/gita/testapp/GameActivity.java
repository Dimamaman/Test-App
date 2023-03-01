package uz.gita.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import uz.gita.testapp.controller.AppController;
import uz.gita.testapp.model.Answer;
import uz.gita.testapp.model.TestData;
import uz.gita.testapp.sharedpref.SharedPref;

public class GameActivity extends AppCompatActivity {
    private List<RadioButton> radioButtons;
    private List<AppCompatTextView> variants;

    private AppCompatTextView questionText;
    private AppCompatTextView currentPosition;

    private AppCompatButton skipButton;
    private AppCompatButton nextButton;
    private AppController appController;
    private SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        appController = AppController.getInstance();
        sharedPref = SharedPref.getInstance();

        loadViews();
        describeTestData(appController.getNextData());

        findViewById(R.id.buttonBack).setOnClickListener(view -> {
            finish();
        });
    }

    private void loadViews() {
        questionText = findViewById(R.id.textQuestion);
        currentPosition = findViewById(R.id.textCurrentPosition);

        radioButtons = new ArrayList<>(4);
        radioButtons.add(findViewById(R.id.radio1));
        radioButtons.add(findViewById(R.id.radio2));
        radioButtons.add(findViewById(R.id.radio3));
        radioButtons.add(findViewById(R.id.radio4));


        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.text1));
        variants.add(findViewById(R.id.text2));
        variants.add(findViewById(R.id.text3));
        variants.add(findViewById(R.id.text4));

        skipButton = findViewById(R.id.buttonSkip);
        nextButton = findViewById(R.id.buttonNext);

        skipButton.setOnClickListener(view -> {
            appController.correctAnswerByPosition.add(new Answer(2, appController.getCurrentPosition() - 1));;
            checkData();
        });

        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).setOnCheckedChangeListener((compoundButton, isChecked) -> {
                if (!isChecked) return;
                clearOldSelect();
                compoundButton.setChecked(true);
                stateNextButton(true);
            });
        }
    }

    private void describeTestData(TestData testData) {
        currentPosition.setText((appController.getCurrentPosition()) + "/" + appController.getMAX_COUNT());

        questionText.setText(testData.getQuestion());

        variants.get(0).setText(testData.getVariant1());
        variants.get(1).setText(testData.getVariant2());
        variants.get(2).setText(testData.getVariant3());
        variants.get(3).setText(testData.getVariant4());
        clearOldSelect();

    }

    private void clearOldSelect() {
        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).setChecked(false);
        }
    }

    private void stateNextButton(boolean state) {
        nextButton.setEnabled(state);
        nextButton.setOnClickListener(view -> {
            appController.check(getUserAnswer());
            checkData();
        });
    }

    private void checkData() {
        if (appController.isLastQuestion()) {
            describeTestData(appController.getNextData());
            nextButton.setEnabled(false);
        } else {
            startActivity(new Intent(GameActivity.this, FinishActivity.class));
            finish();
        }
    }

    private String getUserAnswer() {
        int position = 0;
        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).isChecked()) {
                position = i;
            }
        }
        return variants.get(position).getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*if (appController.getCurrentPosition() == 4) {
            appController.setCurrentPosition(sharedPref.getCurrentPosition() + 1);
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPref.setCurrentPosition(appController.getCurrentPosition() - 1);
    }
}














