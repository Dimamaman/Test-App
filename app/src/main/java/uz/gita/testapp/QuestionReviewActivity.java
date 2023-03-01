package uz.gita.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import uz.gita.testapp.controller.AppController;
import uz.gita.testapp.databinding.ActivityQuestionReviewBinding;
import uz.gita.testapp.model.TestData;

public class QuestionReviewActivity extends AppCompatActivity {
    private ActivityQuestionReviewBinding binding;
    private int a;
    private AppController appController;
    private List<TestData> list;

    private List<RadioButton> radioButtons;
    private List<AppCompatTextView> variants;

    private AppCompatTextView questionText;
    private AppCompatTextView currentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        appController = AppController.getInstance();

        list = appController.getList();

        a = getIntent().getIntExtra("numbers", 0);

        binding.qrButtonBack.setOnClickListener(view -> {
            finish();
        });

//        loadViews();
        loadData(a);
    }

    private void loadViews() {
        questionText = findViewById(R.id.textQuestion);
        currentPosition = findViewById(R.id.textCurrentPosition);

        radioButtons = new ArrayList<>(4);
        radioButtons.add(findViewById(R.id.question_review_radio1));
        radioButtons.add(findViewById(R.id.question_review_radio2));
        radioButtons.add(findViewById(R.id.question_review_radio3));
        radioButtons.add(findViewById(R.id.question_review_radio4));


        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.text1));
        variants.add(findViewById(R.id.text2));
        variants.add(findViewById(R.id.text3));
        variants.add(findViewById(R.id.text4));
    }

    @SuppressLint("SetTextI18n")
    private void loadData(int number) {
        switch (number) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19: {
                load(number);
                break;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void load(int a) {
        binding.textQuestion.setText("" + list.get(a).getQuestion());
        binding.textCurrentPosition.setText("" + (a + 1) + "/" + list.size());

        binding.text1.setText("" + list.get(a).getVariant1());
        binding.text2.setText("" + list.get(a).getVariant2());
        binding.text3.setText("" + list.get(a).getVariant3());
        binding.text4.setText("" + list.get(a).getVariant4());

        binding.correctAnswer.setText(list.get(a).getAnswer());

    }
}