package org.padc.skeleton.module;

import org.padc.skeleton.db.DBHelper;
import org.padc.skeleton.provider.DBHelperProvider;

import com.google.inject.AbstractModule;

/**
 *
 * @author Lope Chupijay Emano
 *
 */
public class SampleModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DBHelper.class).toProvider(DBHelperProvider.class);
    }
    
}
