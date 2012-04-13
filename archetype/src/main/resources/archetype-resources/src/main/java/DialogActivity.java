#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

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
