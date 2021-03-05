package com.example.pareja_ramirez_victor_datos.Ejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones.AboutActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones.ColorActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones.ValueActivity;
import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain1Binding;

import java.text.DecimalFormat;

public class MainActivity1 extends AppCompatActivity {
    static double coinValue = 2;
    ActivityMain1Binding binding;
    private TextWatcher tv1;
    private TextWatcher tv2;
    DecimalFormat df = new DecimalFormat("#.00");
    static Integer backgroundColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Toolbar toolbar = (Toolbar) binding.toolbar.toolbar;
        //TODO: QUITAR LA SUBTOOLBAR
        //setSupportActionBar(null);
        getSupportActionBar().setTitle("Datos");


        binding.switchMoneda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.editTextDolares.setEnabled(true);
                    binding.editTextEuro.setEnabled(false);
                    limpiarCampos();
                } else {
                    binding.editTextEuro.setEnabled(true);
                    binding.editTextDolares.setEnabled(false);
                    limpiarCampos();
                }
            }
        });
        comprobarDolarAEuro();
        comprobarEuroADolar();
        binding.editTextEuro.addTextChangedListener(tv1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        View view = binding.getRoot();
        updateBackgroundColor(view);
    }

    public void limpiarCampos() {
        binding.editTextDolares.removeTextChangedListener(tv2);
        binding.editTextEuro.removeTextChangedListener(tv1);
        binding.editTextDolares.setText("");
        binding.editTextEuro.setText("");
        binding.editTextDolares.addTextChangedListener(tv2);
        binding.editTextEuro.addTextChangedListener(tv1);
    }

    public void comprobarEuroADolar() {
        tv1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (binding.editTextEuro.toString().length() < 1) {
                        limpiarCampos();
                    }
                    double resultado = Double.valueOf(binding.editTextEuro.getText().toString()) * coinValue;
                    System.out.println(resultado);
                    binding.editTextDolares.removeTextChangedListener(tv2);
                    binding.editTextDolares.setText(String.valueOf(df.format(resultado)) + " $");
                    binding.editTextDolares.addTextChangedListener(tv2);
                } catch (NumberFormatException e) {
                    limpiarCampos();
                }
            }
        };
    }

    public void comprobarDolarAEuro() {
        tv2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (binding.editTextDolares.toString().length() == 0) {
                        limpiarCampos();
                    }
                    double resultado = Double.valueOf(binding.editTextDolares.getText().toString()) / coinValue;
                    binding.editTextEuro.removeTextChangedListener(tv1);
                    binding.editTextEuro.setText(String.valueOf(df.format(resultado)) + " €");
                    binding.editTextEuro.addTextChangedListener(tv1);
                } catch (NumberFormatException e) {
                    limpiarCampos();
                }
            }
        };
    }


    /*MENÚ*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.colorItem:
                Toast.makeText(this, "Color", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity1.this, ColorActivity.class));
                return true;
            case R.id.valueItem:
                Toast.makeText(this, "Value", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity1.this, ValueActivity.class));
                return true;
            case R.id.aboutUsItem:
                Toast.makeText(this, "AboutUs", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity1.this, AboutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //SET AND GET COINVALUE
    public static void setCoinValue(double coinValue) {
        MainActivity1.coinValue = coinValue;
    }

    public static double getCoinValue() {
        return coinValue;
    }

    public void updateBackgroundColor(View v) {
        if(backgroundColor != null) {
            v.setBackgroundColor(backgroundColor);
        }
    }
    public static void changeAppBackground(Integer color) {
        backgroundColor = color;
    }

}