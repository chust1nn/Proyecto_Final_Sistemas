package Proyecto;

import java.awt.Image;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


/**
 *
 * @authors Agustin Gonzalez y Leonardo Geldres
 */
public class Probabilidades extends javax.swing.JFrame {

    public Probabilidades() {
        initComponents();
        //Deja la resolucion de la ventana principal en 1280x720
        this.setSize(1280, 760);
        //Deja la ventana en el centro
        setLocationRelativeTo(null); 
        //Deja en logo del programa en la ventana principal
        logoProbabilidades.setIcon(this);
    } 
    
    //Funcion para colocar logo del programa a las ventanas
    public class logoProbabilidades {
        //Llama la imagen del logo que se encuentra en el proyecto y lo guarda en una variable
        private static final Image Icon_Image = new ImageIcon(logoProbabilidades.class.getResource("/Proyecto/Elementos_Proyecto/dados.png")).getImage();
        
        //Coloca la imagen del logo desde la variable
        public static void setIcon(JFrame frame) {
            frame.setIconImage(Icon_Image);
        }
    }
    
    //Configura las ventanas y su manejo
    public class configFrame {
        public static void especificacionesFrame(JFrame frame1, JFrame frame2) {
            logoProbabilidades.setIcon(frame1);
            //Deja la ventana visible
            frame1.setVisible(true);
            frame1.setSize(1280, 760);
            frame1.setLocationRelativeTo(null);
            //Deja de mostrar la ventana que estaba visible
            frame2.setVisible(false);
        }
    } 
    
    //Esta funcion hace que al presionar "Salir" aparezca una ventana emergente para elegir si salir o no de la aplicacion.
    private static void confirmarCierre(JFrame frame) {
        //El texto que aparece en las opciones
        String botones[] = {"Si, no quiero", "No, si quiero"};
        //Para un icono personalizado dentro de la ventana emergente
        ImageIcon emergencia = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/CONFIRMAR_CIERRE.png"));
        //Con esto es posible que la ventana emergente salga luego dar click
        int opcion = JOptionPane.showOptionDialog(frame, "¿Deseas cerrar la aplicación y no aprender probabilidades?", 
                "Confirmar cierre", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, emergencia, botones, botones[0]);
        //Para verificar la confirmacion de salir o no  
        if (opcion == JOptionPane.YES_OPTION) {
            // Realizar acciones antes de cerrar la aplicación si es necesario
            System.exit(0);
        }
        // Si la opción es NO_OPTION o el usuario cierra el diálogo, no hace nada
    }
    
    private String carta1, carta2;

    private void generarCartas(JLabel label, JLabel label1, JLabel label2, JLabel label3) {
        // Genera nuevas cartas
        Random random = new Random();
        carta1 = obtenerCartaAleatoria(random);
        carta2 = obtenerCartaAleatoria(random);

        // Actualiza las etiquetas con las nuevas cartas
        label.setText(carta1);
        label1.setText(carta2);
        label2.setText("");  // Limpiar el resultado de respuesta
        campoResultado.setText("");  // Limpiar el campo de resultado
        label3.setText("");  // Limpiar la respuesta correcta
    }
    
    private void verificarRespuesta(JLabel label, double tolerancia) {
        
        try {
            // Obtiene la respuesta del usuario
            double respuestaUsuario = Double.parseDouble(campoResultado.getText());

            // Calcula el resultado correcto
            double resultadoCorrecto = calcularsumaprobabilidad();

            // Comprueba si la respuesta del usuario es correcta o incorrecta
            if (Math.abs(respuestaUsuario - resultadoCorrecto) <= tolerancia) {
                label.setText("Respuesta Correcta");
            } else {
                label.setText("Respuesta Incorrecta");
            }

        } catch (NumberFormatException ex) {
            label.setText("Entrada inválida. Por favor, ingresa solo números.");
        }
    }
    
    private void verificarRespuesta1(JLabel label, double tolerancia) {
        
        try {
            // Obtiene la respuesta del usuario
            double respuestaUsuario = Double.parseDouble(campoResultado1.getText());

            // Calcula el resultado correcto
            double resultadoCorrecto = calcularmultiplicacionprobabilidad();

            // Comprueba si la respuesta del usuario es correcta o incorrecta
            if (Math.abs(respuestaUsuario - resultadoCorrecto) <= tolerancia) {
                label.setText("Respuesta Correcta");
            } else {
                label.setText("Respuesta Incorrecta");
            }

        } catch (NumberFormatException ex) {
            label.setText("Entrada inválida. Por favor, ingresa solo números.");
        }
    }
    
    private void verificarRespuesta2(JLabel label, double tolerancia) {
        
        try {
            // Obtiene la respuesta del usuario
            double respuestaUsuario = Double.parseDouble(campoResultado2.getText());

            // Calcula el resultado correcto
            double resultadoCorrecto = calcularlaplaceprobabilidad();

            // Comprueba si la respuesta del usuario es correcta o incorrecta
            if (Math.abs(respuestaUsuario - resultadoCorrecto) <= tolerancia) {
                label.setText("Respuesta Correcta");
            } else {
                label.setText("Respuesta Incorrecta");
            }

        } catch (NumberFormatException ex) {
            label.setText("Entrada inválida. Por favor, ingresa solo números.");
        }
    }
    
    private void mostrarRespuestaCorrecta() {
        // Muestra la respuesta correcta
        double resultadoCorrecto = calcularsumaprobabilidad(); 
        LabelRespuestaCorrecta.setText("Respuesta Correcta: " + resultadoCorrecto);
    }
    
    private void mostrarRespuestaCorrecta1() {
        // Muestra la respuesta correcta
        double resultadoCorrecto = calcularmultiplicacionprobabilidad(); 
        LabelRespuestaCorrecta1.setText("Respuesta Correcta: " + resultadoCorrecto);
    }
    
    private void mostrarRespuestaCorrecta2() {
        // Muestra la respuesta correcta
        double resultadoCorrecto = calcularlaplaceprobabilidad(); 
        LabelRespuestaCorrecta2.setText("Respuesta Correcta: " + resultadoCorrecto);
    }
        
    private double calcularmultiplicacionprobabilidad() {
        int cartasTotales = 48;  // Un mazo español tiene 40 cartas

        // Probabilidad de sacar cada carta
        double probabilidadCarta1 = 1.0 / cartasTotales;
        double probabilidadCarta2 = 1.0 / cartasTotales;

        // Multiplica de las probabilidades de sacar carta1 o carta2
        double resultadoCorrecto = probabilidadCarta1 * probabilidadCarta2;

        return resultadoCorrecto;
    }
    
    private double calcularsumaprobabilidad() {
        int cartasTotales = 48;  // Un mazo español tiene 40 cartas

        // Probabilidad de sacar cada carta
        double probabilidadCarta1 = 1.0 / cartasTotales;
        double probabilidadCarta2 = 1.0 / cartasTotales;

        // Suma de las probabilidades de sacar carta1 o carta2
        double resultadoCorrecto = probabilidadCarta1 + probabilidadCarta2;

        return resultadoCorrecto;
    }
    
    private double calcularlaplaceprobabilidad() {
        int cartasTotales = 48;  // Un mazo español tiene 40 cartas

        // Probabilidad de sacar cada carta
        double resultadoCorrecto = 1.0 / cartasTotales;

        return resultadoCorrecto;
    }

    private String obtenerCartaAleatoria(Random random) {
        // Establece las listas de las cartas
        String[] palos = {"Bastos", "Espadas", "Copas", "Oros"};
        String[] figuras = {"Rey", "Sota", "Caballo", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        // Mide el largo de la lista y toma los valores de esta
        String palo = palos[random.nextInt(palos.length)];
        String figura = figuras[random.nextInt(figuras.length)];
        
        // Devuelve los valores que se tomaron de la lista
        return figura + " de " + palo;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciarFrame = new javax.swing.JFrame();
        atrasBoton = new javax.swing.JButton();
        historiaBoton = new javax.swing.JButton();
        teoriaBoton = new javax.swing.JButton();
        ejerciciosBoton = new javax.swing.JButton();
        LabelIniciar = new javax.swing.JLabel();
        creditosFrame = new javax.swing.JFrame();
        atrasBoton1 = new javax.swing.JButton();
        LabelCreditos = new javax.swing.JLabel();
        historiaFrame = new javax.swing.JFrame();
        pag2Boton = new javax.swing.JButton();
        atrasBoton2 = new javax.swing.JButton();
        LabelPag1 = new javax.swing.JLabel();
        LabelHistoria = new javax.swing.JLabel();
        historiaFrame1 = new javax.swing.JFrame();
        pag3Boton = new javax.swing.JButton();
        pag1Boton = new javax.swing.JButton();
        atrasBoton3 = new javax.swing.JButton();
        LabelPag2 = new javax.swing.JLabel();
        LabelHistoria1 = new javax.swing.JLabel();
        historiaFrame2 = new javax.swing.JFrame();
        atrasBoton4 = new javax.swing.JButton();
        pag4Boton = new javax.swing.JButton();
        pag2Boton1 = new javax.swing.JButton();
        LabelPag3 = new javax.swing.JLabel();
        LabelHistoria2 = new javax.swing.JLabel();
        historiaFrame3 = new javax.swing.JFrame();
        atrasBoton5 = new javax.swing.JButton();
        pag3Boton1 = new javax.swing.JButton();
        pag5Boton = new javax.swing.JButton();
        LabelPag4 = new javax.swing.JLabel();
        LabelHistoria3 = new javax.swing.JLabel();
        historiaFrame4 = new javax.swing.JFrame();
        atrasBoton6 = new javax.swing.JButton();
        pag4Boton1 = new javax.swing.JButton();
        LabelPag5 = new javax.swing.JLabel();
        LabelHistoria4 = new javax.swing.JLabel();
        teoriaFrame = new javax.swing.JFrame();
        reglasBoton = new javax.swing.JButton();
        conceptosBoton = new javax.swing.JButton();
        distribucionBoton = new javax.swing.JButton();
        atrasBoton7 = new javax.swing.JButton();
        LabelTeoria = new javax.swing.JLabel();
        reglasFrame = new javax.swing.JFrame();
        atrasBoton8 = new javax.swing.JButton();
        sumaBoton = new javax.swing.JButton();
        multiplicacionBoton = new javax.swing.JButton();
        laplaceBoton = new javax.swing.JButton();
        LabelReglas = new javax.swing.JLabel();
        sumaFrame = new javax.swing.JFrame();
        atrasBoton9 = new javax.swing.JButton();
        ejemploBoton = new javax.swing.JButton();
        LabelSuma = new javax.swing.JLabel();
        ejemplosumaFrame = new javax.swing.JFrame();
        atrasBoton10 = new javax.swing.JButton();
        respuestacorrectaBoton = new javax.swing.JButton();
        nuevoejemploBoton = new javax.swing.JButton();
        campoResultado = new javax.swing.JTextField();
        LabelRespuestaCorrecta = new javax.swing.JLabel();
        LabelResultadoRespuesta = new javax.swing.JLabel();
        LabelCarta1 = new javax.swing.JLabel();
        LabelCarta2 = new javax.swing.JLabel();
        LabelEjemploSuma = new javax.swing.JLabel();
        multiplicacionFrame = new javax.swing.JFrame();
        atrasBoton11 = new javax.swing.JButton();
        ejemploBoton1 = new javax.swing.JButton();
        LabelMultiplicacion = new javax.swing.JLabel();
        ejemplomultiplicacionFrame = new javax.swing.JFrame();
        atrasBoton12 = new javax.swing.JButton();
        campoResultado1 = new javax.swing.JTextField();
        LabelResultadoRespuesta1 = new javax.swing.JLabel();
        LabelRespuestaCorrecta1 = new javax.swing.JLabel();
        LabelCarta3 = new javax.swing.JLabel();
        LabelCarta4 = new javax.swing.JLabel();
        nuevoejemploBoton1 = new javax.swing.JButton();
        respuestacorrectaBoton1 = new javax.swing.JButton();
        LabelEjemploMultiplicacion = new javax.swing.JLabel();
        laplaceFrame = new javax.swing.JFrame();
        atrasBoton13 = new javax.swing.JButton();
        ejemploBoton2 = new javax.swing.JButton();
        LabelLaplace = new javax.swing.JLabel();
        ejemplolaplaceFrame = new javax.swing.JFrame();
        atrasBoton14 = new javax.swing.JButton();
        respuestacorrectaBoton2 = new javax.swing.JButton();
        nuevoejemploBoton2 = new javax.swing.JButton();
        LabelCarta5 = new javax.swing.JLabel();
        LabelRespuestaCorrecta2 = new javax.swing.JLabel();
        LabelResultadoRespuesta2 = new javax.swing.JLabel();
        campoResultado2 = new javax.swing.JTextField();
        LabelEjemploLaplace = new javax.swing.JLabel();
        conceptosFrame = new javax.swing.JFrame();
        atrasBoton15 = new javax.swing.JButton();
        siguienteBoton3 = new javax.swing.JButton();
        LabelConceptos = new javax.swing.JLabel();
        conceptosFrame1 = new javax.swing.JFrame();
        atrasBoton16 = new javax.swing.JButton();
        anteriorBoton4 = new javax.swing.JButton();
        LabelConceptos1 = new javax.swing.JLabel();
        distribucionFrame = new javax.swing.JFrame();
        atrasBoton17 = new javax.swing.JButton();
        ejemploBoton3 = new javax.swing.JButton();
        ejemploBoton4 = new javax.swing.JButton();
        LabelDistribucion = new javax.swing.JLabel();
        ejemplocontinuaFrame = new javax.swing.JFrame();
        atrasBoton18 = new javax.swing.JButton();
        ejemplodiscretaFrame = new javax.swing.JFrame();
        atrasBoton19 = new javax.swing.JButton();
        ejerciciosFrame = new javax.swing.JFrame();
        atrasBoton20 = new javax.swing.JButton();
        iniciarBoton = new javax.swing.JButton();
        salirBoton = new javax.swing.JButton();
        creditosBoton = new javax.swing.JButton();
        LabelProbabilidades = new javax.swing.JLabel();

        iniciarFrame.setIconImage(getIconImage());
        iniciarFrame.setResizable(false);
        iniciarFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBotonActionPerformed(evt);
            }
        });
        iniciarFrame.getContentPane().add(atrasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        historiaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/HISTORIA.png"))); // NOI18N
        historiaBoton.setMaximumSize(new java.awt.Dimension(340, 120));
        historiaBoton.setMinimumSize(new java.awt.Dimension(340, 120));
        historiaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiaBotonActionPerformed(evt);
            }
        });
        iniciarFrame.getContentPane().add(historiaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 340, 120));

        teoriaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/TEORIA.png"))); // NOI18N
        teoriaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teoriaBotonActionPerformed(evt);
            }
        });
        iniciarFrame.getContentPane().add(teoriaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 340, 120));

        ejerciciosBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJERCICIOS.png"))); // NOI18N
        ejerciciosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejerciciosBotonActionPerformed(evt);
            }
        });
        iniciarFrame.getContentPane().add(ejerciciosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 340, 120));

        LabelIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PROBABILIDADES background.png"))); // NOI18N
        iniciarFrame.getContentPane().add(LabelIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        creditosFrame.setIconImage(getIconImage());
        creditosFrame.setMinimumSize(new java.awt.Dimension(1280, 720));
        creditosFrame.setResizable(false);
        creditosFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton1.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton1.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton1ActionPerformed(evt);
            }
        });
        creditosFrame.getContentPane().add(atrasBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        LabelCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CREDITOS into.png"))); // NOI18N
        creditosFrame.getContentPane().add(LabelCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        historiaFrame.setIconImage(getIconImage());
        historiaFrame.setResizable(false);
        historiaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pag2Boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 2.png"))); // NOI18N
        pag2Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag2BotonActionPerformed(evt);
            }
        });
        historiaFrame.getContentPane().add(pag2Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, 120, 60));

        atrasBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS w.png"))); // NOI18N
        atrasBoton2.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton2.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton2ActionPerformed(evt);
            }
        });
        historiaFrame.getContentPane().add(atrasBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        LabelPag1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPag1.setForeground(new java.awt.Color(0, 0, 0));
        LabelPag1.setText("1");
        historiaFrame.getContentPane().add(LabelPag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 20, 30));

        LabelHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/Historia 1.jpg"))); // NOI18N
        historiaFrame.getContentPane().add(LabelHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        historiaFrame1.setIconImage(getIconImage());
        historiaFrame1.setResizable(false);
        historiaFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pag3Boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 3.png"))); // NOI18N
        pag3Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3BotonActionPerformed(evt);
            }
        });
        historiaFrame1.getContentPane().add(pag3Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 120, 60));

        pag1Boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 1.png"))); // NOI18N
        pag1Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag1BotonActionPerformed(evt);
            }
        });
        historiaFrame1.getContentPane().add(pag1Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 120, 60));

        atrasBoton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton3.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton3.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton3ActionPerformed(evt);
            }
        });
        historiaFrame1.getContentPane().add(atrasBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        LabelPag2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPag2.setForeground(new java.awt.Color(0, 0, 0));
        LabelPag2.setText("2");
        historiaFrame1.getContentPane().add(LabelPag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 20, 30));

        LabelHistoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/HISTORIA 2.jpg"))); // NOI18N
        historiaFrame1.getContentPane().add(LabelHistoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        historiaFrame2.setIconImage(getIconImage());
        historiaFrame2.setResizable(false);
        historiaFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS w.png"))); // NOI18N
        atrasBoton4.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton4.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton4ActionPerformed(evt);
            }
        });
        historiaFrame2.getContentPane().add(atrasBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        pag4Boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 4.png"))); // NOI18N
        pag4Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag4BotonActionPerformed(evt);
            }
        });
        historiaFrame2.getContentPane().add(pag4Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, 120, 60));

        pag2Boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 2.png"))); // NOI18N
        pag2Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag2Boton1ActionPerformed(evt);
            }
        });
        historiaFrame2.getContentPane().add(pag2Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 120, 60));

        LabelPag3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPag3.setForeground(new java.awt.Color(0, 0, 0));
        LabelPag3.setText("3");
        historiaFrame2.getContentPane().add(LabelPag3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 20, 30));

        LabelHistoria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/HISTORIA 3.jpg"))); // NOI18N
        historiaFrame2.getContentPane().add(LabelHistoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        historiaFrame3.setIconImage(getIconImage());
        historiaFrame3.setResizable(false);
        historiaFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton5.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton5.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton5ActionPerformed(evt);
            }
        });
        historiaFrame3.getContentPane().add(atrasBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        pag3Boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 3.png"))); // NOI18N
        pag3Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3Boton1ActionPerformed(evt);
            }
        });
        historiaFrame3.getContentPane().add(pag3Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 120, 60));

        pag5Boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 5.png"))); // NOI18N
        pag5Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag5BotonActionPerformed(evt);
            }
        });
        historiaFrame3.getContentPane().add(pag5Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 120, 60));

        LabelPag4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPag4.setForeground(new java.awt.Color(0, 0, 0));
        LabelPag4.setText("4");
        historiaFrame3.getContentPane().add(LabelPag4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 20, 30));

        LabelHistoria3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/HISTORIA 4.jpg"))); // NOI18N
        historiaFrame3.getContentPane().add(LabelHistoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        historiaFrame4.setIconImage(getIconImage());
        historiaFrame4.setResizable(false);
        historiaFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS w.png"))); // NOI18N
        atrasBoton6.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton6.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton6ActionPerformed(evt);
            }
        });
        historiaFrame4.getContentPane().add(atrasBoton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        pag4Boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PAG 4.png"))); // NOI18N
        pag4Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag4Boton1ActionPerformed(evt);
            }
        });
        historiaFrame4.getContentPane().add(pag4Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 120, 60));

        LabelPag5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPag5.setForeground(new java.awt.Color(0, 0, 0));
        LabelPag5.setText("5");
        historiaFrame4.getContentPane().add(LabelPag5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 620, 20, 30));

        LabelHistoria4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/HISTORIA 5.jpg"))); // NOI18N
        historiaFrame4.getContentPane().add(LabelHistoria4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        teoriaFrame.setIconImage(getIconImage());
        teoriaFrame.setResizable(false);
        teoriaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reglasBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/REGLAS boton.png"))); // NOI18N
        reglasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reglasBotonActionPerformed(evt);
            }
        });
        teoriaFrame.getContentPane().add(reglasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 340, 120));

        conceptosBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CONCEPTOS boton.png"))); // NOI18N
        conceptosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conceptosBotonActionPerformed(evt);
            }
        });
        teoriaFrame.getContentPane().add(conceptosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 340, 120));

        distribucionBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/DISTRIBUCION boton.png"))); // NOI18N
        distribucionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distribucionBotonActionPerformed(evt);
            }
        });
        teoriaFrame.getContentPane().add(distribucionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 340, 120));

        atrasBoton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton7.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton7.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton7ActionPerformed(evt);
            }
        });
        teoriaFrame.getContentPane().add(atrasBoton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        LabelTeoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/TEORIA back.jpg"))); // NOI18N
        teoriaFrame.getContentPane().add(LabelTeoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        reglasFrame.setIconImage(getIconImage());
        reglasFrame.setResizable(false);
        reglasFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton8.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton8.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton8ActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(atrasBoton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        sumaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/SUMA boton.png"))); // NOI18N
        sumaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaBotonActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(sumaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 340, 120));

        multiplicacionBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MULTIPLICACION boton.png"))); // NOI18N
        multiplicacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplicacionBotonActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(multiplicacionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 340, 120));

        laplaceBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/LAPLACE boton.png"))); // NOI18N
        laplaceBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laplaceBotonActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(laplaceBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 340, 120));

        LabelReglas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/REGLAS.jpg"))); // NOI18N
        reglasFrame.getContentPane().add(LabelReglas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        sumaFrame.setIconImage(getIconImage());
        sumaFrame.setResizable(false);
        sumaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton9.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton9.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton9ActionPerformed(evt);
            }
        });
        sumaFrame.getContentPane().add(atrasBoton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        ejemploBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBotonActionPerformed(evt);
            }
        });
        sumaFrame.getContentPane().add(ejemploBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, 120, 60));

        LabelSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/SUMA.jpg"))); // NOI18N
        sumaFrame.getContentPane().add(LabelSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ejemplosumaFrame.setIconImage(getIconImage());
        ejemplosumaFrame.setResizable(false);
        ejemplosumaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton10.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton10.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton10ActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(atrasBoton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        respuestacorrectaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MOSTRAR RESPUESTA CORRECTA.png"))); // NOI18N
        respuestacorrectaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestacorrectaBotonActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(respuestacorrectaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 120, 60));

        nuevoejemploBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/NUEVO_EJEMPLO.png"))); // NOI18N
        nuevoejemploBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoejemploBotonActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(nuevoejemploBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        campoResultado.setText("Ingresa un número y haz click en Enter");
        campoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(campoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 230, 30));

        LabelRespuestaCorrecta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 430, 180, 20));

        LabelResultadoRespuesta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelResultadoRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 590, 20));

        LabelCarta1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        LabelCarta1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ejemplosumaFrame.getContentPane().add(LabelCarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 270, 40));

        LabelCarta2.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        LabelCarta2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ejemplosumaFrame.getContentPane().add(LabelCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 300, 40));
        LabelCarta2.setText(carta2);

        LabelEjemploSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO SUMA.jpg"))); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelEjemploSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        multiplicacionFrame.setIconImage(getIconImage());
        multiplicacionFrame.setResizable(false);
        multiplicacionFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton11.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton11.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton11ActionPerformed(evt);
            }
        });
        multiplicacionFrame.getContentPane().add(atrasBoton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        ejemploBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBoton1ActionPerformed(evt);
            }
        });
        multiplicacionFrame.getContentPane().add(ejemploBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 620, 120, 60));

        LabelMultiplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MULTIPLICACION.jpg"))); // NOI18N
        multiplicacionFrame.getContentPane().add(LabelMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ejemplomultiplicacionFrame.setIconImage(getIconImage());
        ejemplomultiplicacionFrame.setResizable(false);
        ejemplomultiplicacionFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton12.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton12.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton12ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(atrasBoton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        campoResultado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultado1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(campoResultado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 230, 30));

        LabelResultadoRespuesta1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelResultadoRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 590, 20));

        LabelRespuestaCorrecta1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelRespuestaCorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 430, 230, 30));

        LabelCarta3.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        LabelCarta3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ejemplomultiplicacionFrame.getContentPane().add(LabelCarta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 300, 40));
        LabelCarta2.setText(carta2);

        LabelCarta4.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        LabelCarta4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ejemplomultiplicacionFrame.getContentPane().add(LabelCarta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 270, 40));

        nuevoejemploBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/NUEVO_EJEMPLO.png"))); // NOI18N
        nuevoejemploBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoejemploBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(nuevoejemploBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        respuestacorrectaBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MOSTRAR RESPUESTA CORRECTA.png"))); // NOI18N
        respuestacorrectaBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestacorrectaBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(respuestacorrectaBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 120, 60));

        LabelEjemploMultiplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO MULTIPLICACION.jpg"))); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelEjemploMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        laplaceFrame.setIconImage(getIconImage());
        laplaceFrame.setResizable(false);
        laplaceFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton13.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton13.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton13ActionPerformed(evt);
            }
        });
        laplaceFrame.getContentPane().add(atrasBoton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        ejemploBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBoton2ActionPerformed(evt);
            }
        });
        laplaceFrame.getContentPane().add(ejemploBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, 120, 60));

        LabelLaplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/LAPLACE.jpg"))); // NOI18N
        laplaceFrame.getContentPane().add(LabelLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ejemplolaplaceFrame.setIconImage(getIconImage());
        ejemplolaplaceFrame.setResizable(false);
        ejemplolaplaceFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton14.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton14.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton14ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(atrasBoton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        respuestacorrectaBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MOSTRAR RESPUESTA CORRECTA.png"))); // NOI18N
        respuestacorrectaBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestacorrectaBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(respuestacorrectaBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 120, 60));

        nuevoejemploBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/NUEVO_EJEMPLO.png"))); // NOI18N
        nuevoejemploBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoejemploBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(nuevoejemploBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        LabelCarta5.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        LabelCarta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ejemplolaplaceFrame.getContentPane().add(LabelCarta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 200, 40));

        LabelRespuestaCorrecta2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelRespuestaCorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 430, 230, 30));

        LabelResultadoRespuesta2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelResultadoRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 590, 20));

        campoResultado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultado2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(campoResultado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 230, 30));

        LabelEjemploLaplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO LAPLACE.jpg"))); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelEjemploLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        conceptosFrame.setIconImage(getIconImage());
        conceptosFrame.setResizable(false);
        conceptosFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton15.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton15.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton15ActionPerformed(evt);
            }
        });
        conceptosFrame.getContentPane().add(atrasBoton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        siguienteBoton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/SIGUIENTE.png"))); // NOI18N
        siguienteBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteBoton3ActionPerformed(evt);
            }
        });
        conceptosFrame.getContentPane().add(siguienteBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 660, 120, 60));

        LabelConceptos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CONCEPTOS 1.jpg"))); // NOI18N
        conceptosFrame.getContentPane().add(LabelConceptos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        conceptosFrame1.setIconImage(getIconImage());
        conceptosFrame1.setResizable(false);
        conceptosFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton16.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton16.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton16ActionPerformed(evt);
            }
        });
        conceptosFrame1.getContentPane().add(atrasBoton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 60));

        anteriorBoton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ANTERIOR.png"))); // NOI18N
        anteriorBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorBoton4ActionPerformed(evt);
            }
        });
        conceptosFrame1.getContentPane().add(anteriorBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 660, 120, 60));

        LabelConceptos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CONCEPTOS 2.jpg"))); // NOI18N
        conceptosFrame1.getContentPane().add(LabelConceptos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        distribucionFrame.setIconImage(getIconImage());
        distribucionFrame.setResizable(false);
        distribucionFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton17.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton17.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton17ActionPerformed(evt);
            }
        });
        distribucionFrame.getContentPane().add(atrasBoton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        ejemploBoton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBoton3ActionPerformed(evt);
            }
        });
        distribucionFrame.getContentPane().add(ejemploBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 120, 60));

        ejemploBoton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBoton4ActionPerformed(evt);
            }
        });
        distribucionFrame.getContentPane().add(ejemploBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, 120, 60));

        LabelDistribucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/VARIABLES.jpg"))); // NOI18N
        distribucionFrame.getContentPane().add(LabelDistribucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ejemplocontinuaFrame.setIconImage(getIconImage());
        ejemplocontinuaFrame.setResizable(false);
        ejemplocontinuaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton18.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton18.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton18ActionPerformed(evt);
            }
        });
        ejemplocontinuaFrame.getContentPane().add(atrasBoton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        ejemplodiscretaFrame.setIconImage(getIconImage());
        ejemplodiscretaFrame.setResizable(false);
        ejemplodiscretaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton19.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton19.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton19ActionPerformed(evt);
            }
        });
        ejemplodiscretaFrame.getContentPane().add(atrasBoton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        ejerciciosFrame.setIconImage(getIconImage());
        ejerciciosFrame.setResizable(false);
        ejerciciosFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton20.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton20.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton20ActionPerformed(evt);
            }
        });
        ejerciciosFrame.getContentPane().add(atrasBoton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/INICIAR.png"))); // NOI18N
        iniciarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 340, 120));

        salirBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/SALIR.png"))); // NOI18N
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        getContentPane().add(salirBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 340, 120));

        creditosBoton.setBackground(new java.awt.Color(153, 255, 255));
        creditosBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CREDITOS.png"))); // NOI18N
        creditosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosBotonActionPerformed(evt);
            }
        });
        getContentPane().add(creditosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 340, 120));

        LabelProbabilidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PROBABILIDADES.jpg"))); // NOI18N
        LabelProbabilidades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(LabelProbabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
    private void iniciarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, this);
    }//GEN-LAST:event_iniciarBotonActionPerformed

    private void creditosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(creditosFrame, this);
    }//GEN-LAST:event_creditosBotonActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        // TODO add your handling code here:
        confirmarCierre(this);
    }//GEN-LAST:event_salirBotonActionPerformed

    private void atrasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(this, iniciarFrame);        
    }//GEN-LAST:event_atrasBotonActionPerformed

    private void historiaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiaBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame, iniciarFrame);      
    }//GEN-LAST:event_historiaBotonActionPerformed

    private void teoriaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teoriaBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(teoriaFrame, iniciarFrame);   
    }//GEN-LAST:event_teoriaBotonActionPerformed

    private void ejerciciosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejerciciosBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejerciciosFrame, iniciarFrame);    
    }//GEN-LAST:event_ejerciciosBotonActionPerformed

    private void atrasBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton1ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(this, creditosFrame);  
    }//GEN-LAST:event_atrasBoton1ActionPerformed

    private void atrasBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton2ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, historiaFrame);  
    }//GEN-LAST:event_atrasBoton2ActionPerformed

    private void pag2BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag2BotonActionPerformed
        // TODO add your handling code here: 
        configFrame.especificacionesFrame(historiaFrame1, historiaFrame);  
    }//GEN-LAST:event_pag2BotonActionPerformed

    private void pag3BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3BotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame2, historiaFrame1);    
    }//GEN-LAST:event_pag3BotonActionPerformed

    private void pag1BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag1BotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame, historiaFrame1);
    }//GEN-LAST:event_pag1BotonActionPerformed

    private void atrasBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton3ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, historiaFrame1);
    }//GEN-LAST:event_atrasBoton3ActionPerformed

    private void atrasBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton4ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, historiaFrame2);
    }//GEN-LAST:event_atrasBoton4ActionPerformed

    private void pag4BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag4BotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame3, historiaFrame2); 
    }//GEN-LAST:event_pag4BotonActionPerformed

    private void pag2Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag2Boton1ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame1, historiaFrame2);  
    }//GEN-LAST:event_pag2Boton1ActionPerformed

    private void atrasBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton5ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, historiaFrame3); 
    }//GEN-LAST:event_atrasBoton5ActionPerformed

    private void pag3Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3Boton1ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame2, historiaFrame3);
    }//GEN-LAST:event_pag3Boton1ActionPerformed

    private void pag5BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag5BotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame4, historiaFrame3); 
    }//GEN-LAST:event_pag5BotonActionPerformed

    private void atrasBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton6ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, historiaFrame4);
    }//GEN-LAST:event_atrasBoton6ActionPerformed

    private void pag4Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag4Boton1ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(historiaFrame3, historiaFrame4); 
    }//GEN-LAST:event_pag4Boton1ActionPerformed

    private void atrasBoton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton7ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, teoriaFrame);
    }//GEN-LAST:event_atrasBoton7ActionPerformed

    private void atrasBoton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton8ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(teoriaFrame, reglasFrame);  
    }//GEN-LAST:event_atrasBoton8ActionPerformed

    private void sumaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(sumaFrame, reglasFrame);
    }//GEN-LAST:event_sumaBotonActionPerformed

    private void multiplicacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplicacionBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(multiplicacionFrame, reglasFrame);
    }//GEN-LAST:event_multiplicacionBotonActionPerformed

    private void laplaceBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laplaceBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(laplaceFrame, reglasFrame);
    }//GEN-LAST:event_laplaceBotonActionPerformed

    private void atrasBoton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton9ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(reglasFrame, sumaFrame); 
    }//GEN-LAST:event_atrasBoton9ActionPerformed

    private void ejemploBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplosumaFrame, sumaFrame);
        generarCartas(LabelCarta1, LabelCarta2, LabelResultadoRespuesta, LabelRespuestaCorrecta);   
    }//GEN-LAST:event_ejemploBotonActionPerformed

    private void atrasBoton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton10ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(sumaFrame, ejemplosumaFrame);
    }//GEN-LAST:event_atrasBoton10ActionPerformed

    private void reglasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reglasBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(reglasFrame, teoriaFrame); 
    }//GEN-LAST:event_reglasBotonActionPerformed

    private void conceptosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conceptosBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(conceptosFrame, teoriaFrame);
    }//GEN-LAST:event_conceptosBotonActionPerformed

    private void distribucionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distribucionBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(distribucionFrame, teoriaFrame);
    }//GEN-LAST:event_distribucionBotonActionPerformed

    private void atrasBoton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton11ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(reglasFrame, multiplicacionFrame); 
    }//GEN-LAST:event_atrasBoton11ActionPerformed

    private void atrasBoton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton12ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(multiplicacionFrame, ejemplomultiplicacionFrame); 
    }//GEN-LAST:event_atrasBoton12ActionPerformed

    private void ejemploBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton1ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplomultiplicacionFrame, multiplicacionFrame);
        generarCartas(LabelCarta3, LabelCarta4, LabelResultadoRespuesta1, LabelRespuestaCorrecta1);
    }//GEN-LAST:event_ejemploBoton1ActionPerformed

    private void atrasBoton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton13ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(reglasFrame, laplaceFrame); 
    }//GEN-LAST:event_atrasBoton13ActionPerformed

    private void ejemploBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton2ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplolaplaceFrame, laplaceFrame);
        generarCartas(LabelCarta5, null, LabelResultadoRespuesta2, LabelRespuestaCorrecta2);
    }//GEN-LAST:event_ejemploBoton2ActionPerformed

    private void atrasBoton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton14ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(laplaceFrame, ejemplolaplaceFrame);
    }//GEN-LAST:event_atrasBoton14ActionPerformed

    private void atrasBoton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton15ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(teoriaFrame, conceptosFrame);
    }//GEN-LAST:event_atrasBoton15ActionPerformed

    private void atrasBoton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton16ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(teoriaFrame, conceptosFrame1); 
    }//GEN-LAST:event_atrasBoton16ActionPerformed

    private void siguienteBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteBoton3ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(conceptosFrame1, conceptosFrame); 
    }//GEN-LAST:event_siguienteBoton3ActionPerformed

    private void anteriorBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorBoton4ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(conceptosFrame, conceptosFrame1); 
    }//GEN-LAST:event_anteriorBoton4ActionPerformed

    private void atrasBoton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton17ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(teoriaFrame, distribucionFrame);
    }//GEN-LAST:event_atrasBoton17ActionPerformed

    private void ejemploBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton3ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplocontinuaFrame, distribucionFrame); 
    }//GEN-LAST:event_ejemploBoton3ActionPerformed

    private void ejemploBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton4ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplodiscretaFrame, distribucionFrame);
    }//GEN-LAST:event_ejemploBoton4ActionPerformed

    private void atrasBoton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton18ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(distribucionFrame, ejemplocontinuaFrame); 
    }//GEN-LAST:event_atrasBoton18ActionPerformed

    private void atrasBoton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton19ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(distribucionFrame, ejemplodiscretaFrame);
    }//GEN-LAST:event_atrasBoton19ActionPerformed

    private void atrasBoton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton20ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(iniciarFrame, ejerciciosFrame); 
    }//GEN-LAST:event_atrasBoton20ActionPerformed

    private void campoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoActionPerformed
        // TODO add your handling code here:
        // Configurar el campo de texto para verificar el resultado al presionar "Enter"    
        verificarRespuesta(LabelResultadoRespuesta, 0.05);
    }//GEN-LAST:event_campoResultadoActionPerformed

    private void respuestacorrectaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBotonActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta();
    }//GEN-LAST:event_respuestacorrectaBotonActionPerformed

    private void nuevoejemploBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoejemploBotonActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta1, LabelCarta2, LabelResultadoRespuesta, LabelRespuestaCorrecta);    
    }//GEN-LAST:event_nuevoejemploBotonActionPerformed

    private void campoResultado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultado1ActionPerformed
        // TODO add your handling code here:
        verificarRespuesta1(LabelResultadoRespuesta1, 4.3403);
    }//GEN-LAST:event_campoResultado1ActionPerformed

    private void nuevoejemploBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoejemploBoton1ActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta3, LabelCarta4, LabelResultadoRespuesta1, LabelRespuestaCorrecta1);
    }//GEN-LAST:event_nuevoejemploBoton1ActionPerformed

    private void respuestacorrectaBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBoton1ActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta1();
    }//GEN-LAST:event_respuestacorrectaBoton1ActionPerformed

    private void respuestacorrectaBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBoton2ActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta2();
    }//GEN-LAST:event_respuestacorrectaBoton2ActionPerformed

    private void nuevoejemploBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoejemploBoton2ActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta5, null, LabelResultadoRespuesta2, LabelRespuestaCorrecta2);
    }//GEN-LAST:event_nuevoejemploBoton2ActionPerformed

    private void campoResultado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultado2ActionPerformed
        // TODO add your handling code here:
        verificarRespuesta2(LabelResultadoRespuesta2, 0.0208);
    }//GEN-LAST:event_campoResultado2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Probabilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Probabilidades().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LabelCarta1;
    public javax.swing.JLabel LabelCarta2;
    public javax.swing.JLabel LabelCarta3;
    public javax.swing.JLabel LabelCarta4;
    public javax.swing.JLabel LabelCarta5;
    private javax.swing.JLabel LabelConceptos;
    private javax.swing.JLabel LabelConceptos1;
    private javax.swing.JLabel LabelCreditos;
    private javax.swing.JLabel LabelDistribucion;
    private javax.swing.JLabel LabelEjemploLaplace;
    private javax.swing.JLabel LabelEjemploMultiplicacion;
    private javax.swing.JLabel LabelEjemploSuma;
    private javax.swing.JLabel LabelHistoria;
    private javax.swing.JLabel LabelHistoria1;
    private javax.swing.JLabel LabelHistoria2;
    private javax.swing.JLabel LabelHistoria3;
    private javax.swing.JLabel LabelHistoria4;
    private javax.swing.JLabel LabelIniciar;
    private javax.swing.JLabel LabelLaplace;
    private javax.swing.JLabel LabelMultiplicacion;
    private javax.swing.JLabel LabelPag1;
    private javax.swing.JLabel LabelPag2;
    private javax.swing.JLabel LabelPag3;
    private javax.swing.JLabel LabelPag4;
    private javax.swing.JLabel LabelPag5;
    private javax.swing.JLabel LabelProbabilidades;
    private javax.swing.JLabel LabelReglas;
    private javax.swing.JLabel LabelRespuestaCorrecta;
    private javax.swing.JLabel LabelRespuestaCorrecta1;
    private javax.swing.JLabel LabelRespuestaCorrecta2;
    private static javax.swing.JLabel LabelResultadoRespuesta;
    private static javax.swing.JLabel LabelResultadoRespuesta1;
    private static javax.swing.JLabel LabelResultadoRespuesta2;
    private javax.swing.JLabel LabelSuma;
    private javax.swing.JLabel LabelTeoria;
    private javax.swing.JButton anteriorBoton4;
    private javax.swing.JButton atrasBoton;
    private javax.swing.JButton atrasBoton1;
    private javax.swing.JButton atrasBoton10;
    private javax.swing.JButton atrasBoton11;
    private javax.swing.JButton atrasBoton12;
    private javax.swing.JButton atrasBoton13;
    private javax.swing.JButton atrasBoton14;
    private javax.swing.JButton atrasBoton15;
    private javax.swing.JButton atrasBoton16;
    private javax.swing.JButton atrasBoton17;
    private javax.swing.JButton atrasBoton18;
    private javax.swing.JButton atrasBoton19;
    private javax.swing.JButton atrasBoton2;
    private javax.swing.JButton atrasBoton20;
    private javax.swing.JButton atrasBoton3;
    private javax.swing.JButton atrasBoton4;
    private javax.swing.JButton atrasBoton5;
    private javax.swing.JButton atrasBoton6;
    private javax.swing.JButton atrasBoton7;
    private javax.swing.JButton atrasBoton8;
    private javax.swing.JButton atrasBoton9;
    public static javax.swing.JTextField campoResultado;
    public static javax.swing.JTextField campoResultado1;
    public static javax.swing.JTextField campoResultado2;
    private javax.swing.JButton conceptosBoton;
    private javax.swing.JFrame conceptosFrame;
    private javax.swing.JFrame conceptosFrame1;
    private javax.swing.JButton creditosBoton;
    private javax.swing.JFrame creditosFrame;
    private javax.swing.JButton distribucionBoton;
    private javax.swing.JFrame distribucionFrame;
    private javax.swing.JButton ejemploBoton;
    private javax.swing.JButton ejemploBoton1;
    private javax.swing.JButton ejemploBoton2;
    private javax.swing.JButton ejemploBoton3;
    private javax.swing.JButton ejemploBoton4;
    private javax.swing.JFrame ejemplocontinuaFrame;
    private javax.swing.JFrame ejemplodiscretaFrame;
    private javax.swing.JFrame ejemplolaplaceFrame;
    private javax.swing.JFrame ejemplomultiplicacionFrame;
    private static javax.swing.JFrame ejemplosumaFrame;
    private javax.swing.JButton ejerciciosBoton;
    private javax.swing.JFrame ejerciciosFrame;
    private javax.swing.JButton historiaBoton;
    private javax.swing.JFrame historiaFrame;
    private javax.swing.JFrame historiaFrame1;
    private javax.swing.JFrame historiaFrame2;
    private javax.swing.JFrame historiaFrame3;
    private javax.swing.JFrame historiaFrame4;
    private javax.swing.JButton iniciarBoton;
    private javax.swing.JFrame iniciarFrame;
    private javax.swing.JButton laplaceBoton;
    private javax.swing.JFrame laplaceFrame;
    private javax.swing.JButton multiplicacionBoton;
    private javax.swing.JFrame multiplicacionFrame;
    private javax.swing.JButton nuevoejemploBoton;
    private javax.swing.JButton nuevoejemploBoton1;
    private javax.swing.JButton nuevoejemploBoton2;
    private javax.swing.JButton pag1Boton;
    private javax.swing.JButton pag2Boton;
    private javax.swing.JButton pag2Boton1;
    private javax.swing.JButton pag3Boton;
    private javax.swing.JButton pag3Boton1;
    private javax.swing.JButton pag4Boton;
    private javax.swing.JButton pag4Boton1;
    private javax.swing.JButton pag5Boton;
    private javax.swing.JButton reglasBoton;
    private javax.swing.JFrame reglasFrame;
    private javax.swing.JButton respuestacorrectaBoton;
    private javax.swing.JButton respuestacorrectaBoton1;
    private javax.swing.JButton respuestacorrectaBoton2;
    private javax.swing.JButton salirBoton;
    private javax.swing.JButton siguienteBoton3;
    private javax.swing.JButton sumaBoton;
    private javax.swing.JFrame sumaFrame;
    private javax.swing.JButton teoriaBoton;
    private javax.swing.JFrame teoriaFrame;
    // End of variables declaration//GEN-END:variables
}