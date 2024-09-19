package br.ufc.quixada.usoroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.ufc.quixada.usoroomdatabase.models.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.tituloTextView.setText(pokemon.nome);
        holder.descricaoTextView.setText(pokemon.level);
//        holder.typeTextView.setText((CharSequence) pokemon.types);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void removePokemon(int position) {
        pokemons.remove(position);
        notifyItemRemoved(position);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        notifyItemInserted(pokemons.size() - 1);
    }

    public Pokemon getPokemonAt(int position) {
        return pokemons.get(position);
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTextView, descricaoTextView, typeTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.textView_nome);
            descricaoTextView = itemView.findViewById(R.id.textView_level);
//            typeTextView = itemView.findViewById(R.id.textView_types);
        }
    }
}
