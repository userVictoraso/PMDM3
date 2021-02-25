package com.example.pareja_ramirez_victor_datos.Ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain1Binding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain2Binding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity2 extends AppCompatActivity {
    final String fileName = "tiempo.txt";
    FileWriter fileWriter;
    ActivityMain2Binding binding;
    Spinner spinner;
    String[] alarmData = new String[2];
    String alarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadSpinner();
        saveAlarm();
    }

    public void loadSpinner(){
        String[] arraySpinner = new String[]{"coin", "menu", "shoot"};
        spinner = binding.spinner;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
    }

    public void saveAlarm(){
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmData[0] = binding.editTextTiempo.getText().toString();
                alarmData[1] = binding.editTextDescripcion.getText().toString();
                alarm = alarmData[0] + "; " + alarmData[1] + "; " + binding.spinner.getSelectedItem().toString();
                ;
                try {
                    writeFileOnInternalStorage(alarm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void writeFileOnInternalStorage(String alarmData) throws IOException {
        File directory = new File(this.getFilesDir() + File.separator + "/MyFolder");
        if(!directory.exists())
            directory.mkdir();

        File newFile = new File(directory, fileName);

        if(!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try  {
            FileOutputStream fOut = new FileOutputStream(newFile);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fOut);
            outputWriter.write(alarmData);
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}