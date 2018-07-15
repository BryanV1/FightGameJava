package Juego;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsControlador {

    public void crearFichero(String nombreFichero) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            oos.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void escribirObjeto(String nombreFichero, ArrayList<Object> elementos) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            for (int i = 0; i < elementos.size(); i++) {
                oos.writeObject(elementos.get(i));
            }
            oos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public ArrayList<Object> extraerObjeto(String nombreFichero) {
        ArrayList<Object> elementos = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero));
            Object aux = ois.readObject();
            while (aux != null) {
                elementos.add(aux);
                aux = ois.readObject();
            }
            ois.close();

        } catch (FileNotFoundException ex) {
            crearFichero(nombreFichero);

        } catch (EOFException ex) {
            

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return elementos;
    }

}
