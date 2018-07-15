package Juego;

import javax.swing.ImageIcon;

public class ClsFuego extends ClsPersonaje implements IntHabilidades {

    private final double ENERGIA = 500;
    private final double VIDA = 1300;

    public ClsFuego(int id, String nombre, ImageIcon imagen) {
        super(id, nombre, "Fuego", imagen, 1300, 500, 110, 230);
    }

    @Override
    public double ataque() {
        super.setEstamina(super.getEstamina() - ENERGIA * 0.05);
        return super.getAtaque();
    }

    @Override
    public void defensa() {
        switch (super.getTurno()) {
            case 0:
                super.setEstamina(super.getEstamina() - ENERGIA * 0.25);
                super.setEscudo(true);
                super.setTurno(super.getTurno() + 1);
                break;
            case 3:
                super.setEscudo(false);
                super.setTurno(0);
                break;
            default:
                super.setTurno(super.getTurno() + 1);
                break;
        }
    }

    @Override
    public void curar() {
        super.setEstamina(super.getEstamina() - ENERGIA * 0.20);
        super.setVida(super.getVida() + VIDA * 0.20);

    }

    @Override
    public double ataqueFinal() {
        super.setEstamina(super.getEstamina() - ENERGIA * 0.50);
        return super.getAtaqueFinal();
    }

    @Override
    public void aumentoEstamina10() {
        super.setEstamina(super.getEstamina() + ENERGIA * 0.10);
    }

}
