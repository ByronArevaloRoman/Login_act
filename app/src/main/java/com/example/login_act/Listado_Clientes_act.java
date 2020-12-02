package com.example.login_act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clases.Cliente;

public class Listado_Clientes_act extends AppCompatActivity {

    private ListView ListaClientes;
    Cliente ClienteSeleccionado ;
    ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__clientes_act);
        ListaClientes = (ListView)findViewById(R.id.ListaClientes);
        inicializarBase();
        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Cliente p = objSnapshot.getValue(Cliente.class);
                    Clientes.add(p);
                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, Clientes);
                    ListaClientes.setAdapter(adapt);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ListaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                ClienteSeleccionado = (Cliente) parent.getItemAtPosition(Position);
            }
        });



    }
    public void inicializarBase() {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();

    }
    public void EliminarCliente (View v)
    {
        Cliente c = new Cliente();
        c.setId(ClienteSeleccionado.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();
        Toast.makeText(getApplicationContext(), "se ha eliminado un cliente", Toast.LENGTH_SHORT).show();
    }
}