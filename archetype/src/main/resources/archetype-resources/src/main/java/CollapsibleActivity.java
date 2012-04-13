#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class CollapsibleActivity extends SherlockActivity implements
        ActionBar.OnNavigationListener {
    public static int THEME = R.style.Theme_Sherlock;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(THEME); // Used for theme switching in samples
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context context = getSupportActionBar().getThemedContext();
        SpinnerAdapter list = ArrayAdapter.createFromResource(context,
                R.array.locations, R.layout.sherlock_spinner_item);

        ((ArrayAdapter) list)
                .setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(list, this);
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();
        return true;
    }

}
