package org.padc.sample.provider;

import org.padc.sample.db.DBHelper;

import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class DBHelperProvider implements Provider<DBHelper> {

    @Inject
    private Context context;

    public DBHelper get() {
        return OpenHelperManager.getHelper(context, DBHelper.class);
    }

}
