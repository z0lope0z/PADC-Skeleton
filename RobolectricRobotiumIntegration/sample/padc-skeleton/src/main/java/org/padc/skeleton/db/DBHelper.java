package org.padc.skeleton.db;

import org.padc.skeleton.db.models.Category;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Category, Integer> someObjectTable = null;
    private ConnectionSource connectionSource = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        try {
            TableUtils.createTable(connectionSource, Category.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
            int oldVersion, int newVersion) {
    }

    public Dao<Category, Integer> getSomeObjectDao() throws SQLException {
        if (someObjectTable == null) {
            try {
                someObjectTable = DaoManager.createDao(connectionSource, Category.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return someObjectTable;
    }
    
    public String test(){
        return "Successful injection";
    }
}
