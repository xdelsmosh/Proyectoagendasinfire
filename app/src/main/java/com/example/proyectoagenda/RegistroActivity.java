package com.example.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText edUsuario,edEmail,edPassword,edConfirmarPass;
    Button btn;
    Button btnvolver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edUsuario = findViewById(R.id.editTextnombreusuauraio);
        edEmail = findViewById(R.id.editTextEmail);
        edPassword = findViewById(R.id.editTextnuevaPassword);
        edConfirmarPass = findViewById(R.id.confirmarpassword);
        btn = findViewById(R.id.buttonreg);
        btnvolver = findViewById(R.id.buttonvolver);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edUsuario.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirme = edConfirmarPass.getText().toString();
                Database db = new Database(getApplicationContext(),"Proyectoagenda",null,1);
                if (usuario.length()==0 || email.length()==0 ||password.length()==0 || confirme.length()==0){

                    Toast.makeText(getApplicationContext(),"Caampos en blanco o incorrecto",Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirme)==0){
                       if (isValid(password)){
                           db.registro(usuario,email,password);
                           Toast.makeText(getApplicationContext(),"Usuario registrado. ",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistroActivity.this,LoginActivity.class));
                       }
                       else{
                           Toast.makeText(getApplicationContext(),"La contraseña debe tener 8 caracteres,contener letras,digitos y character especial. ",Toast.LENGTH_SHORT).show();
                       }
                    }else {
                        Toast.makeText(getApplicationContext(),"La contraseña no coincide, reintente nuevamente. ",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
    public static boolean isValid(String contraselaaq) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (contraselaaq.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < contraselaaq.length(); p++) {
                if (Character.isLetter(contraselaaq.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < contraselaaq.length(); r++) {
                if (Character.isDigit(contraselaaq.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < contraselaaq.length(); s++) {
                char c = contraselaaq.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}