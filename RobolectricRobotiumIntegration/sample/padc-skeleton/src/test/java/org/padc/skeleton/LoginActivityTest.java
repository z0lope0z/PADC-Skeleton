package org.padc.skeleton;

import com.xtremelabs.robolectric.Robolectric;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.padc.skeleton.db.DBHelper;
import org.padc.skeleton.provider.DBHelperProvider;
import org.padc.skeleton.runner.BaseRunner;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

import android.content.Context;
import android.os.Vibrator;
import android.widget.Button;

import com.google.inject.AbstractModule;
import com.google.inject.util.Modules;

import static org.easymock.EasyMock.*;

/**
 * A testcase that swaps in a TestVibrator to verify that
 * Astroboy's {@link org.roboguice.astroboy.controller.Astroboy#brushTeeth()} method
 * works properly.
 */
@RunWith(BaseRunner.class)
public class LoginActivityTest {
    
    protected Context context = new RoboActivity();
    protected Vibrator vibratorMock = EasyMock.createMock(Vibrator.class);

    @Before
    public void setup() {
        // Override the default RoboGuice module
        RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new MyTestModule()));
    }
    
    @After
    public void teardown() {
        // Don't forget to tear down our custom injector to avoid polluting other test classes
        RoboGuice.util.reset();
    }
    
    @Test
    public void brushingTeethShouldCausePhoneToVibrate() {
        // tell easymock what we expect, then switch easymock to "replay" mode: http://easymock.org/EasyMock3_0_Documentation.html
//        vibratorMock.vibrate(aryEq(new long[]{0, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50, 200, 50}), eq(-1));
//        replay(vibratorMock);
        

        // get the astroboy instance
//        final Astroboy astroboy = RoboGuice.getInjector(context).getInstance(Astroboy.class);
        final LoginActivity loginActivity = RoboGuice.getInjector(context).getInstance(LoginActivity.class);
        // do the thing
        loginActivity.onCreate(null);
        Assert.assertEquals(LoginActivity.TEST_STRING, loginActivity.getTestString());
        Button button = (Button) loginActivity.findViewById(R.id.button1);
        Assert.assertEquals("Login", button.getText().toString());
        // verify that by doing the thing, vibratorMock.vibrate was called
//        verify(vibratorMock);1

    }


    public class MyTestModule extends AbstractModule {
        @Override
        protected void configure() {
//            bind(Vibrator.class).toInstance(vibratorMock);
            bind(DBHelper.class).toProvider(DBHelperProvider.class);
        }
    }
}
