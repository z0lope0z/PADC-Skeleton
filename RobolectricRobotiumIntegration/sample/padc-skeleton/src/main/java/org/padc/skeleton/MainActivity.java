package org.padc.skeleton;

import org.padc.skeleton.db.DBHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;
import com.google.inject.Inject;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class MainActivity extends RoboSherlockActivity {
    public static int THEME = R.style.Theme_Sherlock;
    @Inject
    private Context mContext;
    @Inject
    private DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(mContext, dbHelper.test(), Toast.LENGTH_LONG).show();
        int theme = R.style.Theme_Sherlock_ForceOverflow;
        if (THEME == R.style.Theme_Sherlock_Light) {
            theme = R.style.Theme_Sherlock_Light_ForceOverflow;
        } else if (THEME == R.style.Theme_Sherlock_Light_DarkActionBar) {
            theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
        }
        setTheme(theme);
        super.onCreate(savedInstanceState);
//        Intent intent = new Intent();
//        intent.setClass(this, DialogActivity.class);
//        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean isLight = THEME == R.style.Theme_Sherlock_Light;
        menu.add("Search")
                .setIcon(
                        isLight ? R.drawable.ic_search_inverse
                                : R.drawable.ic_search)
                .setActionView(R.layout.collapsible_edittext)
                .setShowAsActionFlags(BIND_IMPORTANT)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        menu.add("Refresh")
                .setIcon(
                        isLight ? R.drawable.ic_refresh_inverse
                                : R.drawable.ic_refresh)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add("Save")
                .setIcon(
                        isLight ? R.drawable.ic_compose_inverse
                                : R.drawable.ic_compose)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        menu.add("Refresh")
                .setIcon(
                        isLight ? R.drawable.ic_refresh_inverse
                                : R.drawable.ic_refresh)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Intent intent = new Intent();
        intent.setClass(this, CollapsibleActivity.class);
        startActivity(intent);
        return super.onMenuItemSelected(featureId, item);
    }

}
