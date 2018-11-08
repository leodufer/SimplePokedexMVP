package py.edu.facitec.simplepokedex.pokemon.dao;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import py.edu.facitec.simplepokedex.datastorage.DBA;
import py.edu.facitec.simplepokedex.pokemon.modelo.Pokemon;

public class PokemonDao {
    public PokemonDao(Context context){
        DBA.init(context);
    }
    public void save(Pokemon p){
        try {
            DBA.getPokemonDao().create(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(List<Pokemon> pokemonList) {
        for(Pokemon p:pokemonList){
            try {
                DBA.getPokemonDao().create(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Pokemon> getAll(){
        try {
            return DBA.getPokemonDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteAll(){
        DBA.clearAll();
    }
}
