package Juego;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmSeleccion extends javax.swing.JFrame {
ArrayList<Object> jugadores = new ArrayList<>();
ClsControlador control= new ClsControlador();
ArrayList<Object> personajes= new ArrayList<>();
ArrayList<ClsEscenario> escenarios= new ArrayList<>();

ClsPersonaje personajeSeleccionado;
ClsJugador player1, player2;
int p1,p2,c1,c2,esc;
boolean p1Ready=false, p2Ready=false;
ClsPersonaje person=new ClsPersonaje();
ClsEscenario background;

    public FrmSeleccion() {
        initComponents();

        this.setLocationRelativeTo(null);
        jugadores = control.extraerObjeto("jugadores.dat");
        jugadoresImagenVacia();
        llenarCombos();
        crearPersonajes();
        String nombreFondo="";
        for (int i = 1; i <=13; i++) {
            nombreFondo=String.valueOf(i);
           ImageIcon base= new ImageIcon(getClass().getResource("Imagenes/"+nombreFondo+".gif"));
           ClsEscenario escenar= new ClsEscenario(nombreFondo,base);
           escenarios.add(escenar);
        }
        cbbEscenario.setModel(new javax.swing.DefaultComboBoxModel(escenarios.toArray()));
        cbbEscenario.setSelectedIndex(0);
          
    }
    
    public void jugadoresImagenVacia(){
        ImageIcon empty= new ImageIcon(getClass().getResource("Imagenes/inter.png"));
        ImageIcon vacio= new ImageIcon(empty.getImage().getScaledInstance(lblP1.getWidth(),lblP1.getHeight(),
            Image.SCALE_DEFAULT));
        lblP1.setIcon(vacio);
        lblP2.setIcon(vacio);
    }
    
    public void llenarCombos(){
        cbbP1.setModel(new javax.swing.DefaultComboBoxModel(jugadores.toArray()));        
        cbbP2.setModel(new javax.swing.DefaultComboBoxModel(jugadores.toArray()));
    }
    
    public void jugadoresListos(){
        if(p1Ready==true && p2Ready==true){
            btEmpezar.setEnabled(true);
        }
    }
    
    public ImageIcon agregarImagen(String nombreImagen){
        ImageIcon base= new ImageIcon(getClass().getResource("Imagenes/"+nombreImagen+".png"));
        return base;
    }
    
    public ImageIcon imagenEtiqueta(){
        ImageIcon personaje= new ImageIcon(personajeSeleccionado.getImagen().getImage().getScaledInstance(
            lblP1.getWidth(),lblP1.getHeight(), Image.SCALE_DEFAULT));
        return personaje;
    }
    
    public void crearPersonajes(){
        ClsPersonaje blastoise = new ClsAgua(0,"Blastoise",agregarImagen("Blastoise"));
        ClsPersonaje bulbasaur = new ClsTierra(1,"Bulbasaur",agregarImagen("Bulbasaur"));
        ClsPersonaje patamon = new ClsAire(2,"Patamon",agregarImagen("Patamon"));
        ClsPersonaje greymon = new ClsFuego(3,"Greymon",agregarImagen("Greymon"));
        personajes.add(blastoise);
        personajes.add(bulbasaur);
        personajes.add(patamon);
        personajes.add(greymon);
        control.escribirObjeto("personajes.dat",personajes);
        cbbPersonaje.setModel(new javax.swing.DefaultComboBoxModel(personajes.toArray()));
        cbbPersonaje.setSelectedItem(blastoise);
    }
    
    public boolean personajeJugadorIguales(){
        if(player1==player2||player1.getPersonaje()==player2.getPersonaje()){
            JOptionPane.showMessageDialog(null,"Los personajes y usuarios deben ser diferentes, "
                    + "cambiélos e intente de nuevo");
            btEmpezar.setEnabled(false);
            return false;
        }
        return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanPrincipal = new javax.swing.JPanel();
        PanP1 = new javax.swing.JPanel();
        cbbP1 = new javax.swing.JComboBox<>();
        btP1 = new javax.swing.JButton();
        lblP1 = new javax.swing.JLabel();
        PanPersonaje = new javax.swing.JPanel();
        btEmpezar = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();
        cbbPersonaje = new javax.swing.JComboBox<>();
        lblPersonaje = new javax.swing.JLabel();
        PanP2 = new javax.swing.JPanel();
        cbbP2 = new javax.swing.JComboBox<>();
        btP2 = new javax.swing.JButton();
        lblP2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSeleccioneEscenario = new javax.swing.JLabel();
        cbbEscenario = new javax.swing.JComboBox<>();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanP1.setBackground(new java.awt.Color(0, 102, 204));
        PanP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbP1ActionPerformed(evt);
            }
        });

        btP1.setText("Seleccionar \nJugador 1");
        btP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanP1Layout = new javax.swing.GroupLayout(PanP1);
        PanP1.setLayout(PanP1Layout);
        PanP1Layout.setHorizontalGroup(
            PanP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanP1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbP1, 0, 145, Short.MAX_VALUE)
                    .addComponent(btP1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        PanP1Layout.setVerticalGroup(
            PanP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanP1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbbP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblP1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btP1)
                .addGap(23, 23, 23))
        );

        PanPersonaje.setBackground(new java.awt.Color(0, 102, 0));
        PanPersonaje.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btEmpezar.setText("Empezar");
        btEmpezar.setEnabled(false);
        btEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpezarActionPerformed(evt);
            }
        });

        btRegistrar.setText("Registrar ");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        cbbPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPersonajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanPersonajeLayout = new javax.swing.GroupLayout(PanPersonaje);
        PanPersonaje.setLayout(PanPersonajeLayout);
        PanPersonajeLayout.setHorizontalGroup(
            PanPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanPersonajeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRegistrar)
                    .addComponent(btEmpezar))
                .addGap(71, 71, 71))
            .addGroup(PanPersonajeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cbbPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(PanPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanPersonajeLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lblPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );
        PanPersonajeLayout.setVerticalGroup(
            PanPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPersonajeLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(cbbPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btEmpezar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRegistrar)
                .addContainerGap())
            .addGroup(PanPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanPersonajeLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(lblPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addGap(71, 71, 71)))
        );

        PanP2.setBackground(new java.awt.Color(204, 0, 0));
        PanP2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbP2ActionPerformed(evt);
            }
        });

        btP2.setText("Seleccionar  Jugador 2");
        btP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanP2Layout = new javax.swing.GroupLayout(PanP2);
        PanP2.setLayout(PanP2Layout);
        PanP2Layout.setHorizontalGroup(
            PanP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanP2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbP2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btP2))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(PanP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanP2Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lblP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );
        PanP2Layout.setVerticalGroup(
            PanP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanP2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbbP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(btP2)
                .addGap(20, 20, 20))
            .addGroup(PanP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanP2Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(lblP2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addGap(62, 62, 62)))
        );

        lblTitulo.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        lblTitulo.setText("POO BATTLE PRO");

        lblSeleccioneEscenario.setText("Escenario");

        cbbEscenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbEscenarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanPrincipalLayout = new javax.swing.GroupLayout(PanPrincipal);
        PanPrincipal.setLayout(PanPrincipalLayout);
        PanPrincipalLayout.setHorizontalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSeleccioneEscenario)
                            .addComponent(PanP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanPersonaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbEscenario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanPrincipalLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanPrincipalLayout.setVerticalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanPrincipalLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccioneEscenario)
                    .addComponent(cbbEscenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        FrmRegistro registro = new FrmRegistro();
        this.setVisible(false);
        registro.setVisible(true);
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void cbbPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPersonajeActionPerformed
        personajeSeleccionado=(ClsPersonaje)cbbPersonaje.getSelectedItem();
        lblPersonaje.setIcon(imagenEtiqueta());
    }//GEN-LAST:event_cbbPersonajeActionPerformed

    private void btP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btP1ActionPerformed
        lblP1.setIcon(imagenEtiqueta());
        if(player1==null){
            player1=(ClsJugador)jugadores.get(0);
        }
        player1.setPersonaje(personajeSeleccionado);
        p1=player1.getId();
        c1=player1.getPersonaje().getId();
        p1Ready=true;
        jugadoresListos();
    }//GEN-LAST:event_btP1ActionPerformed

    private void btP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btP2ActionPerformed
        lblP2.setIcon(imagenEtiqueta());
        if(player2==null){
            player2=(ClsJugador)jugadores.get(0);
        }
        player2.setPersonaje(personajeSeleccionado);
        p2=player2.getId();
        c2=player2.getPersonaje().getId();
        p2Ready=true;
        jugadoresListos();
    }//GEN-LAST:event_btP2ActionPerformed

    private void cbbP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbP1ActionPerformed
        player1=(ClsJugador) cbbP1.getSelectedItem();
        cbbP2.setModel(new javax.swing.DefaultComboBoxModel(jugadores.toArray()));
        cbbP2.removeItem(player1);
        cbbP2.setSelectedItem(player2);
        
    }//GEN-LAST:event_cbbP1ActionPerformed

    private void cbbP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbP2ActionPerformed
        player2=(ClsJugador) cbbP2.getSelectedItem();
        cbbP1.setModel(new javax.swing.DefaultComboBoxModel(jugadores.toArray()));
        cbbP1.removeItem(player2);
        cbbP1.setSelectedItem(player1);
        
    }//GEN-LAST:event_cbbP2ActionPerformed

    private void btEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpezarActionPerformed
        if(personajeJugadorIguales()){
            FrmBatalla battle = new FrmBatalla(p1,c1,p2,c2,esc);
            this.setVisible(false);
            battle.setVisible(true);
        }
    }//GEN-LAST:event_btEmpezarActionPerformed

    private void cbbEscenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbEscenarioActionPerformed
        background=(ClsEscenario)cbbEscenario.getSelectedItem();
        esc= Integer.parseInt(background.getNombre());
        ImageIcon fondo= new ImageIcon(background.getFondo().getImage().getScaledInstance(
            lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_DEFAULT));
        lblFondo.setIcon(fondo);
    }//GEN-LAST:event_cbbEscenarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSeleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanP1;
    private javax.swing.JPanel PanP2;
    private javax.swing.JPanel PanPersonaje;
    private javax.swing.JPanel PanPrincipal;
    private javax.swing.JButton btEmpezar;
    private javax.swing.JButton btP1;
    private javax.swing.JButton btP2;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbbEscenario;
    private javax.swing.JComboBox<String> cbbP1;
    private javax.swing.JComboBox<String> cbbP2;
    private javax.swing.JComboBox<String> cbbPersonaje;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblPersonaje;
    private javax.swing.JLabel lblSeleccioneEscenario;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
