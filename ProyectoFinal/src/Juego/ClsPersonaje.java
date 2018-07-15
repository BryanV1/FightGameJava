package Juego;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class ClsPersonaje implements Serializable{
    
    private int id;
    private String nombre;
    private String tipo;
    private ImageIcon imagen;
    private double vida;
    private double estamina;
    private double ataque;
    private double ataqueFinal;
    private boolean escudo;
    private int turno;

    public ClsPersonaje(int id, String nombre, String tipo, ImageIcon imagen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        escudo=false;
        turno=0;
    }

    public ClsPersonaje(int id, String nombre, String tipo, ImageIcon imagen, double vida, 
                        double estamina, double ataque, double ataqueFinal) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.vida = vida;
        this.estamina = estamina;
        this.ataque = ataque;
        this.ataqueFinal = ataqueFinal;
        escudo=false;
        turno=0;
    }

    public ClsPersonaje(){
    }
    
    public String daño(double ataque){
        if(this.isEscudo()==true){
            this.setVida(this.getVida()-ataque*0.75);
            return String.valueOf(ataque*0.75);
        }else{
            this.setVida(this.getVida()-ataque);
            return String.valueOf(ataque);
        }
    }
    
    public void aumentoEstamina10(){        
    }    
    public double ataque(){
        return 0;
    }
    public void defensa(){        
    }
    public void curar(){    
    }
    public double ataqueFinal(){
        return 0;
    }
    
    @Override
    public String toString() {
        return nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getEstamina() {
        return estamina;
    }

    public void setEstamina(double estamina) {
        this.estamina = estamina;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getAtaqueFinal() {
        return ataqueFinal;
    }

    public void setAtaqueFinal(double ataqueFinal) {
        this.ataqueFinal = ataqueFinal;
    }

    public boolean isEscudo() {
        return escudo;
    }

    public void setEscudo(boolean escudo) {
        this.escudo = escudo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
