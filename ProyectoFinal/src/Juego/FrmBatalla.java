package Juego;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmBatalla extends javax.swing.JFrame {
    
    public static int j1,jp1,j2,jp2,f;
    ClsControlador control = new ClsControlador();
    ArrayList <Object> jugadores= new ArrayList<>();
    ArrayList <Object> personajes= new ArrayList<>();
    ClsJugador player1,player2;
    ClsPersonaje person1,person2;
    String text="";    
    ClsAnimacion animarP1, animarP2;
    double VidaP1,VidaP2,EstaminaP1,EstaminaP2;
    
    public FrmBatalla(int p1, int c1,int p2, int c2,int e) {
        initComponents();
        this.setLocationRelativeTo(null);
        j1=p1;
        jp1=c1;
        j2=p2;
        jp2=c2;
        f=e;
        //aqui se toma una imagen de fondo, se la adecua a las medidas de la
        //etiqueta "Animación" y luego se pasa la imagen a la etiqueta
        ImageIcon fondo = new ImageIcon(getClass().getResource("Imagenes/"+e+".gif"));
        ImageIcon background= new ImageIcon(fondo.getImage().getScaledInstance(
            lblAnimacion.getWidth(),lblAnimacion.getHeight(), Image.SCALE_DEFAULT));
        lblAnimacion.setIcon(background);
        
        jugadores = control.extraerObjeto("jugadores.dat");
        personajes = control.extraerObjeto("personajes.dat");
        player1=(ClsJugador)jugadores.get(p1);
        player2=(ClsJugador)jugadores.get(p2);
        player1.setPersonaje((ClsPersonaje)personajes.get(c1));
        player2.setPersonaje((ClsPersonaje)personajes.get(c2));
        mostrarDatosJugador();
        tipoPersonajes();
                
        VidaP1 = person1.getVida();
        LifeP1.setText("/ "+VidaP1); 
        BarP1.setMaximum((int)VidaP1);
        BarP1.setMinimum(0);
        VidaP2 = person2.getVida();
        LifeP2.setText("/ "+VidaP2); BarP2.setValue((int)VidaP2);
        BarP2.setMaximum((int)VidaP2);
        BarP2.setMinimum(0);
        EstaminaP1 = person1.getEstamina();
        StaminaP1.setText("/ "+EstaminaP1);
        EstaminaP2 = person2.getEstamina();
        StaminaP2.setText("/ "+EstaminaP2);
        turnoP2(false);
        llenarCampos();
        
        lblPlayer1.setIcon(person1.getImagen());
        lblPlayer2.setIcon(person2.getImagen());
        
        animarP1 = new ClsAnimacion(lblPlayer1.getSize());        
        animarP1.setVelocidad(99);
        lblPlayer1.add(animarP1);
        lblPlayer1.repaint();
        animarP2 = new ClsAnimacion(lblPlayer2.getSize());
        animarP2.setVelocidad(99);
        lblPlayer2.add(animarP2);
        lblPlayer2.repaint();
    }
    
    public void ganador(){
        if(person1.getVida()<=0){           
           text=text+"Jugador 2 Ganó \t Jugador 1 Derrotado";
           txaBatalla.setText(text);
           player2.setVictorias(player2.getVictorias()+1);
           jugadores.remove(player2.getId());
           jugadores.add(player2.getId(), player2);
           control.escribirObjeto("jugadores.dat", jugadores);
           JOptionPane.showMessageDialog(null, " Juego Terminado\nJugador 2 Ganador");
            FrmEstadisticas puntajes = new FrmEstadisticas();
            this.setVisible(false);
            puntajes.setVisible(true);
        }
        if(person2.getVida()<=0){
           text=text+"Jugador 1 Ganó \t Jugador 2 Derrotado";
           txaBatalla.setText(text);
           player1.setVictorias(player1.getVictorias()+1);
           jugadores.remove(player1.getId());
           jugadores.add(player1.getId(), player1);
           control.escribirObjeto("jugadores.dat", jugadores);
           JOptionPane.showMessageDialog(null, " Juego Terminado\nJugador 1 Ganador");
            FrmEstadisticas puntajes = new FrmEstadisticas();
            this.setVisible(false);
            puntajes.setVisible(true);
        }
    }
    //mostrarDatosJugador pasa los nombres de los jugadores y de sus personajes
    //a las respectivas etiquetas    
    public void mostrarDatosJugador(){
        lblNombreP1.setText(player1.toString());
        lblNombreP2.setText(player2.toString());
        lblPersonajeP1.setText(player1.getPersonaje().getNombre());
        lblPersonajeP2.setText(player2.getPersonaje().getNombre());
    }
    
   //tipoPersonajes toma el id de los personajes que se encuentran dentro del jugador
    //dependiendo del id, se ejecuta un switch que realiza un casting para determinar
    //los personajes de los jugadores
    public void tipoPersonajes(){
        int p1=player1.getPersonaje().getId();
        int p2=player2.getPersonaje().getId();
        switch(p1){
            case 0: person1=(ClsAgua)player1.getPersonaje();
                break;
            case 1: person1=(ClsTierra)player1.getPersonaje();
                break;
            case 2: person1=(ClsAire)player1.getPersonaje();
                break;
            case 3: person1=(ClsFuego)player1.getPersonaje();
                break;
        }
        switch(p2){
            case 0: person2=(ClsAgua)player2.getPersonaje();
                break;
            case 1: person2=(ClsTierra)player2.getPersonaje();
                break;
            case 2: person2=(ClsAire)player2.getPersonaje();
                break;
            case 3: person2=(ClsFuego)player2.getPersonaje();
                break;
        }
    }
    //defense verifica si el escudo se encuentra esta activado, si esto ocurre se vuelve a
    //ejecutar el método defensa que incrementa un contador interno de la respectiva clase,
    //además que se coloca una imagen de un escudo para avisar al jugador que tiene defensa
    public void defenseP1(){
        if(person1.isEscudo()==true){
            person1.defensa();
            lblEscudo1.setIcon(new ImageIcon(getClass().getResource("Imagenes/shield.png")));
        }
    }
    public void defenseP2(){
        if(person2.isEscudo()==true){
            person2.defensa();
            lblEscudo2.setIcon(new ImageIcon(getClass().getResource("Imagenes/shield.png")));
        }
    }
    //turno desactiva o activa los botones de juego dependiendo del jugador y del turno
    public void turnoP1(boolean p1){
        btAtaqueP1.setEnabled(p1);
        btDefensaP1.setEnabled(p1);
        btCurarP1.setEnabled(p1);
        btAFinalP1.setEnabled(p1);
    }
    public void turnoP2(boolean p2){
        btAtaqueP2.setEnabled(p2);
        btDefensaP2.setEnabled(p2);
        btCurarP2.setEnabled(p2);
        btAFinalP2.setEnabled(p2);
    }
    //llenarCampos llena la vida y estamina de los dos jugadores en los cuadros de texto
    public void llenarCampos(){
        txfVidaP1.setText(String.valueOf(person1.getVida()));
        BarP1.setValue((int)person1.getVida());
        txfEstaminaP1.setText(String.valueOf(person1.getEstamina()));
        txfVidaP2.setText(String.valueOf(person2.getVida()));
        BarP2.setValue((int)person2.getVida());
        txfEstaminaP2.setText(String.valueOf(person2.getEstamina()));
    }
    //comprobarEstamina verifica que exista la suficiente estamina para realizar
    //cierto movimiento, si el botón del método no tiene la suficiente se desactiva
    public void comprobarEstaminaP1(){
        if(person1.getEstamina() < EstaminaP1 * 0.05){
            btAtaqueP1.setEnabled(false);
        }
        if(person1.getEstamina() < EstaminaP1 * 0.25){
            btDefensaP1.setEnabled(false);
        }
        if(person1.getEstamina() < EstaminaP1 * 0.20){
            btCurarP1.setEnabled(false);
        }
        if(person1.getEstamina() < EstaminaP1 * 0.50){
            btAFinalP1.setEnabled(false);
        }
        ganador();
    }
    public void comprobarEstaminaP2(){
        if(person2.getEstamina() < EstaminaP2 * 0.05){
            btAtaqueP2.setEnabled(false);
        }
        if(person2.getEstamina() < EstaminaP2 * 0.25){
            btDefensaP2.setEnabled(false);
        }
        if(person2.getEstamina() < EstaminaP2 * 0.20){
            btCurarP2.setEnabled(false);
        }
        
        if(person2.getEstamina() < EstaminaP2 * 0.50){
            btAFinalP2.setEnabled(false);
        }
        ganador();
    }    
    public void alerta(){
        ImageIcon vacio = new ImageIcon(getClass().getResource("Imagenes/vac.png"));
        lblPlayer1.setIcon(vacio);
        lblPlayer2.setIcon(vacio);
        if(person1.getVida()<=230){
            ImageIcon alert1 = new ImageIcon(getClass().getResource("Imagenes/alerta.gif"));
            lblAlertaP1.setIcon(alert1);
        }else{
            lblAlertaP1.setIcon(vacio);
        }
        if(person2.getVida()<=230){
            ImageIcon alert2 = new ImageIcon(getClass().getResource("Imagenes/alerta.gif"));
            lblAlertaP2.setIcon(alert2);
        }else{
            lblAlertaP2.setIcon(vacio);
        }
    }
    //animarPersonaje utiliza la clase animar la cual recibe el nombre de la carpeta y
    //el personaje, inicia su animación y termina la animación del otro jugador
    public void animarPersonajeP1(String nombreCarpeta){
        alerta();
        animarP1.setUrl("Imagenes/"+person1.getNombre()+"/"+nombreCarpeta+"/");
        animarP1.startAnimation();
        //Esta condición se usa ya que en el primer turno la animación del jugador 2
        //no ha sido iniciada por lo que daría un error si se pone stopAnimation
        if(animarP2.run==true){
          animarP2.stopAnimation();    
        }    }
    public void animarPersonajeP2(String nombreCarpeta){
        alerta();
        animarP2.setUrl("Imagenes/"+person2.getNombre()+"/"+nombreCarpeta+"/");
        animarP2.startAnimation();
        animarP1.stopAnimation();        
    }    
    //areaBattle muestra en el área de texto el nombre del jugador junto con el movimiento
    //que realizó, además de la cantidad si se trata de un ataque
    public void areaBattle(String txt,ClsJugador p, String habilidad){
        text=text+p.toString()+": "+txt+" ( "+habilidad+" ) "+"\n";
        txaBatalla.setText(text);
    }
    //escudoDesactivado sirve para quitar la imagen del escudo colocando una
    //imagen png vacía, se ejecuta cuando el personaje no tiene escudo
    public void escudoDesactivadoP1(){
        if(person1.isEscudo()==false){
           lblEscudo1.setIcon(new ImageIcon(getClass().getResource("Imagenes/vac.png"))); 
        }    }
    public void escudoDesactivadoP2(){
        if(person2.isEscudo()==false){
           lblEscudo2.setIcon(new ImageIcon(getClass().getResource("Imagenes/vac.png"))); 
        }    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanP1 = new javax.swing.JPanel();
        StaminaP1 = new javax.swing.JTextField();
        txfEstaminaP1 = new javax.swing.JTextField();
        lblNombreP1 = new javax.swing.JLabel();
        lblPersonajeP1 = new javax.swing.JLabel();
        lblEstaminaP1 = new javax.swing.JLabel();
        lblVidaP1 = new javax.swing.JLabel();
        txfVidaP1 = new javax.swing.JTextField();
        LifeP1 = new javax.swing.JTextField();
        PanP2 = new javax.swing.JPanel();
        StaminaP2 = new javax.swing.JTextField();
        txfEstaminaP2 = new javax.swing.JTextField();
        lblNombreP2 = new javax.swing.JLabel();
        lblPersonajeP2 = new javax.swing.JLabel();
        lblEstaminaP2 = new javax.swing.JLabel();
        lblVidaP2 = new javax.swing.JLabel();
        LifeP2 = new javax.swing.JTextField();
        txfVidaP2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaBatalla = new javax.swing.JTextArea();
        lblVS = new javax.swing.JLabel();
        lblAlertaP2 = new javax.swing.JLabel();
        lblAlertaP1 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        lblEscudo1 = new javax.swing.JLabel();
        lblEscudo2 = new javax.swing.JLabel();
        BarP1 = new javax.swing.JProgressBar();
        BarP2 = new javax.swing.JProgressBar();
        lblAnimacion = new javax.swing.JLabel();
        PanBotonesP1 = new javax.swing.JPanel();
        btAtaqueP1 = new javax.swing.JButton();
        btDefensaP1 = new javax.swing.JButton();
        btCurarP1 = new javax.swing.JButton();
        btAFinalP1 = new javax.swing.JButton();
        PanBotonesP2 = new javax.swing.JPanel();
        btAtaqueP2 = new javax.swing.JButton();
        btDefensaP2 = new javax.swing.JButton();
        btCurarP2 = new javax.swing.JButton();
        btAFinalP2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanP1.setOpaque(false);
        PanP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StaminaP1.setEditable(false);
        StaminaP1.setBackground(new java.awt.Color(0, 102, 204));
        StaminaP1.setForeground(new java.awt.Color(255, 255, 255));
        PanP1.add(StaminaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 60, -1));

        txfEstaminaP1.setEditable(false);
        PanP1.add(txfEstaminaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, -1));

        lblNombreP1.setBackground(new java.awt.Color(0, 0, 102));
        lblNombreP1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblNombreP1.setForeground(new java.awt.Color(255, 255, 255));
        PanP1.add(lblNombreP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 28));

        lblPersonajeP1.setBackground(new java.awt.Color(0, 0, 102));
        lblPersonajeP1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblPersonajeP1.setForeground(new java.awt.Color(255, 255, 255));
        PanP1.add(lblPersonajeP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 28));

        lblEstaminaP1.setBackground(new java.awt.Color(0, 0, 0));
        lblEstaminaP1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblEstaminaP1.setForeground(new java.awt.Color(255, 255, 255));
        lblEstaminaP1.setText("Estamina:");
        PanP1.add(lblEstaminaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 20));

        lblVidaP1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblVidaP1.setForeground(new java.awt.Color(255, 255, 255));
        lblVidaP1.setText("Vida:");
        PanP1.add(lblVidaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 20));

        txfVidaP1.setEditable(false);
        PanP1.add(txfVidaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        LifeP1.setEditable(false);
        LifeP1.setBackground(new java.awt.Color(0, 102, 204));
        LifeP1.setForeground(new java.awt.Color(255, 255, 255));
        PanP1.add(LifeP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, -1));

        getContentPane().add(PanP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 130));

        PanP2.setOpaque(false);
        PanP2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StaminaP2.setEditable(false);
        StaminaP2.setBackground(new java.awt.Color(204, 0, 0));
        StaminaP2.setForeground(new java.awt.Color(255, 255, 255));
        PanP2.add(StaminaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 60, -1));

        txfEstaminaP2.setEditable(false);
        PanP2.add(txfEstaminaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, -1));

        lblNombreP2.setBackground(new java.awt.Color(0, 0, 102));
        lblNombreP2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblNombreP2.setForeground(new java.awt.Color(255, 255, 255));
        PanP2.add(lblNombreP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 28));

        lblPersonajeP2.setBackground(new java.awt.Color(0, 0, 102));
        lblPersonajeP2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblPersonajeP2.setForeground(new java.awt.Color(255, 255, 255));
        PanP2.add(lblPersonajeP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 28));

        lblEstaminaP2.setBackground(new java.awt.Color(0, 0, 0));
        lblEstaminaP2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblEstaminaP2.setForeground(new java.awt.Color(255, 255, 255));
        lblEstaminaP2.setText("Estamina:");
        PanP2.add(lblEstaminaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 20));

        lblVidaP2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblVidaP2.setForeground(new java.awt.Color(255, 255, 255));
        lblVidaP2.setText("Vida:");
        PanP2.add(lblVidaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 20));

        LifeP2.setEditable(false);
        LifeP2.setBackground(new java.awt.Color(204, 0, 0));
        LifeP2.setForeground(new java.awt.Color(255, 255, 255));
        PanP2.add(LifeP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, -1));

        txfVidaP2.setEditable(false);
        PanP2.add(txfVidaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        getContentPane().add(PanP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 130));

        txaBatalla.setColumns(20);
        txaBatalla.setRows(5);
        jScrollPane1.setViewportView(txaBatalla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 390, 140));

        lblVS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/vs.png"))); // NOI18N
        getContentPane().add(lblVS, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 160, -1, 110));
        getContentPane().add(lblAlertaP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 110, 106));
        getContentPane().add(lblAlertaP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 110, 106));
        getContentPane().add(lblPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 160));

        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPlayer2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 170, 160));
        getContentPane().add(lblEscudo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 80, 90));
        getContentPane().add(lblEscudo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 80, 90));

        BarP1.setBackground(new java.awt.Color(0, 102, 204));
        BarP1.setForeground(new java.awt.Color(0, 102, 204));
        BarP1.setValue(100);
        BarP1.setOpaque(true);
        BarP1.setStringPainted(true);
        getContentPane().add(BarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, -1));

        BarP2.setBackground(new java.awt.Color(204, 0, 0));
        BarP2.setForeground(new java.awt.Color(204, 0, 0));
        BarP2.setValue(100);
        BarP2.setOpaque(true);
        BarP2.setStringPainted(true);
        getContentPane().add(BarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 200, -1));
        getContentPane().add(lblAnimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 680, 360));

        PanBotonesP1.setBackground(new java.awt.Color(0, 102, 204));
        PanBotonesP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btAtaqueP1.setBackground(new java.awt.Color(0, 0, 0));
        btAtaqueP1.setForeground(new java.awt.Color(255, 255, 255));
        btAtaqueP1.setText("Ataque");
        btAtaqueP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtaqueP1ActionPerformed(evt);
            }
        });
        PanBotonesP1.add(btAtaqueP1);

        btDefensaP1.setBackground(new java.awt.Color(0, 0, 0));
        btDefensaP1.setForeground(new java.awt.Color(255, 255, 255));
        btDefensaP1.setText("Defensa");
        btDefensaP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDefensaP1ActionPerformed(evt);
            }
        });
        PanBotonesP1.add(btDefensaP1);

        btCurarP1.setBackground(new java.awt.Color(0, 0, 0));
        btCurarP1.setForeground(new java.awt.Color(255, 255, 255));
        btCurarP1.setText("Curar");
        btCurarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCurarP1ActionPerformed(evt);
            }
        });
        PanBotonesP1.add(btCurarP1);

        btAFinalP1.setBackground(new java.awt.Color(0, 0, 0));
        btAFinalP1.setForeground(new java.awt.Color(255, 255, 255));
        btAFinalP1.setText("Ataque Final");
        btAFinalP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAFinalP1ActionPerformed(evt);
            }
        });
        PanBotonesP1.add(btAFinalP1);

        getContentPane().add(PanBotonesP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, 140));

        PanBotonesP2.setBackground(new java.awt.Color(204, 0, 0));
        PanBotonesP2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btAtaqueP2.setBackground(new java.awt.Color(0, 0, 0));
        btAtaqueP2.setForeground(new java.awt.Color(255, 255, 255));
        btAtaqueP2.setText("Ataque");
        btAtaqueP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtaqueP2ActionPerformed(evt);
            }
        });
        PanBotonesP2.add(btAtaqueP2);

        btDefensaP2.setBackground(new java.awt.Color(0, 0, 0));
        btDefensaP2.setForeground(new java.awt.Color(255, 255, 255));
        btDefensaP2.setText("Defensa");
        btDefensaP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDefensaP2ActionPerformed(evt);
            }
        });
        PanBotonesP2.add(btDefensaP2);

        btCurarP2.setBackground(new java.awt.Color(0, 0, 0));
        btCurarP2.setForeground(new java.awt.Color(255, 255, 255));
        btCurarP2.setText("Curar");
        btCurarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCurarP2ActionPerformed(evt);
            }
        });
        PanBotonesP2.add(btCurarP2);

        btAFinalP2.setBackground(new java.awt.Color(0, 0, 0));
        btAFinalP2.setForeground(new java.awt.Color(255, 255, 255));
        btAFinalP2.setText("Ataque Final");
        btAFinalP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAFinalP2ActionPerformed(evt);
            }
        });
        PanBotonesP2.add(btAFinalP2);

        getContentPane().add(PanBotonesP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 140, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtaqueP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtaqueP1ActionPerformed
        String daño="daño causado: "+person2.daño(person1.ataque());
        animarPersonajeP1("Ataque");
        areaBattle("Usó ataque",player1,daño);
        llenarCampos();        
        turnoP1(false);
        turnoP2(true);
        comprobarEstaminaP2();
        escudoDesactivadoP1();
        defenseP2();
        person2.aumentoEstamina10();        
    }//GEN-LAST:event_btAtaqueP1ActionPerformed

    private void btAtaqueP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtaqueP2ActionPerformed
        String daño="daño causado: "+person1.daño(person2.ataque());
        animarPersonajeP2("Ataque");
        llenarCampos();
        areaBattle("Usó ataque",player2,daño);
        turnoP2(false);
        turnoP1(true);
        comprobarEstaminaP1();
        escudoDesactivadoP2();
        defenseP1();
        person1.aumentoEstamina10();
    }//GEN-LAST:event_btAtaqueP2ActionPerformed

    private void btDefensaP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDefensaP1ActionPerformed
        lblEscudo1.setIcon(new ImageIcon(getClass().getResource("Imagenes/shield.png")));
        person1.setTurno(0);
        person1.defensa();        
        animarPersonajeP1("Defensa");
        llenarCampos();
        areaBattle("Usó defensa",player1,"Escudo activado");
        turnoP1(false);
        turnoP2(true);
        comprobarEstaminaP2();
        person2.aumentoEstamina10();
    }//GEN-LAST:event_btDefensaP1ActionPerformed

    private void btDefensaP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDefensaP2ActionPerformed
        lblEscudo2.setIcon(new ImageIcon(getClass().getResource("Imagenes/shield.png")));
        person2.setTurno(0);
        person2.defensa();
        animarPersonajeP2("Defensa");
        llenarCampos();
        areaBattle("Usó defensa",player2,"Escudo activado");
        turnoP2(false);
        turnoP1(true);
        comprobarEstaminaP1();
        person1.aumentoEstamina10();
    }//GEN-LAST:event_btDefensaP2ActionPerformed

    private void btCurarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCurarP1ActionPerformed
        person1.curar();
        animarPersonajeP1("Curar");
        llenarCampos();
        areaBattle("Usó curación",player1,"aumentó vida: "+VidaP1*0.20);
        turnoP1(false);
        turnoP2(true);
        comprobarEstaminaP2();
        escudoDesactivadoP1();
        defenseP2();
        person2.aumentoEstamina10();
    }//GEN-LAST:event_btCurarP1ActionPerformed

    private void btCurarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCurarP2ActionPerformed
        person2.curar();
        animarPersonajeP2("Curar");
        llenarCampos();
        areaBattle("Usó curación",player2,"aumentó vida: "+VidaP2*0.20);
        turnoP2(false);
        turnoP1(true);
        comprobarEstaminaP1();
        escudoDesactivadoP2();
        defenseP1();        
        person1.aumentoEstamina10();
    }//GEN-LAST:event_btCurarP2ActionPerformed

    private void btAFinalP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAFinalP1ActionPerformed
        String daño="daño causado: "+person2.daño(person1.ataqueFinal());
        animarPersonajeP1("AtaqueFinal");
        llenarCampos();
        areaBattle("Usó ataque final",player1,daño);
        turnoP1(false);
        turnoP2(true);
        comprobarEstaminaP2();
        escudoDesactivadoP1();
        defenseP2();
        person2.aumentoEstamina10();
    }//GEN-LAST:event_btAFinalP1ActionPerformed

    private void btAFinalP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAFinalP2ActionPerformed
        String daño="daño causado: "+person1.daño(person2.ataqueFinal());
        animarPersonajeP2("AtaqueFinal");
        llenarCampos();
        areaBattle("Usó ataque final",player2,daño);
        turnoP2(false);
        turnoP1(true);
        comprobarEstaminaP1();
        escudoDesactivadoP2();
        defenseP1();
        person1.aumentoEstamina10();
    }//GEN-LAST:event_btAFinalP2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBatalla(j1,jp1,j2,jp2,f).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarP1;
    private javax.swing.JProgressBar BarP2;
    private javax.swing.JTextField LifeP1;
    private javax.swing.JTextField LifeP2;
    private javax.swing.JPanel PanBotonesP1;
    private javax.swing.JPanel PanBotonesP2;
    private javax.swing.JPanel PanP1;
    private javax.swing.JPanel PanP2;
    private javax.swing.JTextField StaminaP1;
    private javax.swing.JTextField StaminaP2;
    private javax.swing.JButton btAFinalP1;
    private javax.swing.JButton btAFinalP2;
    private javax.swing.JButton btAtaqueP1;
    private javax.swing.JButton btAtaqueP2;
    private javax.swing.JButton btCurarP1;
    private javax.swing.JButton btCurarP2;
    private javax.swing.JButton btDefensaP1;
    private javax.swing.JButton btDefensaP2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlertaP1;
    private javax.swing.JLabel lblAlertaP2;
    private javax.swing.JLabel lblAnimacion;
    private javax.swing.JLabel lblEscudo1;
    private javax.swing.JLabel lblEscudo2;
    private javax.swing.JLabel lblEstaminaP1;
    private javax.swing.JLabel lblEstaminaP2;
    private javax.swing.JLabel lblNombreP1;
    private javax.swing.JLabel lblNombreP2;
    private javax.swing.JLabel lblPersonajeP1;
    private javax.swing.JLabel lblPersonajeP2;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblVS;
    private javax.swing.JLabel lblVidaP1;
    private javax.swing.JLabel lblVidaP2;
    private javax.swing.JTextArea txaBatalla;
    private javax.swing.JTextField txfEstaminaP1;
    private javax.swing.JTextField txfEstaminaP2;
    private javax.swing.JTextField txfVidaP1;
    private javax.swing.JTextField txfVidaP2;
    // End of variables declaration//GEN-END:variables
}
