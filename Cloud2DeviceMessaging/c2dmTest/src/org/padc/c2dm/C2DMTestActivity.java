package org.padc.c2dm;

import org.padc.c2dm.util.C2DMAuthUtil;
import org.padc.c2dm.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

public class C2DMTestActivity extends Activity {
    private SharedPreferences sharedPreferences;

    public void register(String auth_key) {
        Intent registrationIntent = new Intent(
                "com.google.android.c2dm.intent.REGISTER");
        registrationIntent.putExtra("app",
                PendingIntent.getBroadcast(this, 0, new Intent(), 0));
        registrationIntent.putExtra("sender", "lopegwapo@gmail.com");
        startService(registrationIntent);
        Log.i("C2dmTestActivity", "Grabbing your device registration ID.....");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        String email = getString(R.string.email);
        String password = getString(R.string.password);
        String authToken = C2DMAuthUtil.authenticate(email, password);
        register(authToken);
        sharedPreferences.edit().putString("auth", authToken).commit();
    }
}