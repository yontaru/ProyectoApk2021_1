package com.example.proyectoapk2021_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Registro extends AppCompatActivity {

    EditText cajaNombre, cajaDescripcion;
    Button botonRegistrar, botonListar;
    FirebaseFirestore conexion=FirebaseFirestore.getInstance();

    Map<String, Object> actividad=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        cajaNombre=findViewById(R.id.nombre);
        cajaDescripcion=findViewById(R.id.descripcion);
        botonRegistrar=findViewById(R.id.botonRegistrar);
        botonListar=findViewById(R.id.botonBuscar);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre=cajaNombre.getText().toString();
                String descripcion=cajaDescripcion.getText().toString();


                actividad.put("nombre",nombre);
                actividad.put("descripcion",descripcion);

                registrarActividad();
            }
        });

        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Registro.this,Home.class);
                startActivity(intent);
                finish();
            }
        });



    }

    private void registrarActividad(){

        conexion.collection("actividades")
                .add(actividad)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Éxito agregando la actividad",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error"+e,Toast.LENGTH_LONG).show();
                    }
                });
    }


}
