package Juego;

import java.util.ArrayList;

public class FrmEstadisticas extends javax.swing.JFrame {
ArrayList<Object> jugadores= new ArrayList<>();
ClsControlador control = new ClsControlador();
ArrayList<ClsJugador> players= new ArrayList<>();
int victos[]= new int[7];

String nombres="";
String victorias="";
String puntos=" ...........................................\n ";

    public FrmEstadisticas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jugadores=control.extraerObjeto("jugadores.dat");
        
        for (int i = 0; i < 3; i++) {
            puntos=puntos+puntos;
        }
        txaPuntos.setText(puntos);
        for (int i = 0; i < jugadores.size(); i++) {
            players.add((ClsJugador) jugadores.get(i));
        }
        
        for (int i = 0; i < 7; i++) {
            if(players.size()>i){
                victos[i]=players.get(i).getVictorias();               
            }else{
               victos[i]=0;               
            }
        }
        sort(victos);        
        for (int i = 6; i >= 0; i--) {
            victorias=victorias+victos[i]+"\n";
        }
        int cont=0;
        for (int k = 6; k >=0; k--) {
            
                for (int j = 0; j < players.size(); j++) {
                    if(victos[k]==players.get(j).getVictorias()){
                        nombres=nombres+players.get(j).toString()+"\n";
                        players.remove(j);
                        j=players.size();
                        cont++;
                    }
                }
        }
        for(int i=0; i<7-cont;i++){
            nombres = nombres+ "Anonimo\n";
        }

        txaJugadores.setText(nombres);
        txaVictorias.setText(victorias);

    }
    
    public void sort(int arr[]){
    int inner, outer;
    int temp;
 
    int h = 1;
    while (h <= arr.length / 3) {
      h = h * 3 + 1;
    }
    while (h > 0) {
      for (outer = h; outer < arr.length; outer++) {
        temp = arr[outer];
        inner = outer;
 
        while (inner > h - 1 && arr[inner - h] >= temp) {
          arr[inner] = arr[inner - h];
          inner -= h;
        }
        arr[inner] = temp;
      }
      h = (h - 1) / 3;
    }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanPrincipal = new javax.swing.JPanel();
        btSeleccionarPersonajes = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        lblPOO = new javax.swing.JLabel();
        lblEstadisticas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaJugadores = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaPuntos = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaVictorias = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btSeleccionarPersonajes.setText("Selección de personajes");
        btSeleccionarPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarPersonajesActionPerformed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        lblPOO.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPOO.setText("POO");

        lblEstadisticas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEstadisticas.setText("ESTADISTICAS BATTLE PRO ");

        txaJugadores.setEditable(false);
        txaJugadores.setColumns(20);
        txaJugadores.setRows(5);
        jScrollPane1.setViewportView(txaJugadores);

        txaPuntos.setEditable(false);
        txaPuntos.setColumns(20);
        txaPuntos.setRows(5);
        jScrollPane3.setViewportView(txaPuntos);

        txaVictorias.setEditable(false);
        txaVictorias.setColumns(20);
        txaVictorias.setRows(5);
        jScrollPane2.setViewportView(txaVictorias);

        javax.swing.GroupLayout PanPrincipalLayout = new javax.swing.GroupLayout(PanPrincipal);
        PanPrincipal.setLayout(PanPrincipalLayout);
        PanPrincipalLayout.setHorizontalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanPrincipalLayout.createSequentialGroup()
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanPrincipalLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lblPOO))
                    .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanPrincipalLayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(lblEstadisticas))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanPrincipalLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btSeleccionarPersonajes)
                                .addGroup(PanPrincipalLayout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(172, 172, 172))
        );
        PanPrincipalLayout.setVerticalGroup(
            PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanPrincipalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblPOO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSeleccionarPersonajes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSeleccionarPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccionarPersonajesActionPerformed
        FrmSeleccion seleccion= new FrmSeleccion();
        this.setVisible(false);
        seleccion.setVisible(true);
    }//GEN-LAST:event_btSeleccionarPersonajesActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanPrincipal;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btSeleccionarPersonajes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstadisticas;
    private javax.swing.JLabel lblPOO;
    private javax.swing.JTextArea txaJugadores;
    private javax.swing.JTextArea txaPuntos;
    private javax.swing.JTextArea txaVictorias;
    // End of variables declaration//GEN-END:variables
}
