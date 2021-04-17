package com.example.proyectoapk2021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    TextView nombreActividad, descripcionActividad;
    ImageView fotoActividad;

    Actividad actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreActividad=findViewById(R.id.nombreActividad);
        descripcionActividad=findViewById(R.id.descripcionActividadMain);
        fotoActividad=findViewById(R.id.fotoActividadMain);

        actividad=(Actividad) getIntent().getSerializableExtra("Actividad");

        nombreActividad.setText(actividad.getNombreActividad());
        descripcionActividad.setText(actividad.getDescripcionActividad());
        fotoActividad.setImageResource(actividad.getFotoActividad());

    }
}