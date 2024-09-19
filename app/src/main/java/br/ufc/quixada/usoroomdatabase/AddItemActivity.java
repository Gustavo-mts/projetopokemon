package br.ufc.quixada.usoroomdatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;

import br.ufc.quixada.usoroomdatabase.database.AppDatabase;
import br.ufc.quixada.usoroomdatabase.models.Pokemon;
import br.ufc.quixada.usoroomdatabase.models.Types;

public class AddItemActivity extends AppCompatActivity {

    private EditText nomeEditText, levelEditText;
    private Button saveButton, showListButton;
    private CheckBox normal_type, fire_type, water_type, eletric_type, ice_type;
    private AppDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        nomeEditText = findViewById(R.id.edit_name);
        levelEditText = findViewById(R.id.edit_level);
        normal_type = findViewById(R.id.normal_type);
        fire_type = findViewById(R.id.fire_type);
        water_type = findViewById(R.id.water_type);
        eletric_type = findViewById(R.id.eletric_type);
        ice_type = findViewById(R.id.ice_type);
        saveButton = findViewById(R.id.saveButton);
        showListButton = findViewById(R.id.showListButton);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pokemon-database").allowMainThreadQueries().build();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeEditText.getText().toString();
                String level = levelEditText.getText().toString();

                if (!TextUtils.isEmpty(nome) && !TextUtils.isEmpty(level)) {
                    ArrayList<Types> types = new ArrayList<Types>();
                    if (normal_type.isChecked()) {
                        types.add(new Types("Normal"));
                    };
                    if (fire_type.isChecked()) {
                        types.add(new Types("Fire"));
                    };
                    if (water_type.isChecked()) {
                        types.add(new Types("Water"));
                        };
                    if (eletric_type.isChecked()) {
                        types.add(new Types("Eletric"));
                    };
                    if (ice_type.isChecked()) {
                        types.add(new Types("Ice"));
                    }

                    Pokemon novaPokemon = new Pokemon( level, nome);
                    db.pokemonDao().insertAll(novaPokemon);

                    nomeEditText.setText("");
                    levelEditText.setText("");
                }
            }
        });

        showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
