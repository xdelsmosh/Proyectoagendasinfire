package com.paquetesagenda.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.paquetesagenda.OrdendetailsActivity;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String usuario = sharedPreferences.getString("usuario","").toString();
        Toast.makeText(getApplicationContext(),"Bienvenido"+usuario,Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.tarjetasalir);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));

            }
        });

        CardView findAgente = findViewById(R.id.tarjetaagente);
        findAgente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ContactoagenteActivity.class));

            }
        });


        CardView findgps = findViewById(R.id.tarjetas);
        findgps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,mapActivity.class));

            }
        });


        CardView ordendetails = findViewById(R.id.tarjetaordenes);
        ordendetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OrdendetailsActivity.class));

            }
        });


        CardView galeria = findViewById(R.id.galeria);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GaleriaActivity.class));

            }
        });

    }



}

