package br.ufc.quixada.usoroomdatabase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.usoroomdatabase.dao.PokemonDao;

@Dao
@Entity(tableName = "pokemon")
public class Pokemon implements PokemonDao {
    // : Id, Nome, Curso e Idade
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "nome")
    public String nome;
    @ColumnInfo(name = "level")
    public String level;
//    @ColumnInfo(name = "types")
//    public ArrayList<Types> types;

    public Pokemon( String level, String nome) {
//        this.types = types;
        this.level = level;
        this.nome = nome;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

//    public ArrayList<Types> getTypes() {
//        return types;
//    }

//    public void setTypes(ArrayList<Types> types) {
//        this.types = types;
//    }

    public void insertAll(Pokemon novaPokemon) {
        
    }

    public List<Pokemon> getAllPokemons() {
        return null;
    }

    @Override
    public void insertAll(Pokemon... pokemons) {

    }

    public void delete(Pokemon pokemonToRemove) {
    }
};
