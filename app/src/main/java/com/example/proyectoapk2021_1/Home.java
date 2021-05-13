package com.example.proyectoapk2021_1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    //ATRIBUTOS
    ArrayList<Actividad> listadedatos= new ArrayList<>();
    RecyclerView listado;

    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        {

            listado = findViewById(R.id.listado);
            listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

            crearListado();
            AdaptadorLista adaptador=new AdaptadorLista(listadedatos);
            listado.setAdapter(adaptador);

        }
    }

    private void crearListado(){

        listadedatos.add(new Actividad("Comidas","-Mangarracho (pandequeso agrio), " +
                "el pandequeso de nata o del capio, los panecitos, (parecidos a los panderitos dulces)\n",R.drawable.pandequeso));
        listadedatos.add(new Actividad("Sitios Turisticos","Capilla Santa Ana\n" +
                "Bosques de la Mayoría en la vereda La Honda\n" +
                "El parque recreativo ecoturistico (el parque arvi)\n" +
                "Alto de la Virgen\n" +
                "Laguna de Guarne.\n" +
                "Cascadas quebrada la Brizuela\n" +
                "Cascada del Diablo\n" +
                "El salto\n" +
                "Alto de la \"M¨\"\n" +
                "Charcos Vereda San Jose\n" +
                "Alto del organo vereda Juan XXIII\n" +
                "El refugio del pescador\n" +
                "Parque ecológico Piedras Blancas\n" +
                "Parque Ecológico Siete Cueros\n" +
                "Lugares arqueológicos en las veredas de La Peña, La Piedra, El Roble y el Rosario",R.drawable.sitios));
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
        }

        return  super.onOptionsItemSelected(opcion);

    }

}
