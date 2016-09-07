package com.sanfrancisco.robotfragment;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesMgr {
                                            // Sharedpreferences filename
    private static final String PREF_NAME = "Robot001-introduction";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    SharedPreferences spref1;
    SharedPreferences.Editor speditor1;
    Context  context1;
                        // shared pref mode of privacy
    int PRIVATE_MODE = 0;

    public SharedPreferencesMgr(Context context001) {
        this.context1 = context001;
        spref1 = context1.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        speditor1 = spref1.edit();
    }

    public boolean isFirstTimeLaunch() {
        return spref1.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime1) {
        speditor1.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime1);
        speditor1.commit();
    }

}