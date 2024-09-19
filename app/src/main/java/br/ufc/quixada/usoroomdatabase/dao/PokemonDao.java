package br.ufc.quixada.usoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.ufc.quixada.usoroomdatabase.models.Pokemon;

@Dao
public interface PokemonDao {
    @Insert
    void insertAll(Pokemon... pokemons);

    @Delete
    void delete(Pokemon pokemon);

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAllPokemons();

}
