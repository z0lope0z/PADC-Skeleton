package org.padc.skeleton.runner;

import java.io.File;

import org.junit.runners.model.InitializationError;
import org.padc.skeleton.shadow.ShadowSherlockActivity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricConfig;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.bytecode.ClassHandler;
import com.xtremelabs.robolectric.bytecode.RobolectricClassLoader;
import com.xtremelabs.robolectric.shadows.ShadowFragmentActivity;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class BaseRunner extends RobolectricTestRunner {

    public BaseRunner(Class<?> testClass)
            throws InitializationError {
        super(testClass);
        addClassOrPackageToInstrument("com.actionbarsherlock.app.SherlockActivity");
    }

    public BaseRunner(Class<?> testClass,
            File androidManifestPath, File resourceDirectory)
            throws InitializationError {
        super(testClass, androidManifestPath, resourceDirectory);
    }

    public BaseRunner(Class<?> testClass, File androidProjectRoot)
            throws InitializationError {
        super(testClass, androidProjectRoot);
    }

    public BaseRunner(Class<?> testClass,
            ClassHandler classHandler, RobolectricClassLoader classLoader,
            RobolectricConfig robolectricConfig) throws InitializationError {
        super(testClass, classHandler, classLoader, robolectricConfig);
    }

    public BaseRunner(Class<?> testClass,
            ClassHandler classHandler, RobolectricConfig robolectricConfig)
            throws InitializationError {
        super(testClass, classHandler, robolectricConfig);
    }

    public BaseRunner(Class<?> testClass,
            RobolectricConfig robolectricConfig) throws InitializationError {
        super(testClass, robolectricConfig);
    }

    @Override
    protected void bindShadowClasses() {
        super.bindShadowClasses();
        Robolectric.bindShadowClass(ShadowSherlockActivity.class);
        Robolectric.bindShadowClass(ShadowFragmentActivity.class);
    }
}
