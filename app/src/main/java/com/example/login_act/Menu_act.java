package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
    public void GestionPizza(View v)
        {
            Intent i = new Intent(this, firebase_act.class);
            startActivity(i);
        }
    public void Promociones(View v)
    {
        Intent i = new Intent(this, Promociones_act.class);
        startActivity(i);
    }
}