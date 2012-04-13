#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module;

import ${package}.db.DBHelper;
import ${package}.provider.DBHelperProvider;

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
