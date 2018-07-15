package Juego;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmRegistro extends javax.swing.JFrame {
 ArrayList<Object> jugadores = new ArrayList<>();
 ArrayList<ClsJugador> players= new ArrayList<>();
 
    int cont = 0;
    ClsControlador controller = new ClsControlador();    

    public FrmRegistro() {
        initComponents();
        this.setLocationRelativeTo(null);
        jugadores = controller.extraerObjeto("jugadores.dat");
        llenarCombo();
        llenarGrid();
        if (jugadores.size() > 0) {
            ClsJugador ultimo = (ClsJugador) jugadores.get(jugadores.size()-1);
            cont = ultimo.getId()+1;
        }
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        
    }
    
        public void limpiar() {
        txfNombre.setText(null);
        txfApellido.setText(null);
        txfCedula.setText(null);
        txfUsuario.setText(null);
        btnregistrar.setEnabled(true);
    }

    public void llenarCombo() {
        if (jugadores.size() > 0) {
            cbbJugador.setEnabled(true);
            jugadores = controller.extraerObjeto("jugadores.dat");
       
            cbbJugador.setModel(new javax.swing.DefaultComboBoxModel(jugadores.toArray()));
        } else {
            cbbJugador.setEnabled(false);
        }
    }

    public void llenarGrid() {
        if (jugadores.size() > 0) {
            ClsJugador jug;
            DefaultTableModel model = (DefaultTableModel) jtbjugadores.getModel();
            for (int i = 0; i < jugadores.size(); i++) {
                jug = (ClsJugador) jugadores.get(i);
                Object jugadoresG[] = {jug.getId(), jug.getNombre(), jug.getApellido(),jug.getCedula(), jug.getUsuario(),jug.getVictorias()};
                model.insertRow(i, jugadoresG);

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanPrincipal = new javax.swing.JPanel();
        PanNomCed = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfCedula = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        PanTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbjugadores = new javax.swing.JTable();
        PanBotones = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        cbbJugador = new javax.swing.JComboBox();
        btSelecPersonajes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PanNomCed.setBackground(new java.awt.Color(255, 255, 255));
        PanNomCed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNombre.setText("Nombre:");

        lblCedula.setText("Cédula: ");

        lblApellido.setText("Apellido:");

        lblUsuario.setText("Usuario:");

        javax.swing.GroupLayout PanNomCedLayout = new javax.swing.GroupLayout(PanNomCed);
        PanNomCed.setLayout(PanNomCedLayout);
        PanNomCedLayout.setHorizontalGroup(
            PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanNomCedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        PanNomCedLayout.setVerticalGroup(
            PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanNomCedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addGap(15, 15, 15)
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula)
                    .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanNomCedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        PanTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtbjugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Apellido", "Cédula", "Usuario", "Victorias"
            }
        ));
        jScrollPane1.setViewportView(jtbjugadores);

        javax.swing.GroupLayout PanTablaLayout = new javax.swing.GroupLayout(PanTabla);
        PanTabla.setLayout(PanTablaLayout);
        PanTablaLayout.setHorizontalGroup(
            PanTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanTablaLayout.setVerticalGroup(
            PanTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/guardar.gif"))); // NOI18N
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/editar.jpg"))); // NOI18N
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/eliminar.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanBotonesLayout = new javax.swing.GroupLayout(PanBotones);
        PanBotones.setLayout(PanBotonesLayout);
        PanBotonesLayout.setHorizontalGroup(
            PanBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        PanBotonesLayout.setVerticalGroup(
            PanBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbJugadorActionPerformed(evt);
            }
        });

        btSelecPersonajes.setText("Ir a seleccionar personajes");
        btSelecPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecPersonajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanPrincipalLayout = new javax.swing.GroupLayout(PanPrincipal);
        PanPrincipal.setLayout(PanPrincipalLayout);
        PanPrincipalLayout.setHorizontalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanPrincipalLayout.createSequentialGroup()
                        .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbJugador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanNomCed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(106, Short.MAX_VALUE))))
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btSelecPersonajes)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanPrincipalLayout.setVerticalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanNomCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btSelecPersonajes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        ClsJugador jugador = new ClsJugador(cont,txfNombre.getText(),txfApellido.getText(),txfCedula.getText(),txfUsuario.getText());
        cont++;
        jugadores.add(jugador);
        controller.escribirObjeto("jugadores.dat", jugadores);
        jugadores = controller.extraerObjeto("jugadores.dat");
        limpiar();
        llenarCombo();
        Object jugadoresG[]={jugador.getId(),jugador.getNombre(),jugador.getApellido(),
            jugador.getCedula(), jugador.getUsuario(),jugador.getVictorias()};
        DefaultTableModel model = (DefaultTableModel) jtbjugadores.getModel();
        model.addRow(jugadoresG);
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        ClsJugador jugadorSeleccionado = (ClsJugador) cbbJugador.getSelectedItem();
        jugadorSeleccionado.setNombre(txfNombre.getText());
        jugadorSeleccionado.setApellido(txfApellido.getText());
        jugadorSeleccionado.setCedula(txfCedula.getText());
        jugadorSeleccionado.setUsuario(txfUsuario.getText());
        Object jugadoresG[] = {jugadorSeleccionado.getId(), jugadorSeleccionado.getNombre(),
            jugadorSeleccionado.getApellido(),jugadorSeleccionado.getCedula(), jugadorSeleccionado.getUsuario()};
        DefaultTableModel model = (DefaultTableModel) jtbjugadores.getModel();
        model.removeRow(cbbJugador.getSelectedIndex());
        
        jugadores.remove(cbbJugador.getSelectedIndex());
        model.insertRow(cbbJugador.getSelectedIndex(), jugadoresG);
        jugadores.add(cbbJugador.getSelectedIndex(), jugadorSeleccionado);
        controller.escribirObjeto("jugadores.dat", jugadores); 
        llenarCombo();
        limpiar();
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        ClsJugador jugadorSeleccionado = (ClsJugador) cbbJugador.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) jtbjugadores.getModel();
        model.removeRow(cbbJugador.getSelectedIndex());
        jugadores.remove(jugadorSeleccionado);
        for (int i = 0; i < jugadores.size(); i++) {
            players.add((ClsJugador) jugadores.get(i));
        }
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getId()!=i){
                cont=i;
                break;
            }
        }
        if(jugadores.size()==0){
            cont=0;            
        }

        controller.escribirObjeto("jugadores.dat", jugadores); 
        llenarCombo();
        limpiar();
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void cbbJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbJugadorActionPerformed
        ClsJugador jugadorSeleccionado = (ClsJugador) cbbJugador.getSelectedItem();
        txfNombre.setText(jugadorSeleccionado.getNombre());
        txfApellido.setText(jugadorSeleccionado.getApellido());
        txfCedula.setText(jugadorSeleccionado.getCedula());
        txfUsuario.setText(jugadorSeleccionado.getUsuario());
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnregistrar.setEnabled(false);
        
    }//GEN-LAST:event_cbbJugadorActionPerformed

    private void btSelecPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecPersonajesActionPerformed
        FrmSeleccion seleccion= new FrmSeleccion();
        this.setVisible(false);
        seleccion.setVisible(true);
    }//GEN-LAST:event_btSelecPersonajesActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanBotones;
    private javax.swing.JPanel PanNomCed;
    private javax.swing.JPanel PanPrincipal;
    private javax.swing.JPanel PanTabla;
    private javax.swing.JButton btSelecPersonajes;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox cbbJugador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbjugadores;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfCedula;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
