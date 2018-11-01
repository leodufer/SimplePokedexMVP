package py.edu.facitec.simplepokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import py.edu.facitec.simplepokedex.modelo.Pokemon;
import py.edu.facitec.simplepokedex.view.ParentActivity;

public class PokemonDetalleActivity extends ParentActivity<Pokemon> {
    TextView nameTextView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detalle);
        Pokemon p = (Pokemon) getIntent().getSerializableExtra("pokemon");
        nameTextView = findViewById(R.id.textViewName);
        imageView = findViewById(R.id.imageView);
        showSuccess(p);
    }

    @Override
    public void showSuccess(Pokemon results) {
        nameTextView.setText(results.getName());
        Picasso.with(this)
                .load("http://simple-pokemon.herokuapp.com/images/pokemons/"
                        +results.getName().toLowerCase()+".jpg")
                .into(imageView);
    }
}
