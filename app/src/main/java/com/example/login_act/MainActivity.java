package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText NombreUsuario , IngreseContraseña ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NombreUsuario = (EditText)findViewById(R.id.NombreUsuario);
        IngreseContraseña = (EditText)findViewById(R.id.IngreseContraseña) ;
    }
    public void IniciarSesion(View v) {
        if (NombreUsuario.getText().toString().toLowerCase().equals("android") && IngreseContraseña.getText().toString().toLowerCase().equals("123")) {
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);

        }
        else
            {
            Toast.makeText(getApplicationContext(), "Ingrese bien su Usuario y Contraseña", Toast.LENGTH_SHORT).show();
            }

    }

}