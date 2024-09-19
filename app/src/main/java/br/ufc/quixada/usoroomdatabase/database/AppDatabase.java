package br.ufc.quixada.usoroomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.quixada.usoroomdatabase.dao.PokemonDao;
import br.ufc.quixada.usoroomdatabase.models.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract Pokemon pokemonDao();
}
