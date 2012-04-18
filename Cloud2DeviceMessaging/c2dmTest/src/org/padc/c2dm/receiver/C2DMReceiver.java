package org.padc.c2dm.receiver;

import java.io.IOException;

import org.padc.c2dm.sender.C2DMSender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class C2DMReceiver extends BroadcastReceiver {
    private final String SAMPLE_MESSAGE = "Sample callback";
    private SharedPreferences sharedPreferences;
    private String registrationId;
    @Override
    public void onReceive(Context context, Intent intent) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Log.i("C2DMReceiver", "Intent received : " + intent.getAction());
        if (intent.getAction().equals(
                "com.google.android.c2dm.intent.REGISTRATION")) {
            registrationId = handleRegistration(context, intent);
        } else if (intent.getAction().equals(
                "com.google.android.c2dm.intent.RECEIVE")) {
            handleMessage(context, intent);
        }
        try {
            sendSample(registrationId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendSample(String registrationID) throws IOException{
        C2DMSender.sendMessage(sharedPreferences.getString("auth", null), registrationID, SAMPLE_MESSAGE);
    }
    
    private String handleRegistration(Context context, Intent intent) {
        String registration = intent.getStringExtra("registration_id");
        if (intent.getStringExtra("error") != null) {
            Log.e("C2DMReceiver", "There was an error with your device registration!");
        } else if (intent.getStringExtra("unregistered") != null) {
            Log.i("C2DMReceiver", "You have been unregistered!");
        } else if (registration != null) {
            registrationId = registration;
            Log.i("C2DMReceiver", "Your registration code is: " + registrationId);
        }
        return registration;
    }
//    curl --header "Authorization: GoogleLogin auth=DQAAALwAAACzQl44LwBkSoBhnYCRz1vERDGJyu48ulucLUbeGLNxwFxJubj7_qL6NBEHHnXSd8mwC6JYfLwTNhESL8sxk2i9_jq73rpxdixyHZMhmmLLqDdDdVSUZOfQwjwWfb1ZOmlj23IHsNDfprGgGJVqJ2ecuj1PMXU8yVH40lWXQ7cMxUliaNRzsDWWaz4PZLUtLuSEbOnjPt9D25Z3DKiEHOzmJkeFGR2kR-3lcjUwM_NMu53GS_N6fvXKb-_ZqSsaXoU1" "https://android.apis.google.com/c2dm/send" -d registration_id=APA91bFnh9hwO2CGfnPj7m9lFw5kCRhpfZZGVcqh2N_Y0pe_K8lwYzshuYzEcYDZz3fIBmigmThO948CN3wT2FsJZBlcdYpvkLUqUKmUnsA2__TxDSVd2TTM-4vdls8avepnMvvABS9N4qQRzhBzF4fjTyRYwabKyQ1 -d "data.payload=payload" -d collapse_key=0
    private void handleMessage(Context context, Intent intent) {
        Log.i("C2DMReceiver", "You have been alerted!");
        Log.i("C2DMReceiver", "Raw URI : " + intent.toURI());
        Log.i("C2DMReceiver", "payload : " + intent.getStringExtra("payload"));
    }

}
