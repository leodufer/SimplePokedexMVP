package py.edu.facitec.simplepokedex.base.datastorage;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.oss.datahelper.DataBaseManager;

import java.sql.SQLException;

import py.edu.facitec.simplepokedex.pokemon.modelo.Pokemon;

public class DBA {
    private static final String DB_NAME = "pokemones.sqlite";
    private static final int DB_VERSION = 1;

    public static void init(Context context){
        DataBaseManager.init(context, DB_NAME, DB_VERSION);

        ConnectionSource source = DataBaseManager.getInstance()
                .getHelper()
                .getConnectionSource();
        try {
            TableUtils.createTableIfNotExists(source, Pokemon.class);
            //Demas tablas
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Dao<Pokemon, Integer> getPokemonDao(){
        try {
            return DataBaseManager.getInstance()
                    .getHelper()
                    .getDao(Pokemon.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void clearAll(){
        ConnectionSource source = DataBaseManager.getInstance()
                .getHelper()
                .getConnectionSource();
        try {
            TableUtils.clearTable(source,Pokemon.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
