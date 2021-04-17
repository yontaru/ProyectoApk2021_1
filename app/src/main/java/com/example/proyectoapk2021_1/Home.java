package com.example.proyectoapk2021_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ArrayList<Actividad> listadedatos= new ArrayList<>();
    RecyclerView listado;


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

}
