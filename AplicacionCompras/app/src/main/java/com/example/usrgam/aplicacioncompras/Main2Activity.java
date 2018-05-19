package com.example.usrgam.aplicacioncompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import Control.controlArchivos;
import Modelo.Zapatos;

public class Main2Activity extends AppCompatActivity {
    ListView lista;
    ArrayAdapter<Zapatos> adapter;
    Zapatos[] datos=new Zapatos[]{};
    private controlArchivos control = new controlArchivos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lista = (ListView) findViewById(R.id.listaZapatos);
        cargarLista();
        control.escribirArchivo(datos, "zapato.p");
        //Zapatos p = control.leerArchivo("zapato.p");
        adapter = new ArrayAdapter<Zapatos>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, datos);
        lista.setAdapter(adapter);

        //EVENTOS EN LA LISTA

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent =null;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {

                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(android.view.MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.verUsuario:
                                if(getIntent().getExtras()!=null){
                                    if(getIntent().getExtras().getSerializable("idUsuario")!=null){
                                        intent = new Intent(getApplicationContext(), Main3Activity.class);
                                        intent.putExtra("zapato", datos[i]);
                                        intent.putExtra("idUsuarioCompra", getIntent().getExtras().
                                                getSerializable("idUsuario"));
                                        startActivity(intent);
                                        return true;
                                    }
                                    else if(getIntent().getExtras().getSerializable("usuarioGmail")!=null){
                                        intent = new Intent(getApplicationContext(), Main3Activity.class);
                                        intent.putExtra("zapatoG", datos[i]);
                                        intent.putExtra("idUsuarioGCompra", getIntent().getExtras().
                                                getSerializable("usuarioGmail"));
                                        startActivity(intent);
                                        return true;
                                    }


                                }


                            case R.id.comprarUsuario:
                                Toast.makeText(getApplicationContext(), "Comprar", Toast.LENGTH_LONG).show();
                                return true;

                            case R.id.modificarUsuario:
                                Toast.makeText(getApplicationContext(), "Modificar", Toast.LENGTH_LONG).show();
                                return true;

                            default:
                                return false;

                        }
                    }
                });

                popupMenu.inflate(R.menu.menu_usuario); //que menu quiero que se despliegue
                popupMenu.show();
            }
        });

    }

    public void cargarLista() {

        datos = new Zapatos[30];
        for (int i = 0; i <30; i++) {
            datos [i]= new Zapatos("Zapato " + i, "10" + i);
        }
    }
}
