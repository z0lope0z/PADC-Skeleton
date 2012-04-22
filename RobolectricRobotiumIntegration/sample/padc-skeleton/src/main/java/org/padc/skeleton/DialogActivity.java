package org.padc.skeleton;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

import de.akquinet.android.androlog.Log;

/**
 *
 * @author Lope Chupijay Emano
 *
 */
public class DialogActivity extends SherlockActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.init();
        Log.i(this, "onCreate");
    }
}
