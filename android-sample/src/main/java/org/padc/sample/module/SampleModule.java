package org.padc.sample.module;

import org.padc.sample.db.DBHelper;
import org.padc.sample.provider.DBHelperProvider;

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
