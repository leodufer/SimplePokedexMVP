package py.edu.facitec.simplepokedex.pokemon.presenter;

import android.content.Context;

import java.util.List;

import py.edu.facitec.simplepokedex.base.Presenter;
import py.edu.facitec.simplepokedex.pokemon.dao.PokemonDao;
import py.edu.facitec.simplepokedex.pokemon.modelo.Pokemon;
import py.edu.facitec.simplepokedex.pokemon.servicio.PokemonServicio;
import py.edu.facitec.simplepokedex.base.MView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PokemonPresenter extends Presenter {

    PokemonServicio servicio;
    PokemonDao pokemonDao;

    public PokemonPresenter(MView view, Context context){
        super(view,"https://simple-pokemon.herokuapp.com");
        servicio = getRestAdapter().create(PokemonServicio.class);
        pokemonDao = new PokemonDao(context);
    }

    public void obtenerDatos(){
        final List<Pokemon> pokemones = pokemonDao.getAll();
        if(pokemones != null && pokemones.size()>0){
            getmView().showSuccess(pokemones);

        }
        servicio.obtnerPokemones(new Callback<List<Pokemon>>() {
            @Override
            public void success(List<Pokemon> pokemons, Response response) {
               getmView().showSuccess(pokemons);
               pokemonDao.deleteAll();
               pokemonDao.save(pokemons);
            }

            @Override
            public void failure(RetrofitError error) {
                getmView().showError(error.getLocalizedMessage());
            }
        });
    }
}
