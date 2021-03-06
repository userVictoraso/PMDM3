package com.example.pareja_ramirez_victor_datos.Ejercicio2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.example.pareja_ramirez_victor_datos.Ejercicio2.Alarm.Alarm;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity.AlarmActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity.SettingsActivity;
import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    final String fileName = "tiempo.txt";
    final int alarmLimit = 5;
    ActivityMain2Binding binding;
    static ArrayList<Alarm> alarmArrayList = new ArrayList<>();
    Spinner spinner;
    String[] alarmData = new String[2];
    String alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Alarmas");

        loadSpinner();

        /**BUTTONS**/
        saveAlarm();
        cleanAlarms();
        startAlarmActivity();
    }

    public void loadSpinner() {
        String[] arraySpinner = new String[]{"coin", "menu", "shoot"};
        spinner = binding.spinner;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
    }

    public void saveAlarm() {
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmData[0] = binding.editTextTiempo.getText().toString();
                try {
                    int isNumber = Integer.parseInt(alarmData[0]);
                    alarmData[1] = binding.editTextDescripcion.getText().toString();
                    alarm = alarmData[0] + "; " + alarmData[1] + ";" + binding.spinner.getSelectedItem().toString() + "\n";
                    try {
                        writeFileOnInternalStorage(alarm);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getBaseContext(), "El tiempo no es un número", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    public void cleanAlarms() {
        binding.cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cleanFile();
                    alarmArrayList.clear();
                    Toast.makeText(getBaseContext(), "Alarmas borradas",
                            Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void startAlarmActivity() {
        binding.finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (countAlarm() != 0) {
                        readFromFileAndAddToArrayList();
                        startActivity(new Intent(MainActivity2.this, AlarmActivity.class));
                    } else {
                        Toast.makeText(getBaseContext(), "Aún no hay alarmas.",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void writeFileOnInternalStorage(String alarmData) throws IOException {
        if (!getFile().exists()) {
            try {
                getFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (countAlarm() >= alarmLimit) {
                Toast.makeText(getBaseContext(), "Ya hay " + countAlarm() + " alarmas",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            FileOutputStream fOut = new FileOutputStream(getFile(), true);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            if (countAlarm() > 0) {
                outputWriter.append(alarmData);
            } else {
                outputWriter.write(alarmData);
            }
            outputWriter.close();

            Toast.makeText(getBaseContext(), "Alarma añadida",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getDirectory() {
        File directory = new File(this.getFilesDir() + File.separator + "/MyFolder");
        if (!directory.exists())
            directory.mkdir();
        return directory;
    }

    public File getFile() {
        File newFile = new File(getDirectory(), fileName);
        return newFile;
    }

    public void cleanFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(getFile());
        writer.print("");
        writer.close();
    }

    public int countAlarm() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getFile()));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }

    //Leo el fichero, añado al arrayList de alarmas y llamo a este metodo antes de iniciar la actividad de las alarmas
    //En la actividad de las alarmas llamo al método getArrayList, que se llena con readFromFileAndAddToArrayList
    public void readFromFileAndAddToArrayList() throws NumberFormatException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(getFile()));
            String line = reader.readLine();
            while (line != null) {
                if (line.isEmpty()) {
                } else {
                    String[] parts = line.split(";");
                    alarmArrayList.add(new Alarm(Integer.parseInt(parts[0]), parts[1], parts[2]));
                    line = reader.readLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getArrayList() {
        return alarmArrayList;
    }

    /*MENÚ*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajustesItem:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}