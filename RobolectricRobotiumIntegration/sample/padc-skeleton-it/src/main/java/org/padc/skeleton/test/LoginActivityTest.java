package org.padc.skeleton.test;

import org.padc.skeleton.FacebookActivity;
import org.padc.skeleton.LoginActivity;
import org.padc.skeleton.R;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class LoginActivityTest extends
        ActivityInstrumentationTestCase2<LoginActivity> {
    private Solo solo;

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    public void testActivity() {
        LoginActivity activity = getActivity();
        assertNotNull(activity);
        solo = new Solo(getInstrumentation(), getActivity());
        EditText edtUsername = (EditText) solo.getView(R.id.edtUsername);
        EditText edtPassword = (EditText) solo.getView(R.id.edtPassword);
        solo.enterText(edtUsername, "username");
        solo.enterText(edtPassword, "password");
        solo.clickOnButton("Login");
    }

    public void setUp() throws Exception {
//        Intent intent = new Intent(getInstrumentation().getTargetContext(),
//                FacebookActivity.class);
//        getActivity().startActivity(intent);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}
