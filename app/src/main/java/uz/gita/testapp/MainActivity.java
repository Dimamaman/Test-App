package uz.gita.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import uz.gita.testapp.controller.AppController;
import uz.gita.testapp.databinding.ActivityMainBinding;
import uz.gita.testapp.sharedpref.SharedPref;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppController appController;
    private SharedPref sharedPref;
    private AppCompatButton newGame;
    private AppCompatButton continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        appController = AppController.getInstance();
        sharedPref = SharedPref.getInstance();

        newGame = findViewById(R.id.newGame);
        continueButton = findViewById(R.id.continueBtn);

        continueButton.setOnClickListener(view -> {
            if (sharedPref.getCurrentPosition() == 19) {
                appController.setCurrentPosition(0);
            } else {
                appController.setCurrentPosition(sharedPref.getCurrentPosition());
            }

            startActivity(new Intent(this,GameActivity.class));
        });

        newGame.setOnClickListener(view -> {
            sharedPref.setCurrentPosition(0);
            appController.setCurrentPosition(0);
            startActivity(new Intent(this,GameActivity.class));
        });

        binding.exitBtn.setOnClickListener(view -> finish());
        findViewById(R.id.infoBtn).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,InfoActivity.class));
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}