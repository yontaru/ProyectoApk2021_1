package com.example.proyectoapk2021_1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    //ATRIBUTOS
    ArrayList<Actividad> listadedatos= new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore baseDatos =FirebaseFirestore.getInstance();

    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        {

            listado = findViewById(R.id.listado);
            listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

            crearListado();

        }
    }

    private void crearListado(){

        baseDatos.collection("actividades")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){

                            for (QueryDocumentSnapshot document : task.getResult()){

                                String nombre=document.get("nombre").toString();
                                String descripcion=document.get("descripcion").toString();
                                String foto=document.get("foto").toString();

                                listadedatos.add(new Actividad(nombre,descripcion,foto));

                            }

                            AdaptadorLista adaptador=new AdaptadorLista(listadedatos);
                            listado.setAdapter(adaptador);

                        }else{
                            Toast.makeText(getApplicationContext(),"Error: ",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }


    //Metodo para configurar el idioma de mi teléfono

    public void cambiaridioma(String lenguaje){
        Locale idioma= new Locale(lenguaje);
        Locale.setDefault(idioma);
        Configuration configuracionTelefono= getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono, getBaseContext().getResources().getDisplayMetrics());
    }




    //Metodo que pinta el Menu en ESTA actividad
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Método que controla la acción de cada opción del menú
    public boolean onOptionsItemSelected(MenuItem opcion){
        int id=opcion.getItemId();

        switch(id){

            case(R.id.opcion1):

                Intent intent=new Intent(Home.this,Perfil.class);
                startActivity(intent);
                break;

            case(R.id.opcion2):

                this.cambiaridioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;

            case(R.id.opcion3):

                this.cambiaridioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;

            case(R.id.opcion4):
                Intent intent1=new Intent(Home.this,Registro.class);
                startActivity(intent1);
                break;
        }

        return  super.onOptionsItemSelected(opcion);

    }

}
