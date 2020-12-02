package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clases.Cliente;

public class firebase_act extends AppCompatActivity {
    private EditText IngreseNombre2, IngreseDestino, IngresePromocion;
    private Button GuardarCliente;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        IngreseNombre2 = (EditText) findViewById(R.id.IngreseNombre2);
        IngreseDestino = (EditText) findViewById(R.id.IngreseDestino);
        IngresePromocion = (EditText) findViewById(R.id.IngresePromocion);
        GuardarCliente = (Button) findViewById(R.id.GuardarCliente);

        inicializarBase();
        GuardarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!IngreseNombre2.getText().toString().trim().isEmpty() && !IngreseDestino.getText().toString().trim().isEmpty() && !IngresePromocion.getText().toString().trim().isEmpty()) {
                    //añade
                    Cliente c = new Cliente();
                    c.setId(UUID.randomUUID().toString());
                    c.setIngreseNombre2(IngreseNombre2.getText().toString().trim());
                    c.setIngreseDestino(IngreseDestino.getText().toString().trim());
                    c.setIngresePromocion(IngresePromocion.getText().toString().trim());
                    databaseReference.child("Clientes").child(c.getId()).setValue(c);
                    Toast.makeText(getApplicationContext(), "se ha guardado el Cliente: " + IngreseNombre2.getText(), Toast.LENGTH_SHORT).show();
                    IngreseNombre2.setText("");
                    IngreseDestino.setText("");
                    IngresePromocion.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    public void inicializarBase() {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void listado(View v) {
        Intent i = new Intent(this, Listado_Clientes_act.class);
        startActivity(i);
       }
}


