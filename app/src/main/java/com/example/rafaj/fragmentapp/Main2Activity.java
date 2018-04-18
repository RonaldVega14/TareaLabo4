package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView text;
    private TextView text2;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textId);
        text2 = findViewById(R.id.textId2);
        imagen = findViewById(R.id.imagen);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        handleReceivedText(callingIntent);


    }

    private void handleReceivedText(Intent intent){
        Objetos objeto = intent.getExtras().getParcelable("KEY");

        if (text != null && text2 != null){
            text.setText(objeto.getNombre());
            text2.setText(objeto.getDistancia());
            imagen.setImageResource(objeto.getImagen());
        }
    }
}
