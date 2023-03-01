package uz.gita.testapp;

import android.app.Application;

import uz.gita.testapp.sharedpref.SharedPref;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPref.init(this);
    }
}
