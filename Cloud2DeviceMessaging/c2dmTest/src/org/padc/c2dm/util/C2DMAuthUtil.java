package org.padc.c2dm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.util.Log;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class C2DMAuthUtil {

    
    /**
     * 
     * @param email
     * @param password
     * @return Authentication token/ID
     */
    public static String authenticate(String email, String password) {
        StringBuilder builder = new StringBuilder();
        builder.append("Email=").append(email);
        builder.append("&Passwd=").append(password);
        builder.append("&accountType=GOOGLE");
        builder.append("&source=MyLittleExample");
        builder.append("&service=ac2dm");

        String line = null;
        String auth_key = null;
        // Setup the Http Post
        byte[] data = builder.toString().getBytes();
        URL url;
        try {
            url = new URL("https://www.google.com/accounts/ClientLogin");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            con.setRequestProperty("Content-Length",
                    Integer.toString(data.length));

            // Issue the HTTP POST request
            OutputStream output = con.getOutputStream();
            output.write(data);
            output.close();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Auth=")) {
                    auth_key = line.substring(5);
                }
            }
            Log.i("C2dmTestActivity", "Authentication key : " + auth_key);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return auth_key;
    }
}
