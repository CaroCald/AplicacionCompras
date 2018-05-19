package com.example.usrgam.aplicacioncompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Modelo.Usuario;
import Modelo.Zapatos;

public class Main3Activity extends AppCompatActivity {
    Button botonComprar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        if(getIntent().getExtras()!=null)
        {
            if(getIntent().getExtras().getSerializable("zapato")!=null){
                ((TextView) findViewById(R.id.descripcionProducto)).setText(getIntent().getExtras().getSerializable("zapato").toString());
            }
            else if(getIntent().getExtras().getSerializable("zapatoG")!=null){
                ((TextView) findViewById(R.id.descripcionProducto)).setText(getIntent().getExtras().getSerializable("zapatoG").toString());

            }
            else if(getIntent().getExtras().getString("zapatoInvitado")!=null){
                ((TextView) findViewById(R.id.descripcionProducto)).setText(getIntent().getExtras().getString("zapatoInvitado"));
            }

        }

        botonComprar = (Button) findViewById(R.id.Comprar);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getIntent().getExtras()!=null)
                {
                    if(getIntent().getExtras().getSerializable("idUsuarioCompra")!=null){
                        Toast.makeText(getApplicationContext(), "Ha comprado el producto ", Toast.LENGTH_LONG).show();
                    }
                    else if(getIntent().getExtras().getSerializable("idUsuarioGCompra")!=null){
                        Toast.makeText(getApplicationContext(), "Ha comprado el producto", Toast.LENGTH_LONG).show();
                    }
                    else if(getIntent().getExtras().getSerializable("invitado")!=null){
                        Toast.makeText(getApplicationContext(), "No esta registrado  ", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });
    }


}
