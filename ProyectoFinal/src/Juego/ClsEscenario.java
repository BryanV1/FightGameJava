package Juego;

import javax.swing.ImageIcon;

public class ClsEscenario {

    private String nombre;
    private ImageIcon fondo;

    public ClsEscenario(String nombre, ImageIcon fondo) {
        this.nombre = nombre;
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return nombre;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageIcon getFondo() {
        return fondo;
    }

    public void setFondo(ImageIcon fondo) {
        this.fondo = fondo;
    }


    
}
