package com.example.proyectoapk2021_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Ingreso extends AppCompatActivity {

    private FirebaseAuth autorizacion;
    EditText cajaCorreo, cajaPassword;
    Button botonRegistrar, botonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        autorizacion = FirebaseAuth.getInstance();


        cajaCorreo=findViewById(R.id.correo);
        cajaPassword=findViewById(R.id.password);
        botonRegistrar=findViewById(R.id.registrar);
        botonIngresar=findViewById(R.id.ingresar);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo=cajaCorreo.getText().toString();
                String password=cajaPassword.getText().toString();

                registrarUsuario(correo,password);



            }
        });

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo=cajaCorreo.getText().toString();
                String password=cajaPassword.getText().toString();

                ingresarUsuario(correo,password);



            }
        });


    }


    public void registrarUsuario(String correo, String password){

        autorizacion.createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Ingreso.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                            cajaCorreo.setText("");
                            cajaPassword.setText("");

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Ingreso.this, "Usuario o contraseña incorrecta.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    public void ingresarUsuario(String correo, String password){

        autorizacion.signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Ingreso.this, "Usuario ingresado correctamente", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(Ingreso.this,Home.class);
                            startActivity(intent);
                            finish();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Ingreso.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


}