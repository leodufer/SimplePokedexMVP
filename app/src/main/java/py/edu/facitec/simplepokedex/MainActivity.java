package py.edu.facitec.simplepokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import py.edu.facitec.simplepokedex.modelo.Pokemon;
import py.edu.facitec.simplepokedex.presenter.PokemonPresenter;
import py.edu.facitec.simplepokedex.view.MView;

public class MainActivity extends AppCompatActivity implements MView<Pokemon> {

    PokemonPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PokemonPresenter(this);
        presenter.obtnerPokemones();
    }

    @Override
    public void showSuccess(List<Pokemon> results) {
        Toast.makeText(this,results.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccess(Pokemon result) {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }
}
