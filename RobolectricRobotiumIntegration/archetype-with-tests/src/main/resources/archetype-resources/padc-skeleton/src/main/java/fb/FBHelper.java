#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.fb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ${package}.fb.models.Friend;
import ${package}.fb.models.UserFacebook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class FBHelper {
    public final static String FRIENDS_URL = "https://graph.facebook.com/me/friends";
    private String accessToken;
    private Facebook facebook;
    private Bundle params;

    public FBHelper(Facebook facebook, String accessToken) {
        Log.i("FBHelper", "Creating FBHelper with access token : " + accessToken);
        this.facebook = facebook;
        this.accessToken = accessToken;
        params = new Bundle();
        params.putString("access_token", accessToken);
    }

    public UserFacebook getCurrentUserFacebook() {
        JSONObject json;
        UserFacebook currentUser = null;
        try {
            json = Util.parseJson(facebook.request("me", params));
            String userId = json.getString("id");
            String email = json.getString("email");
            currentUser = new UserFacebook(userId, email);
            Log.i("FacebookTestActivity", "userId : " + userId + " email : "
                    + email);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FacebookError e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    public List<Friend> getFriendList() throws MalformedURLException,
            IOException, JSONException, FacebookError {
        List<Friend> friends = new ArrayList<Friend>();
        String response = Util.openUrl("https://graph.facebook.com/me/friends", "GET", params);
        JSONObject jsonObject = Util.parseJson(response);
        Log.i("FBHelper", "json response : " + jsonObject.toString());
        JSONArray array = jsonObject.optJSONArray("data");
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                String name = array.getJSONObject(i).getString("name");
                String id = array.getJSONObject(i).getString("id");
                friends.add(new Friend(id, name));
            }
        }
        return friends;
    }

    public Bitmap getProfilePic() throws MalformedURLException {
        URL profilePicURL = new URL(
                "https://graph.facebook.com/me/picture?type=normal&method=GET&access_token="
                        + accessToken);
        Bitmap profilePicBitMap = null;
        Log.i("FBHelper", "Getting profile picture from : " + profilePicURL);
        try {
            profilePicBitMap = BitmapFactory.decodeStream(profilePicURL
                    .openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profilePicBitMap;
    }
}
