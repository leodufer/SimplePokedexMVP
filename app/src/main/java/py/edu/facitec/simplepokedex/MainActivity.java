package py.edu.facitec.simplepokedex;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import py.edu.facitec.simplepokedex.modelo.Pokemon;
import py.edu.facitec.simplepokedex.modelo.Stats;
import py.edu.facitec.simplepokedex.presenter.PokemonPresenter;
import py.edu.facitec.simplepokedex.view.MView;
import py.edu.facitec.simplepokedex.view.ParentActivity;
import py.edu.facitec.simplepokedex.view.PokemonAdapter;

public class MainActivity extends ParentActivity<Pokemon>{

    PokemonPresenter presenter;
    RelativeLayout errorStatus;
    ProgressBar progressBar;
    ListView pokemonListView;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PokemonPresenter(this);
        presenter.obtnerPokemones();
        errorStatus = findViewById(R.id.statuserror);
        progressBar = findViewById(R.id.progressbar);
        pokemonListView = findViewById(R.id.pokemoListView);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.obtnerPokemones();
            }
        });
    }

    @Override
    public void showSuccess(List<Pokemon> results) {
        //Toast.makeText(this,results.toString(),Toast.LENGTH_LONG).show();
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
        errorStatus.setVisibility(View.GONE);
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,results);
        PokemonAdapter adapter = new PokemonAdapter(results,this);
        pokemonListView.setAdapter(adapter);
        pokemonListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        swipeRefreshLayout.setRefreshing(false);
        //Toast.makeText(this,error,Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
        errorStatus.setVisibility(View.VISIBLE);
        pokemonListView.setVisibility(View.GONE);
    }
}
