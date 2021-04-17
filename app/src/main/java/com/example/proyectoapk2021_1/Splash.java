package com.example.proyectoapk2021_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.proyectoapk2021_1.R.raw.inicio;

public class Splash extends AppCompatActivity {

    //Atributos
    MediaPlayer cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cancion=MediaPlayer.create(this, inicio);
        cancion.start();

        TimerTask inicio=new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Home.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(inicio,8000);

    }
}