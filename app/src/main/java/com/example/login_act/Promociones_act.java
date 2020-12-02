package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Promociones_act extends AppCompatActivity {

    private EditText IngresePromocion, ValorEnvio;
    private Spinner spinner;
    private TextView Estimado, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        IngresePromocion = (EditText)findViewById(R.id.IngresePromocion);
        ValorEnvio = (EditText)findViewById(R.id.ValorEnvio);
        spinner = (Spinner)findViewById(R.id.spinner);
        Estimado = (TextView)findViewById(R.id.Estimado);
        precio = (TextView)findViewById(R.id.precio);

        String[] clientes = {"Clientes", "Ramiro", "Rosa", "Robert"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clientes);
        spinner.setAdapter(adapt);
    }

    public void calcular(View v)
    {
        String promo = IngresePromocion.getText().toString().toLowerCase();
        int costoE = Integer.parseInt(ValorEnvio.getText().toString());
        if (promo.equals("pizzas promo"))
        {
            if (spinner.getSelectedItem().toString().equals("Ramiro"))
            {
                int total = 5990 + costoE;
                Estimado.setText("Estimado Ramiro el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Rosa"))
            {
                int total = 5990 + costoE;
                Estimado.setText("Estimada Rosa el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Robert"))
            {
                int total = 5990 + costoE;
                Estimado.setText("Estimado Robert el final segun la promocion y envio es");
                precio.setText(total);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Elija cliente", Toast.LENGTH_SHORT).show();
            }
        }
        else if (promo.equals("master pizza"))
        {
            if (spinner.getSelectedItem().toString().equals("Ramiro"))
            {
                int total = 12990 + costoE;
                Estimado.setText("Estimado Ramiro el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Rosa"))
            {
                int total = 12990 + costoE;
                Estimado.setText("Estimada Rosa el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Robert"))
            {
                int total = 12990 + costoE;
                Estimado.setText("Estimado Robert el final segun la promocion y envio es");
                precio.setText(total);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Elija cliente", Toast.LENGTH_SHORT).show();
            }
        }
        else if (promo.equals("pizza max"))
        {
            if (spinner.getSelectedItem().toString().equals("Ramiro"))
            {
                int total = 18500 + costoE;
                Estimado.setText("Estimado Ramiro el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Rosa"))
            {
                int total = 18500 + costoE;
                Estimado.setText("Estimada Rosa el final segun la promocion y envio es");
                precio.setText(total);
            }
            else if (spinner.getSelectedItem().toString().equals("Robert"))
            {
                int total = 18500 + costoE;
                Estimado.setText("Estimado Robert el final segun la promocion y envio es");
                precio.setText(total);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Elija cliente", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Elija una promocion existente", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Pizzas promo, Master pizza, Pizza max", Toast.LENGTH_SHORT).show();
        }
    }
}