package py.edu.facitec.simplepokedex.presenter;

import java.util.List;

import py.edu.facitec.simplepokedex.MainActivity;
import py.edu.facitec.simplepokedex.modelo.Pokemon;
import py.edu.facitec.simplepokedex.servicio.PokemonServicio;
import py.edu.facitec.simplepokedex.view.MView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PokemonPresenter extends Presenter {

    PokemonServicio servicio;

    public PokemonPresenter(MView view){
        super(view,"https://simple-pokemon.herokuapp.com");
        servicio = getRestAdapter().create(PokemonServicio.class);
    }

    public void obtnerPokemones(){
        servicio.obtnerPokemones(new Callback<List<Pokemon>>() {
            @Override
            public void success(List<Pokemon> pokemons, Response response) {
                getmView().showSuccess(pokemons);
            }

            @Override
            public void failure(RetrofitError error) {
                getmView().showError(error.getLocalizedMessage());
            }
        });
    }
}
