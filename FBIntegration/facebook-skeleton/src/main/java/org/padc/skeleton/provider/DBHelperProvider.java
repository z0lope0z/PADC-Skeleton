package org.padc.skeleton.provider;

import org.padc.skeleton.db.DBHelper;

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
