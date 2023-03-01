package uz.gita.testapp.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private final String SHARED_PREF = "shared_pref";
    private final String CURRENT_POSITION = "current_position";

    private SharedPreferences sharedPreference;
    private SharedPreferences.Editor editor;

    private static SharedPref  instance;

    int currentPosition;

    public int getCurrentPosition() {
        return sharedPreference.getInt(CURRENT_POSITION,0);
    }

    public void setCurrentPosition(int currentPosition) {
        editor.putInt(CURRENT_POSITION,currentPosition).apply();
    }

    private SharedPref(Context context) {
        sharedPreference = context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new SharedPref(context);
        }
    }

    public static SharedPref getInstance() {
        return instance;
    }
}
