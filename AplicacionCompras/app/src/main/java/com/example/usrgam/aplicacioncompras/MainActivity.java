package com.example.usrgam.aplicacioncompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import Modelo.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText usuarioText, password;
    private GoogleApiClient googleApiClient;
    private final int CODERC = 9001;
    private Usuario usuario;
    Usuario[] datos;
   // private Usuario usuario;
    //private crearArchivos crearArchivos = new crearArchivos();
    //EditText correo, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioText=(EditText) findViewById(R.id.usuario);
        password=(EditText)findViewById(R.id.password);

        SignInButton botongoogle = (SignInButton) findViewById(R.id.logGmail);
        botongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logeoGmail();
            }
        });

    }
    public void logeoGmail() {

        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signIntent, CODERC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODERC) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount acc = result.getSignInAccount();

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                usuario = new Usuario("" + acc.getDisplayName(), "" + acc.getEmail());
                intent.putExtra("usuarioGmail", usuario);
               // crearArchivos.escribirArchivo(usuario, "usuario.u");
                startActivity(intent);

            } else {
                Toast.makeText(this, "Error en ingreso con GMAIl", Toast.LENGTH_LONG).show();


            }
        }
    }

    public void abrirPantallaDosUsuario(View view){

        if(!usuarioText.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            Usuario usuarioApp = new Usuario("" + usuario, "" + password, "usuario");
            intent.putExtra("idUsuario", usuarioApp.getTipo());
            startActivity(intent);
        }
    }

    public void abrirPantallaInvitado(View view){

        if(usuarioText.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
            Usuario usuarioAppInvitado = new Usuario("" + usuario, "" + password, "usuarioInvitado");
            intent.putExtra("idUsuarioInvitado", usuarioAppInvitado.getTipo());
            startActivity(intent);
        }

    }




}
