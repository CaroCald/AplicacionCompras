package Control;

/**
 * Created by Carolina on 6/5/2018.
 */
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modelo.Usuario;
import Modelo.Zapatos;


public class controlArchivos {


    private File file= Environment.getExternalStorageDirectory();//ambiente del sistema opertativo
    private String ruta=file.getAbsolutePath()+File.separator; //obtengo la ruta del sistema operativo

    public void escribirArchivo(Zapatos [] p, String nombre){
        Log.e("aqui",ruta+nombre);
        try {
            FileOutputStream foa= new FileOutputStream(ruta+nombre, true);
            ObjectOutputStream out = new ObjectOutputStream(foa);
            out.writeObject(p);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            Log.e("error IO", e.toString());
        }
    }

    public Zapatos leerArchivoZ(String nombre){
        Zapatos p=null;

        try {
            FileInputStream fis= new FileInputStream(ruta+nombre);
            ObjectInputStream is= new ObjectInputStream(fis);
            p= (Zapatos) is.readObject();


        } catch (FileNotFoundException e) {
            Log.e("error archivo", e.toString());
        }
        catch (IOException e) {
            Log.e("error IO", e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("error persona", e.toString());
        }


        return p;
    }
    public void escribirArchivo(Usuario p, String nombre){
        try {
            FileOutputStream foa= new FileOutputStream(ruta+nombre, true);
            ObjectOutputStream out = new ObjectOutputStream(foa);
            out.writeObject(p);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            Log.e("error IO", e.toString());
        }
    }
    public Usuario[] leerArchivo(String nombre){
        Usuario p=null;
        Usuario [] datos=null;
        try {
            FileInputStream fis= new FileInputStream(ruta+nombre);
            ObjectInputStream is= new ObjectInputStream(fis);
            while(is!=null){
                p= (Usuario) is.readObject();
                datos= new Usuario[]{p};
                Log.e("objeto", String.valueOf(p));
            }


        } catch (FileNotFoundException e) {
            Log.e("error archivo", e.toString());
        }
        catch (IOException e) {
            Log.e("error IO", e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("error persona", e.toString());
        }

        return datos;
    }
}
