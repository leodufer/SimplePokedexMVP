package py.edu.facitec.simplepokedex.pokemon.view;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import py.edu.facitec.simplepokedex.R;
import py.edu.facitec.simplepokedex.pokemon.modelo.Pokemon;
import py.edu.facitec.simplepokedex.base.ParentActivity;

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
