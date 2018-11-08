package py.edu.facitec.simplepokedex.pokemon.servicio;

import java.util.List;

import py.edu.facitec.simplepokedex.pokemon.modelo.Pokemon;
import retrofit.Callback;
import retrofit.http.GET;

public interface PokemonServicio {
    @GET("/pokemon")
    void obtnerPokemones(Callback<List<Pokemon>> callback);
}
