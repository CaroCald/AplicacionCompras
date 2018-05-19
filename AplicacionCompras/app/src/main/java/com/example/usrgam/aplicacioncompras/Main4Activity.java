package com.example.usrgam.aplicacioncompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.PopupMenu;
import android.widget.Toast;

import Modelo.Usuario;
import Modelo.Zapatos;

public class Main4Activity extends AppCompatActivity {
    ListView lista2;
    ArrayAdapter<String> adapter2;
    Zapatos[] datos2;
    String [] zapatoInvitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lista2 = (ListView) findViewById(R.id.listaZapatosInvitado);
        llenarDescripcion();
        cargarLista2();
        adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, zapatoInvitado);
        lista2.setAdapter(adapter2);

        lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent2 = null;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(android.view.MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.ver:
                                intent2 = new Intent(getApplicationContext(), Main3Activity.class);
                                intent2.putExtra("invitado", getIntent().getExtras().getSerializable("idUsuarioInvitado"));
                                intent2.putExtra("zapatoInvitado", zapatoInvitado[i]);
                                startActivity(intent2);
                                return true;

                            case R.id.comprar:
                                Toast.makeText(getApplicationContext(), "Comprar", Toast.LENGTH_LONG).show();
                                return true;

                            default:
                                return false;
                        }
                    }
                });

                popupMenu.inflate(R.menu.popup_menu); //que menu quiero que se despliegue
                popupMenu.show();
            }
        });

    }

    public void llenarDescripcion(){
        cargarLista2();
        zapatoInvitado= new String[datos2.length];
        for(int i=0; i<datos2.length; i++){
            zapatoInvitado[i]=datos2[i].getDescripcion();
        }
    }

    public void cargarLista2() {

        datos2 = new Zapatos[30];
        for (int i = 0; i <30; i++) {
            datos2 [i]= new Zapatos("Zapato " + i, "10" + i);
        }
    }

}
