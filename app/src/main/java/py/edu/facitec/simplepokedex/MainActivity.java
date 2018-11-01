package py.edu.facitec.simplepokedex;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PokemonPresenter(this);
        presenter.obtenerDatos();
        errorStatus = findViewById(R.id.statuserror);
        progressBar = findViewById(R.id.progressbar);
        resultListView = findViewById(R.id.pokemoListView);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.obtenerDatos();
            }
        });

    }

    @Override
    public void showSuccess(List<Pokemon> results) {
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
        errorStatus.setVisibility(View.GONE);
        PokemonAdapter adapter = new PokemonAdapter(results,this);
        resultListView.setAdapter(adapter);
        resultListView.setVisibility(View.VISIBLE);
        resultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon p = (Pokemon) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,PokemonDetalleActivity.class);
                intent.putExtra("pokemon",p);
                startActivity(intent);
            }
        });
    }
}
