package Juego;

import java.io.Serializable;

public class ClsJugador implements Serializable{
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String usuario;
    private int victorias;
    ClsPersonaje personaje;
    
    public ClsJugador(int id, String nombre, String apellido, String cedula, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        victorias=0;
        personaje=new ClsPersonaje();
    }

    public ClsJugador() {
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public ClsPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(ClsPersonaje personaje) {
        this.personaje = personaje;
    }

}
