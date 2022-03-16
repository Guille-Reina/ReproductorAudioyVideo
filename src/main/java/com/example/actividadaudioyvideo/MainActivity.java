package com.example.actividadaudioyvideo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer[6];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_control);
        btn_repetir = (Button)findViewById(R.id.btn_unitar);
        iv = (ImageView)findViewById(R.id.imageView);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.window;

        vectormp[0] = MediaPlayer.create(this,R.raw.audiod);
        vectormp[1] = MediaPlayer.create(this,R.raw.audiods);
        vectormp[2] = MediaPlayer.create(this,R.raw.audiop);
        vectormp[3] = MediaPlayer.create(this,R.raw.audiouy);
        vectormp[4] = MediaPlayer.create(this,R.raw.huio);
        vectormp[5] = MediaPlayer.create(this,R.raw.window);

    }

    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();

        } else {
            vectormp[posicion].pause();
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this,R.raw.audiod);
            vectormp[1] = MediaPlayer.create(this,R.raw.audiods);
            vectormp[2] = MediaPlayer.create(this,R.raw.audiop);
            vectormp[3] = MediaPlayer.create(this,R.raw.audiouy);
            vectormp[4] = MediaPlayer.create(this,R.raw.huio);
            vectormp[5] = MediaPlayer.create(this,R.raw.window);
            posicion = 0;
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    public void Repetir(View view){
        if(repetir == 1){
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;

        } else {
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    public void Siguiente (View view) {
        if (posicion < vectormp.length - 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

            } else {
                posicion++;
            }

        } else {
            Toast.makeText(this, "No hay mas archivos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Anterior(View view) {
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this,R.raw.audiod);
                vectormp[1] = MediaPlayer.create(this,R.raw.audiods);
                vectormp[2] = MediaPlayer.create(this,R.raw.audiop);
                vectormp[3] = MediaPlayer.create(this,R.raw.audiouy);
                vectormp[4] = MediaPlayer.create(this,R.raw.huio);
                vectormp[5] = MediaPlayer.create(this,R.raw.window);
                posicion--;

                vectormp[posicion].start();

            } else {
                posicion--;
            }
        }else{

        }
    }

}

