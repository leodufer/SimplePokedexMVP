package py.edu.facitec.simplepokedex.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import py.edu.facitec.simplepokedex.R;
import py.edu.facitec.simplepokedex.modelo.Pokemon;

public class PokemonAdapter extends BaseAdapter{

    List<Pokemon> pokemons;
    Context context;

    public PokemonAdapter(List<Pokemon> pokemons, Context context) {
        this.pokemons = pokemons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pokemons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                            .inflate(R.layout.item_pokemon,null);
        }
        ImageView imgImageView = convertView.findViewById(R.id.imgImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView speciesTextView = convertView.findViewById(R.id.speciesTextView);
        Pokemon p = pokemons.get(position);

        nameTextView.setText(p.getName());
        speciesTextView.setText(p.getSpecies());
        //imagen
        Picasso.with(context)
                .load("http://simple-pokemon.herokuapp.com/images/pokemons/"
                        +p.getName().toLowerCase()+".jpg")
                .into(imgImageView);

        return convertView;
    }
}
