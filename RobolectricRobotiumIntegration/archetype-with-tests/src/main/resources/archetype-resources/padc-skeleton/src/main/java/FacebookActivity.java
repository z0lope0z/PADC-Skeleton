#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import ${package}.fb.FBHelper;
import ${package}.fb.models.Friend;

import roboguice.inject.InjectView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class FacebookActivity extends RoboSherlockActivity {
    private Facebook facebook;
    private SharedPreferences mPrefs;
    private int ACTIVITY_CODE = 222;
    private FBHelper fbHelper;

    @InjectView(R.id.image)
    private ImageView image;
    @InjectView(R.id.text)
    private TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook);
        init();
        initFB();
    }

    private void init() {
        String appId = getString(R.string.app_id);
        facebook = new Facebook(appId);
        Log.i("FacebookActivity", "Using app id : " + appId);
        mPrefs = getPreferences(MODE_PRIVATE);
    }

    private void initFB() {
        /*
         * Get existing access_token if any
         */
        Log.i("FacebookActivity",
                "Retrieved access_token from shared preferences : "
                        + mPrefs.getString("access_token", null));
        long expires = mPrefs.getLong("access_expires", 0);
        if (expires != 0) {
            facebook.setAccessExpires(expires);
        }
        /*
         * Only call authorize if the access_token has expired.
         */
        Log.i("FacebookActivity",
                "is session valid? : " + facebook.isSessionValid());
        if (!facebook.isSessionValid()) {
            Log.i("FacebookActivity", "Authorizing current session .. ");
            facebook.authorize(this,
                    new String[] { "offline_access", "email" }, ACTIVITY_CODE,
                    new DialogListener() {
                        public void onComplete(Bundle values) {
                            SharedPreferences.Editor editor = mPrefs.edit();
                            editor.putString("access_token",
                                    facebook.getAccessToken());
                            Log.i("Access Token",
                                    "Access token " + facebook.getAccessToken());
                            editor.putLong("access_expires",
                                    facebook.getAccessExpires());
                            editor.commit();
                            fbHelper = new FBHelper(facebook, mPrefs.getString(
                                    "access_token", null));
                            updateProfilePic();
                            showFriendsList();
                        }

                        public void onFacebookError(FacebookError error) {
                        }

                        public void onError(DialogError e) {
                        }

                        public void onCancel() {
                        }
                    });
            Log.i("FacebookActivity", "Successfully authorized with token : "
                    + facebook.getAccessToken());
        }
    }

    private void updateProfilePic() {
        try {
            image.setImageBitmap(fbHelper.getProfilePic());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void showFriendsList() {
        try {
            List<Friend> friends = fbHelper.getFriendList();
            StringBuilder sb = new StringBuilder();
            for (Friend friend : friends) {
                sb.append(friend.getName());
                sb.append("${symbol_escape}n");
            }
            text.setText(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FacebookError e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Access Result",
                "error description : "
                        + data.getStringExtra("error_description"));
        facebook.authorizeCallback(requestCode, resultCode, data);
        Log.i("Access Result", "result data to string : "
                + data.toURI().toString());
    }

}
