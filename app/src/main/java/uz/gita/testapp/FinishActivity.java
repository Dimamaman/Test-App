package uz.gita.testapp;

import static uz.gita.testapp.R.drawable.correct_bg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import uz.gita.testapp.controller.AppController;
import uz.gita.testapp.model.Answer;
import uz.gita.testapp.sharedpref.SharedPref;

public class FinishActivity extends AppCompatActivity {
    private SharedPref sharedPref;
    private AppController appController;
    final String NUMBERS = "numbers";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        appController = AppController.getInstance();
        sharedPref = SharedPref.getInstance();
        AppCompatTextView skipCount = findViewById(R.id.tv_skip_count);
        AppCompatTextView correctCount = findViewById(R.id.tv_correct_count);
        AppCompatTextView incorrectCount = findViewById(R.id.tv_wrong_count);
        AppCompatImageView finishButtonBack = findViewById(R.id.finish_button_back);

        finishButtonBack.setOnClickListener(view -> {
            finish();
        });


        skipCount.setText( "" + appController.getSkipCount());
        correctCount.setText("" + appController.getCorrectAnswerCount());
        incorrectCount.setText("" + appController.getWrongAnswerCount());
        sharedPref.setCurrentPosition(0);

        List<Answer> newList = appController.correctAnswerByPosition;
        LinearLayoutCompat container = findViewById(R.id.container);


        for (int i = 0; i < newList.size(); i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.item_question,null);

            AppCompatButton questionNumber = view.findViewById(R.id.question_number);

//            view.setTag(i);

            questionNumber.setText("Question " + (newList.get(i).getAnswerByPosition() + 1));

            if (newList.get(i).getAnswer() == 1) {
                questionNumber.setBackgroundResource(R.color.correct_answer);
            } else if (newList.get(i).getAnswer() == 0){
                questionNumber.setBackgroundResource(R.color.wrong_answer);
            } else if (newList.get(i).getAnswer() == 2){
                questionNumber.setBackgroundResource(R.color.skip_answer);
            }

            container.addView(view);

            int finalI = i;

            container.getChildAt(i).findViewById(R.id.question_number).setOnClickListener(view1 -> {
                Intent intent = new Intent(FinishActivity.this,QuestionReviewActivity.class);

                intent.putExtra(NUMBERS,finalI);

                startActivity(intent);
            });
        }
    }

    @Override
    protected void onPause() {
        appController.correctAnswerByPosition.clear();
        appController.setCurrentPosition(0);
        appController.setCorrectAnswerCount(0);
        appController.setWrongAnswerCount(0);
        super.onPause();
    }
}