package Proyecto;

import java.awt.Image;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
    
    public class configDialog {
        public static void especificacionesDialog(JDialog dialog) {
            //Deja la ventana visible
            dialog.setVisible(true);
            dialog.setSize(495, 680);
            dialog.setLocationRelativeTo(null);
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
            // Cierra el programa si la opcion es YES_OPTION (Si, no quiero)
            System.exit(0);
        }
        // Si la opción es NO_OPTION (No, si quiero) o el usuario cierra el diálogo, no hace nada
    }
    
    private String carta1, carta2;

    private void generarCartas(JLabel label, JLabel label1, JLabel label2, JLabel label3, JLabel labeldialog, JLabel labeldialog1, 
            JLabel labeldialog2, JLabel labeldialog3, JLabel labeldialog4, JLabel labeldialog5, JLabel labeldialog6, JLabel labeldialog7, JLabel labeldialog8, 
            JTextField campo, JTextField campo1, JButton respuestacorrecta) {
            
        respuestacorrecta.setVisible(false);
        
        // Genera nuevas cartas
        Random random = new Random();
        carta1 = obtenerCartaAleatoria(random);
        carta2 = obtenerCartaAleatoria(random);

        // Actualiza las etiquetas con las nuevas cartas
        label.setText(carta1);
        
        if (sonIguales(labeldialog, LabelCarta1SucesosDialog)) {
            // Se contruyen los label explicativos con respcto a la suma
            labeldialog.setText("A = "+ carta1);
            labeldialog2.setText("P(" + carta1 + ") = P(A) = ");
            labeldialog2.setIcon(laplaceprobabilidad());
            labeldialog2.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog1.setText("B = " + carta2);
            labeldialog3.setText("P(" + carta2 + ") = P(B) = ");
            labeldialog3.setIcon(laplaceprobabilidad());
            labeldialog3.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog4.setText("P(" + carta1 + " " + "Ó" + " " + carta2 + ") = P(A ∪ B) = P(A) +  P(B) - P(A ∩ B)");
            labeldialog5.setText("= ");
            labeldialog5.setIcon(laplaceprobabilidad());
            labeldialog5.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog6.setText("+ ");
            labeldialog6.setIcon(laplaceprobabilidad());
            labeldialog6.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog7.setText(" - 0 = ");
            labeldialog7.setIcon(sumaprobabilidad1());
            labeldialog7.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog8.setText("= ");
            labeldialog8.setIcon(sumaprobabilidad1());
            labeldialog8.setHorizontalTextPosition(JLabel.LEFT);
        }
        
        if (sonIguales(labeldialog, LabelCarta1SucesosDialog1)) {
            // Se contruyen los label explicativos con respcto a la multiplicacion
            labeldialog.setText("A = "+ carta1);
            labeldialog2.setText("P(" + carta1 + ") = P(A) = ");
            labeldialog2.setIcon(laplaceprobabilidad());
            labeldialog2.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog1.setText("B = " + carta2);
            labeldialog3.setText("P(" + carta2 + ") = P(B) = ");
            labeldialog3.setIcon(laplaceprobabilidad());
            labeldialog3.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog4.setText("P(" + carta1 + " " + "Y" + " " + carta2 + ") = P(A ∩ B) = P(A) *  P(B)");
            labeldialog5.setText("= ");
            labeldialog5.setIcon(laplaceprobabilidad());
            labeldialog5.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog6.setText("* ");
            labeldialog6.setIcon(laplaceprobabilidad());
            labeldialog6.setHorizontalTextPosition(JLabel.LEFT);
            labeldialog7.setText("= ");
            labeldialog7.setIcon(multiplicacionprobabilidad());
            labeldialog7.setHorizontalTextPosition(JLabel.LEFT);
            // Se guarda el label en un label de relleno para que no haya errores
            labeldialog8.setText("");
        }
        
        if (sonIguales(labeldialog, LabelCarta1SucesosDialog2)) {
            // Se contruyen los label explicativos con respcto a laplace
            labeldialog.setText("A = "+ carta1);
            labeldialog2.setText("P(" + carta1 + ") = P(A) = ");
            labeldialog2.setIcon(laplaceprobabilidad());
            labeldialog1.setText("");
            labeldialog3.setText("");
            labeldialog4.setText("");
            labeldialog5.setText("");
            labeldialog6.setText("");
            labeldialog7.setText("");
            labeldialog8.setText("");
        }
        
        label2.setText("");  // Limpia el resultado de respuesta
        campo.setText("");  // Limpia el campo de resultado
        campo1.setText(""); 
        label3.setText("");
        label3.setIcon(null);  
    }
    
    private boolean sonIguales(JLabel labelA, JLabel labelB) {
        // Puedes comparar el texto de los JLabels o cualquier otra propiedad según tus necesidades
        return labelA.getText().equals(labelB.getText());
    }
    
    private void verificarRespuesta(JLabel label, double regla, JTextField campoCasosFavorables, JTextField campoResultadosPosibles, JButton respuestacorrecta) {
        
        try {
            // Obtiene la respuesta del usuario
            double casosFavorables = Double.parseDouble(campoCasosFavorables.getText());
            double resultadosPosibles = Double.parseDouble(campoResultadosPosibles.getText());
            
            // Calcula el resultado correcto
            double resultadoCorrecto = regla;
            
            // Calcula la probabilidad del usuario
            double probabilidadUsuario = casosFavorables / resultadosPosibles;
            
            // Comprueba si la respuesta del usuario es correcta o incorrecta
            if (probabilidadUsuario == resultadoCorrecto) {
                label.setText("Respuesta Correcta");
            } else {
                label.setText("Respuesta Incorrecta, ¿Deseas saber la respuesta correcta?");
                respuestacorrecta.setVisible(true);
            }
            
            // Si la entrada ingresada por el usuario no es valida, le pide que ingrese numeros
        } catch (NumberFormatException ex) {
            label.setText("Entrada inválida. Por favor, ingresa solo números.");
        }
    }

    private double calcularlaplaceprobabilidad() {
        int cartasTotales = 48;  
        return 1.0 / cartasTotales;
    }
    
     private double calcularsumaprobabilidad() {
        // Si las cartas son iguales, la probabilidad es simplemente la probabilidad de sacar una carta
        if (carta1.equals(carta2)) {
            return calcularlaplaceprobabilidad();
        } else {
            // Si las cartas son diferentes, calcula la probabilidad de sacar cada carta y suma
            return calcularlaplaceprobabilidad() + calcularlaplaceprobabilidad();
        }
    }
    
    private double calcularmultiplicacionprobabilidad() {
        // Multiplica de las probabilidades de sacar carta1 o carta2
        double multiplicacion = calcularlaplaceprobabilidad() * calcularlaplaceprobabilidad();
        return multiplicacion;
    }

    private ImageIcon laplaceprobabilidad() {
        ImageIcon laplace = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/LAPLACE CALCULO.png")); 
        return laplace;
    }
    
    private ImageIcon sumaprobabilidad() {
        // Si las cartas son iguales, la probabilidad es simplemente la probabilidad de sacar una carta
        if (carta1.equals(carta2)) {
            return laplaceprobabilidad();
        } else {
            ImageIcon suma = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/SUMA CALCULO.png")); 
            return suma;
        }
    }
    
    private ImageIcon sumaprobabilidad1() {
        ImageIcon suma = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/SUMA CALCULO 1.png")); 
        return suma;
    }
    
    private ImageIcon multiplicacionprobabilidad() {
        ImageIcon multiplicacion = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/MULTIPLICACION CALCULO.png")); 
        return multiplicacion;
    }
    
    private void mostrarRespuestaCorrecta(JLabel LabelRespuesta, ImageIcon regla) {
        ImageIcon resultadoCorrecto = regla; 
        LabelRespuesta.setText("Respuesta Correcta: ");
        LabelRespuesta.setHorizontalTextPosition(JLabel.LEFT);
        LabelRespuesta.setIcon(resultadoCorrecto);
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
        nuevascartasBoton = new javax.swing.JButton();
        explicacionBoton = new javax.swing.JButton();
        verificarrespuestaBoton = new javax.swing.JButton();
        campoResultadoSuma = new javax.swing.JTextField();
        campoResultadoSuma1 = new javax.swing.JTextField();
        LabelRespuestaCorrecta = new javax.swing.JLabel();
        LabelResultadoRespuesta = new javax.swing.JLabel();
        LabelCarta1 = new javax.swing.JLabel();
        LabelCarta2 = new javax.swing.JLabel();
        LabelEjemploSuma = new javax.swing.JLabel();
        explicacionsumaDialog = new javax.swing.JDialog();
        LabelCarta1SucesosDialog = new javax.swing.JLabel();
        LabelCarta2SucesosDialog = new javax.swing.JLabel();
        LabelCarta1RespectivasDialog = new javax.swing.JLabel();
        LabelCarta2RespectivasDialog = new javax.swing.JLabel();
        LabelCarta1o2Dialog = new javax.swing.JLabel();
        LabelSumaLaplace = new javax.swing.JLabel();
        LabelSumaLaplace1 = new javax.swing.JLabel();
        LabelSumaNormal = new javax.swing.JLabel();
        LabelSumaFinal = new javax.swing.JLabel();
        LabelExplicacionSuma = new javax.swing.JLabel();
        multiplicacionFrame = new javax.swing.JFrame();
        atrasBoton11 = new javax.swing.JButton();
        ejemploBoton1 = new javax.swing.JButton();
        LabelMultiplicacion = new javax.swing.JLabel();
        ejemplomultiplicacionFrame = new javax.swing.JFrame();
        atrasBoton12 = new javax.swing.JButton();
        campoResultadoMultiplicacion = new javax.swing.JTextField();
        campoResultadoMultiplicacion1 = new javax.swing.JTextField();
        verificarrespuestaBoton1 = new javax.swing.JButton();
        explicacionBoton1 = new javax.swing.JButton();
        nuevascartasBoton1 = new javax.swing.JButton();
        respuestacorrectaBoton1 = new javax.swing.JButton();
        LabelRespuestaCorrecta1 = new javax.swing.JLabel();
        LabelResultadoRespuesta1 = new javax.swing.JLabel();
        LabelCarta3 = new javax.swing.JLabel();
        LabelCarta4 = new javax.swing.JLabel();
        LabelEjemploMultiplicacion = new javax.swing.JLabel();
        explicacionmultiplicacionDialog = new javax.swing.JDialog();
        LabelCarta1SucesosDialog1 = new javax.swing.JLabel();
        LabelCarta2SucesosDialog1 = new javax.swing.JLabel();
        LabelCarta1RespectivasDialog1 = new javax.swing.JLabel();
        LabelCarta2RespectivasDialog1 = new javax.swing.JLabel();
        LabelCarta1y2Dialog = new javax.swing.JLabel();
        LabelMultiplicacionLaplace = new javax.swing.JLabel();
        LabelMultiplicacionLaplace1 = new javax.swing.JLabel();
        LabelMultiplicacionFinal = new javax.swing.JLabel();
        LabelExplicacionMultiplicacion = new javax.swing.JLabel();
        laplaceFrame = new javax.swing.JFrame();
        atrasBoton13 = new javax.swing.JButton();
        ejemploBoton2 = new javax.swing.JButton();
        LabelLaplace = new javax.swing.JLabel();
        ejemplolaplaceFrame = new javax.swing.JFrame();
        atrasBoton14 = new javax.swing.JButton();
        LabelCarta5 = new javax.swing.JLabel();
        LabelResultadoRespuesta2 = new javax.swing.JLabel();
        LabelRespuestaCorrecta2 = new javax.swing.JLabel();
        respuestacorrectaBoton2 = new javax.swing.JButton();
        nuevascartasBoton2 = new javax.swing.JButton();
        explicacionBoton2 = new javax.swing.JButton();
        verificarrespuestaBoton2 = new javax.swing.JButton();
        campoResultadoLaplace = new javax.swing.JTextField();
        campoResultadoLaplace1 = new javax.swing.JTextField();
        LabelEjemploLaplace = new javax.swing.JLabel();
        explicacionlaplaceDialog = new javax.swing.JDialog();
        LabelCarta1SucesosDialog2 = new javax.swing.JLabel();
        LabelCarta1RespectivasDialog2 = new javax.swing.JLabel();
        LabelExplicacionLaplace = new javax.swing.JLabel();
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
        ejemploBoton5 = new javax.swing.JButton();
        LabelEjemploContinua = new javax.swing.JLabel();
        ejemplonormalFrame = new javax.swing.JFrame();
        atrasBoton23 = new javax.swing.JButton();
        tablaBoton = new javax.swing.JButton();
        comoutilizartablaBoton = new javax.swing.JButton();
        LabelEjemploNormal = new javax.swing.JLabel();
        comoutilizartablaFrame = new javax.swing.JFrame();
        atrasBoton24 = new javax.swing.JButton();
        LabelEjemploNormal1 = new javax.swing.JLabel();
        ejemplodiscretaFrame = new javax.swing.JFrame();
        atrasBoton19 = new javax.swing.JButton();
        permutacionesBoton = new javax.swing.JButton();
        combinacionesBoton = new javax.swing.JButton();
        LabelEjemploDiscreta = new javax.swing.JLabel();
        permutacionesFrame = new javax.swing.JFrame();
        atrasBoton21 = new javax.swing.JButton();
        LabelPermutaciones = new javax.swing.JLabel();
        combinacionesFrame = new javax.swing.JFrame();
        atrasBoton22 = new javax.swing.JButton();
        LabelCombinaciones = new javax.swing.JLabel();
        ejerciciosFrame = new javax.swing.JFrame();
        atrasBoton20 = new javax.swing.JButton();
        ruletareglasBoton = new javax.swing.JButton();
        ruletacombinatoriasBoton = new javax.swing.JButton();
        LabelEjercicios = new javax.swing.JLabel();
        ruletareglasFrame = new javax.swing.JFrame();
        atrasBoton25 = new javax.swing.JButton();
        ruletacombinatoriasFrame = new javax.swing.JFrame();
        atrasBoton26 = new javax.swing.JButton();
        relleno = new javax.swing.JLabel();
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
        reglasFrame.getContentPane().add(sumaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 340, 120));

        multiplicacionBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MULTIPLICACION boton.png"))); // NOI18N
        multiplicacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplicacionBotonActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(multiplicacionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 340, 120));

        laplaceBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/LAPLACE boton.png"))); // NOI18N
        laplaceBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laplaceBotonActionPerformed(evt);
            }
        });
        reglasFrame.getContentPane().add(laplaceBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 340, 120));

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
        ejemplosumaFrame.getContentPane().add(respuestacorrectaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 120, 60));

        nuevascartasBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CAMBIAR CARTAS boton.png"))); // NOI18N
        nuevascartasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevascartasBotonActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(nuevascartasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        explicacionBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION boton.png"))); // NOI18N
        explicacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicacionBotonActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(explicacionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 120, 60));

        verificarrespuestaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/VERIFICAR RESPUESTA boton.png"))); // NOI18N
        verificarrespuestaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarrespuestaBotonActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(verificarrespuestaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 120, 60));

        campoResultadoSuma.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoSuma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoSumaActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(campoResultadoSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 80, 40));

        campoResultadoSuma1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoSuma1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoSuma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoSuma1ActionPerformed(evt);
            }
        });
        ejemplosumaFrame.getContentPane().add(campoResultadoSuma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 80, 40));

        LabelRespuestaCorrecta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 230, 60));

        LabelResultadoRespuesta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelResultadoRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 590, 20));

        LabelCarta1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        LabelCarta1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ejemplosumaFrame.getContentPane().add(LabelCarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 220, 40));

        LabelCarta2.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        LabelCarta2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ejemplosumaFrame.getContentPane().add(LabelCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 220, 40));
        LabelCarta2.setText(carta2);

        LabelEjemploSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO SUMA.jpg"))); // NOI18N
        ejemplosumaFrame.getContentPane().add(LabelEjemploSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        explicacionsumaDialog.setResizable(false);
        explicacionsumaDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        explicacionsumaDialog.getContentPane().add(LabelCarta1SucesosDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 430, 50));
        explicacionsumaDialog.getContentPane().add(LabelCarta2SucesosDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 430, 50));
        explicacionsumaDialog.getContentPane().add(LabelCarta1RespectivasDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 430, 60));
        explicacionsumaDialog.getContentPane().add(LabelCarta2RespectivasDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 430, 60));
        explicacionsumaDialog.getContentPane().add(LabelCarta1o2Dialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 440, 30));
        explicacionsumaDialog.getContentPane().add(LabelSumaLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 50, 40));
        explicacionsumaDialog.getContentPane().add(LabelSumaLaplace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 50, 40));
        explicacionsumaDialog.getContentPane().add(LabelSumaNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 70, 40));
        explicacionsumaDialog.getContentPane().add(LabelSumaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 50, 40));

        LabelExplicacionSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION SUMA.jpg"))); // NOI18N
        explicacionsumaDialog.getContentPane().add(LabelExplicacionSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 640));

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

        campoResultadoMultiplicacion.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoMultiplicacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoMultiplicacionActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(campoResultadoMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 80, 40));

        campoResultadoMultiplicacion1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoMultiplicacion1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoMultiplicacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoMultiplicacion1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(campoResultadoMultiplicacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 80, 40));

        verificarrespuestaBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/VERIFICAR RESPUESTA boton.png"))); // NOI18N
        verificarrespuestaBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarrespuestaBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(verificarrespuestaBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 120, 60));

        explicacionBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION boton.png"))); // NOI18N
        explicacionBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicacionBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(explicacionBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 120, 60));

        nuevascartasBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CAMBIAR CARTAS boton.png"))); // NOI18N
        nuevascartasBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevascartasBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(nuevascartasBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        respuestacorrectaBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MOSTRAR RESPUESTA CORRECTA.png"))); // NOI18N
        respuestacorrectaBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestacorrectaBoton1ActionPerformed(evt);
            }
        });
        ejemplomultiplicacionFrame.getContentPane().add(respuestacorrectaBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 120, 60));

        LabelRespuestaCorrecta1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelRespuestaCorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 230, 60));

        LabelResultadoRespuesta1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelResultadoRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 590, 20));

        LabelCarta3.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        LabelCarta3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ejemplomultiplicacionFrame.getContentPane().add(LabelCarta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 220, 40));

        LabelCarta4.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        LabelCarta4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ejemplomultiplicacionFrame.getContentPane().add(LabelCarta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 220, 40));
        LabelCarta2.setText(carta2);

        LabelEjemploMultiplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO MULTIPLICACION.jpg"))); // NOI18N
        ejemplomultiplicacionFrame.getContentPane().add(LabelEjemploMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        explicacionmultiplicacionDialog.setResizable(false);
        explicacionmultiplicacionDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        explicacionmultiplicacionDialog.getContentPane().add(LabelCarta1SucesosDialog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 430, 50));
        explicacionmultiplicacionDialog.getContentPane().add(LabelCarta2SucesosDialog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 430, 50));
        explicacionmultiplicacionDialog.getContentPane().add(LabelCarta1RespectivasDialog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 430, 60));
        explicacionmultiplicacionDialog.getContentPane().add(LabelCarta2RespectivasDialog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 430, 60));
        explicacionmultiplicacionDialog.getContentPane().add(LabelCarta1y2Dialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 440, 30));
        explicacionmultiplicacionDialog.getContentPane().add(LabelMultiplicacionLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 50, 40));
        explicacionmultiplicacionDialog.getContentPane().add(LabelMultiplicacionLaplace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 50, 40));
        explicacionmultiplicacionDialog.getContentPane().add(LabelMultiplicacionFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 90, 40));

        LabelExplicacionMultiplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION MULTIPLICACION.jpg"))); // NOI18N
        explicacionmultiplicacionDialog.getContentPane().add(LabelExplicacionMultiplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 640));

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

        LabelCarta5.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 16)); // NOI18N
        LabelCarta5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ejemplolaplaceFrame.getContentPane().add(LabelCarta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 220, 40));

        LabelResultadoRespuesta2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelResultadoRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 590, 20));

        LabelRespuestaCorrecta2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelRespuestaCorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 230, 60));

        respuestacorrectaBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/MOSTRAR RESPUESTA CORRECTA.png"))); // NOI18N
        respuestacorrectaBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestacorrectaBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(respuestacorrectaBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 120, 60));

        nuevascartasBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/CAMBIAR CARTAS boton.png"))); // NOI18N
        nuevascartasBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevascartasBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(nuevascartasBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 120, 60));

        explicacionBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION boton.png"))); // NOI18N
        explicacionBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicacionBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(explicacionBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 120, 60));

        verificarrespuestaBoton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/VERIFICAR RESPUESTA boton.png"))); // NOI18N
        verificarrespuestaBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarrespuestaBoton2ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(verificarrespuestaBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 120, 60));

        campoResultadoLaplace.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoLaplace.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoLaplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoLaplaceActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(campoResultadoLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 80, 40));

        campoResultadoLaplace1.setFont(new java.awt.Font("FiraCode Nerd Font", 0, 18)); // NOI18N
        campoResultadoLaplace1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResultadoLaplace1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoResultadoLaplace1ActionPerformed(evt);
            }
        });
        ejemplolaplaceFrame.getContentPane().add(campoResultadoLaplace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 80, 40));

        LabelEjemploLaplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO LAPLACE.jpg"))); // NOI18N
        ejemplolaplaceFrame.getContentPane().add(LabelEjemploLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        explicacionlaplaceDialog.setResizable(false);
        explicacionlaplaceDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        explicacionlaplaceDialog.getContentPane().add(LabelCarta1SucesosDialog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 430, 50));
        explicacionlaplaceDialog.getContentPane().add(LabelCarta1RespectivasDialog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 430, 50));

        LabelExplicacionLaplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EXPLICACION LAPLACE.jpg"))); // NOI18N
        explicacionlaplaceDialog.getContentPane().add(LabelExplicacionLaplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

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

        ejemploBoton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO.jpg"))); // NOI18N
        ejemploBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejemploBoton5ActionPerformed(evt);
            }
        });
        ejemplocontinuaFrame.getContentPane().add(ejemploBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 120, 60));

        LabelEjemploContinua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO DISTRIBUCION CONTINUA.jpg"))); // NOI18N
        ejemplocontinuaFrame.getContentPane().add(LabelEjemploContinua, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ejemplonormalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton23.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton23.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton23ActionPerformed(evt);
            }
        });
        ejemplonormalFrame.getContentPane().add(atrasBoton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        tablaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/TABLA boton.png"))); // NOI18N
        tablaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaBotonActionPerformed(evt);
            }
        });
        ejemplonormalFrame.getContentPane().add(tablaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 120, 60));

        comoutilizartablaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/TABLA EJEMPLO boton.png"))); // NOI18N
        ejemplonormalFrame.getContentPane().add(comoutilizartablaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 440, 120, 60));

        LabelEjemploNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO DISTRIBUCION NORMAL.jpg"))); // NOI18N
        ejemplonormalFrame.getContentPane().add(LabelEjemploNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        comoutilizartablaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton24.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton24.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton24ActionPerformed(evt);
            }
        });
        comoutilizartablaFrame.getContentPane().add(atrasBoton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        LabelEjemploNormal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/COMO UTILIZAR TABLA.jpg"))); // NOI18N
        comoutilizartablaFrame.getContentPane().add(LabelEjemploNormal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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

        permutacionesBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PERMUTACIONES boton.png"))); // NOI18N
        permutacionesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permutacionesBotonActionPerformed(evt);
            }
        });
        ejemplodiscretaFrame.getContentPane().add(permutacionesBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 120, 60));

        combinacionesBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/COMBINACIONES boton.png"))); // NOI18N
        combinacionesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combinacionesBotonActionPerformed(evt);
            }
        });
        ejemplodiscretaFrame.getContentPane().add(combinacionesBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 120, 60));

        LabelEjemploDiscreta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJEMPLO DISCRETA.jpg"))); // NOI18N
        ejemplodiscretaFrame.getContentPane().add(LabelEjemploDiscreta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        permutacionesFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton21.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton21.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton21ActionPerformed(evt);
            }
        });
        permutacionesFrame.getContentPane().add(atrasBoton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        LabelPermutaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/PERMUTACIONES.jpg"))); // NOI18N
        permutacionesFrame.getContentPane().add(LabelPermutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        combinacionesFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton22.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton22.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton22ActionPerformed(evt);
            }
        });
        combinacionesFrame.getContentPane().add(atrasBoton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        LabelCombinaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/COMBINACIONES.jpg"))); // NOI18N
        combinacionesFrame.getContentPane().add(LabelCombinaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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

        ruletareglasBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJERCICIOS REGLAS boton.png"))); // NOI18N
        ruletareglasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruletareglasBotonActionPerformed(evt);
            }
        });
        ejerciciosFrame.getContentPane().add(ruletareglasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 340, 120));

        ruletacombinatoriasBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJERCICIOS COMBINATORIAS boton.png"))); // NOI18N
        ruletacombinatoriasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruletacombinatoriasBotonActionPerformed(evt);
            }
        });
        ejerciciosFrame.getContentPane().add(ruletacombinatoriasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 340, 120));

        LabelEjercicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/EJERCICIOS.jpg"))); // NOI18N
        ejerciciosFrame.getContentPane().add(LabelEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        ruletareglasFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton25.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton25.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton25ActionPerformed(evt);
            }
        });
        ruletareglasFrame.getContentPane().add(atrasBoton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        ruletacombinatoriasFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasBoton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto/Elementos_Proyecto/ATRAS.png"))); // NOI18N
        atrasBoton26.setMaximumSize(new java.awt.Dimension(120, 60));
        atrasBoton26.setMinimumSize(new java.awt.Dimension(120, 60));
        atrasBoton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBoton26ActionPerformed(evt);
            }
        });
        ruletacombinatoriasFrame.getContentPane().add(atrasBoton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

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
        generarCartas(LabelCarta1, LabelCarta2, LabelResultadoRespuesta, LabelRespuestaCorrecta, 
                LabelCarta1SucesosDialog,LabelCarta2SucesosDialog, LabelCarta1RespectivasDialog,
                LabelCarta2RespectivasDialog, LabelCarta1o2Dialog, LabelSumaLaplace, LabelSumaLaplace1,
                LabelSumaNormal, LabelSumaFinal, campoResultadoSuma, campoResultadoSuma1, respuestacorrectaBoton);
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
        generarCartas(LabelCarta3, LabelCarta4, LabelResultadoRespuesta1, LabelRespuestaCorrecta1, 
                LabelCarta1SucesosDialog1,LabelCarta2SucesosDialog1, LabelCarta1RespectivasDialog1,
                LabelCarta2RespectivasDialog1, LabelCarta1y2Dialog, LabelMultiplicacionLaplace, LabelMultiplicacionLaplace1,
                LabelMultiplicacionFinal, relleno, campoResultadoMultiplicacion, campoResultadoMultiplicacion1, respuestacorrectaBoton1);
    }//GEN-LAST:event_ejemploBoton1ActionPerformed

    private void atrasBoton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton13ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(reglasFrame, laplaceFrame); 
    }//GEN-LAST:event_atrasBoton13ActionPerformed

    private void ejemploBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton2ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplolaplaceFrame, laplaceFrame);
        generarCartas(LabelCarta5, relleno, LabelResultadoRespuesta2, LabelRespuestaCorrecta2, 
                LabelCarta1SucesosDialog2,relleno, LabelCarta1RespectivasDialog2,
                relleno, relleno, relleno, relleno,
                relleno, relleno, campoResultadoLaplace, campoResultadoLaplace1, respuestacorrectaBoton2);
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

    private void campoResultadoSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoSumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoSumaActionPerformed

    private void respuestacorrectaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBotonActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta(LabelRespuestaCorrecta, sumaprobabilidad());
    }//GEN-LAST:event_respuestacorrectaBotonActionPerformed

    private void nuevascartasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevascartasBotonActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta1, LabelCarta2, LabelResultadoRespuesta, LabelRespuestaCorrecta, 
                LabelCarta1SucesosDialog,LabelCarta2SucesosDialog, LabelCarta1RespectivasDialog,
                LabelCarta2RespectivasDialog, LabelCarta1o2Dialog, LabelSumaLaplace, LabelSumaLaplace1,
                LabelSumaNormal, LabelSumaFinal, campoResultadoSuma, campoResultadoSuma1, respuestacorrectaBoton);
    }//GEN-LAST:event_nuevascartasBotonActionPerformed

    private void permutacionesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permutacionesBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(permutacionesFrame, ejemplodiscretaFrame);
    }//GEN-LAST:event_permutacionesBotonActionPerformed

    private void combinacionesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combinacionesBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(combinacionesFrame, ejemplodiscretaFrame);
    }//GEN-LAST:event_combinacionesBotonActionPerformed

    private void atrasBoton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton21ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplodiscretaFrame, permutacionesFrame);
    }//GEN-LAST:event_atrasBoton21ActionPerformed

    private void atrasBoton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton22ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplodiscretaFrame, combinacionesFrame);
    }//GEN-LAST:event_atrasBoton22ActionPerformed

    private void ejemploBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejemploBoton5ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplonormalFrame, ejemplocontinuaFrame);
    }//GEN-LAST:event_ejemploBoton5ActionPerformed

    private void atrasBoton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton23ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejemplocontinuaFrame, ejemplonormalFrame);
    }//GEN-LAST:event_atrasBoton23ActionPerformed

    private void tablaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaBotonActionPerformed
        // TODO add your handling code here:
        // El texto que aparece en la opcion
        String boton[] = {"OK"};
        // Para un icono personalizado dentro de la ventana emergente
        ImageIcon tabla = new ImageIcon(Probabilidades.class.getResource("/Proyecto/Elementos_Proyecto/TABLA.png"));
        // Crear un JDialog en lugar de usar JOptionPane
        JDialog dialogo = new JDialog(ejemplonormalFrame, "TABLA DE DISTRIBUCIÓN NORMAL", true);
        // Con esto es posible que la ventana emergente salga luego dar click
        int opcion1 = JOptionPane.showOptionDialog(dialogo, null, "TABLA DE DISTRIBUCIÓN NORMAL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, tabla, boton, boton[0]);
        // Si la opción es OK o el usuario cierra el diálogo, no hace nada
        if (opcion1 == 0) {
            // Cierra la ventana
            dialogo.dispose();
        }
    }//GEN-LAST:event_tablaBotonActionPerformed

    private void atrasBoton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton24ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(comoutilizartablaFrame, ejemplonormalFrame);
    }//GEN-LAST:event_atrasBoton24ActionPerformed

    private void explicacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explicacionBotonActionPerformed
        // TODO add your handling code here:
        configDialog.especificacionesDialog(explicacionsumaDialog);
    }//GEN-LAST:event_explicacionBotonActionPerformed

    private void verificarrespuestaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarrespuestaBotonActionPerformed
        // TODO add your handling code here:
        verificarRespuesta(LabelResultadoRespuesta, calcularsumaprobabilidad(), campoResultadoSuma, campoResultadoSuma1, respuestacorrectaBoton);
    }//GEN-LAST:event_verificarrespuestaBotonActionPerformed

    private void campoResultadoSuma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoSuma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoSuma1ActionPerformed

    private void campoResultadoMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoMultiplicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoMultiplicacionActionPerformed

    private void campoResultadoMultiplicacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoMultiplicacion1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_campoResultadoMultiplicacion1ActionPerformed

    private void verificarrespuestaBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarrespuestaBoton1ActionPerformed
        // TODO add your handling code here:
        verificarRespuesta(LabelResultadoRespuesta1, calcularmultiplicacionprobabilidad(), campoResultadoMultiplicacion, campoResultadoMultiplicacion1, respuestacorrectaBoton1);
    }//GEN-LAST:event_verificarrespuestaBoton1ActionPerformed

    private void explicacionBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explicacionBoton1ActionPerformed
        // TODO add your handling code here:
        configDialog.especificacionesDialog(explicacionmultiplicacionDialog);
    }//GEN-LAST:event_explicacionBoton1ActionPerformed

    private void nuevascartasBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevascartasBoton1ActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta3, LabelCarta4, LabelResultadoRespuesta1, LabelRespuestaCorrecta1, 
                LabelCarta1SucesosDialog1,LabelCarta2SucesosDialog1, LabelCarta1RespectivasDialog1,
                LabelCarta2RespectivasDialog1, LabelCarta1y2Dialog, LabelMultiplicacionLaplace, LabelMultiplicacionLaplace1,
                LabelMultiplicacionFinal, relleno, campoResultadoMultiplicacion, campoResultadoMultiplicacion1, respuestacorrectaBoton1);
    }//GEN-LAST:event_nuevascartasBoton1ActionPerformed

    private void respuestacorrectaBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBoton1ActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta(LabelRespuestaCorrecta1, multiplicacionprobabilidad());
    }//GEN-LAST:event_respuestacorrectaBoton1ActionPerformed

    private void respuestacorrectaBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestacorrectaBoton2ActionPerformed
        // TODO add your handling code here:
        mostrarRespuestaCorrecta(LabelRespuestaCorrecta2, laplaceprobabilidad());
    }//GEN-LAST:event_respuestacorrectaBoton2ActionPerformed

    private void nuevascartasBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevascartasBoton2ActionPerformed
        // TODO add your handling code here:
        generarCartas(LabelCarta5, relleno, LabelResultadoRespuesta2, LabelRespuestaCorrecta2, 
                LabelCarta1SucesosDialog2,relleno, LabelCarta1RespectivasDialog2,
                relleno, relleno, relleno, relleno,
                relleno, relleno, campoResultadoLaplace, campoResultadoLaplace1, respuestacorrectaBoton2);
    
    }//GEN-LAST:event_nuevascartasBoton2ActionPerformed

    private void explicacionBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explicacionBoton2ActionPerformed
        // TODO add your handling code here:
        explicacionlaplaceDialog.setVisible(true);
        explicacionlaplaceDialog.setSize(495, 470);
        explicacionlaplaceDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_explicacionBoton2ActionPerformed

    private void verificarrespuestaBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarrespuestaBoton2ActionPerformed
        // TODO add your handling code here:
        verificarRespuesta(LabelResultadoRespuesta2, calcularlaplaceprobabilidad(), campoResultadoLaplace, campoResultadoLaplace1, respuestacorrectaBoton2);
    }//GEN-LAST:event_verificarrespuestaBoton2ActionPerformed

    private void campoResultadoLaplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoLaplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoLaplaceActionPerformed

    private void campoResultadoLaplace1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoResultadoLaplace1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoResultadoLaplace1ActionPerformed

    private void atrasBoton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton25ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejerciciosFrame, ruletareglasFrame);
    }//GEN-LAST:event_atrasBoton25ActionPerformed

    private void atrasBoton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBoton26ActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ruletareglasFrame, ejerciciosFrame);
    }//GEN-LAST:event_atrasBoton26ActionPerformed

    private void ruletareglasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruletareglasBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ruletareglasFrame, ejerciciosFrame);
    }//GEN-LAST:event_ruletareglasBotonActionPerformed

    private void ruletacombinatoriasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruletacombinatoriasBotonActionPerformed
        // TODO add your handling code here:
        configFrame.especificacionesFrame(ejerciciosFrame, ruletacombinatoriasFrame);
    }//GEN-LAST:event_ruletacombinatoriasBotonActionPerformed

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
    private javax.swing.JLabel LabelCarta1RespectivasDialog;
    private javax.swing.JLabel LabelCarta1RespectivasDialog1;
    private javax.swing.JLabel LabelCarta1RespectivasDialog2;
    private javax.swing.JLabel LabelCarta1SucesosDialog;
    private javax.swing.JLabel LabelCarta1SucesosDialog1;
    private javax.swing.JLabel LabelCarta1SucesosDialog2;
    private javax.swing.JLabel LabelCarta1o2Dialog;
    private javax.swing.JLabel LabelCarta1y2Dialog;
    public javax.swing.JLabel LabelCarta2;
    private javax.swing.JLabel LabelCarta2RespectivasDialog;
    private javax.swing.JLabel LabelCarta2RespectivasDialog1;
    private javax.swing.JLabel LabelCarta2SucesosDialog;
    private javax.swing.JLabel LabelCarta2SucesosDialog1;
    public javax.swing.JLabel LabelCarta3;
    public javax.swing.JLabel LabelCarta4;
    public javax.swing.JLabel LabelCarta5;
    private javax.swing.JLabel LabelCombinaciones;
    private javax.swing.JLabel LabelConceptos;
    private javax.swing.JLabel LabelConceptos1;
    private javax.swing.JLabel LabelCreditos;
    private javax.swing.JLabel LabelDistribucion;
    private javax.swing.JLabel LabelEjemploContinua;
    private javax.swing.JLabel LabelEjemploDiscreta;
    private javax.swing.JLabel LabelEjemploLaplace;
    private javax.swing.JLabel LabelEjemploMultiplicacion;
    private javax.swing.JLabel LabelEjemploNormal;
    private javax.swing.JLabel LabelEjemploNormal1;
    private javax.swing.JLabel LabelEjemploSuma;
    private javax.swing.JLabel LabelEjercicios;
    private javax.swing.JLabel LabelExplicacionLaplace;
    private javax.swing.JLabel LabelExplicacionMultiplicacion;
    private javax.swing.JLabel LabelExplicacionSuma;
    private javax.swing.JLabel LabelHistoria;
    private javax.swing.JLabel LabelHistoria1;
    private javax.swing.JLabel LabelHistoria2;
    private javax.swing.JLabel LabelHistoria3;
    private javax.swing.JLabel LabelHistoria4;
    private javax.swing.JLabel LabelIniciar;
    private javax.swing.JLabel LabelLaplace;
    private javax.swing.JLabel LabelMultiplicacion;
    private javax.swing.JLabel LabelMultiplicacionFinal;
    private javax.swing.JLabel LabelMultiplicacionLaplace;
    private javax.swing.JLabel LabelMultiplicacionLaplace1;
    private javax.swing.JLabel LabelPag1;
    private javax.swing.JLabel LabelPag2;
    private javax.swing.JLabel LabelPag3;
    private javax.swing.JLabel LabelPag4;
    private javax.swing.JLabel LabelPag5;
    private javax.swing.JLabel LabelPermutaciones;
    private javax.swing.JLabel LabelProbabilidades;
    private javax.swing.JLabel LabelReglas;
    private javax.swing.JLabel LabelRespuestaCorrecta;
    private javax.swing.JLabel LabelRespuestaCorrecta1;
    private javax.swing.JLabel LabelRespuestaCorrecta2;
    private static javax.swing.JLabel LabelResultadoRespuesta;
    private static javax.swing.JLabel LabelResultadoRespuesta1;
    private static javax.swing.JLabel LabelResultadoRespuesta2;
    private javax.swing.JLabel LabelSuma;
    private javax.swing.JLabel LabelSumaFinal;
    private javax.swing.JLabel LabelSumaLaplace;
    private javax.swing.JLabel LabelSumaLaplace1;
    private javax.swing.JLabel LabelSumaNormal;
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
    private javax.swing.JButton atrasBoton21;
    private javax.swing.JButton atrasBoton22;
    private javax.swing.JButton atrasBoton23;
    private javax.swing.JButton atrasBoton24;
    private javax.swing.JButton atrasBoton25;
    private javax.swing.JButton atrasBoton26;
    private javax.swing.JButton atrasBoton3;
    private javax.swing.JButton atrasBoton4;
    private javax.swing.JButton atrasBoton5;
    private javax.swing.JButton atrasBoton6;
    private javax.swing.JButton atrasBoton7;
    private javax.swing.JButton atrasBoton8;
    private javax.swing.JButton atrasBoton9;
    public static javax.swing.JTextField campoResultadoLaplace;
    private javax.swing.JTextField campoResultadoLaplace1;
    private javax.swing.JTextField campoResultadoMultiplicacion;
    public static javax.swing.JTextField campoResultadoMultiplicacion1;
    public static javax.swing.JTextField campoResultadoSuma;
    private javax.swing.JTextField campoResultadoSuma1;
    private javax.swing.JButton combinacionesBoton;
    private javax.swing.JFrame combinacionesFrame;
    private javax.swing.JButton comoutilizartablaBoton;
    private javax.swing.JFrame comoutilizartablaFrame;
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
    private javax.swing.JButton ejemploBoton5;
    private javax.swing.JFrame ejemplocontinuaFrame;
    private javax.swing.JFrame ejemplodiscretaFrame;
    private javax.swing.JFrame ejemplolaplaceFrame;
    private javax.swing.JFrame ejemplomultiplicacionFrame;
    private javax.swing.JFrame ejemplonormalFrame;
    private static javax.swing.JFrame ejemplosumaFrame;
    private javax.swing.JButton ejerciciosBoton;
    private javax.swing.JFrame ejerciciosFrame;
    private javax.swing.JButton explicacionBoton;
    private javax.swing.JButton explicacionBoton1;
    private javax.swing.JButton explicacionBoton2;
    private javax.swing.JDialog explicacionlaplaceDialog;
    private javax.swing.JDialog explicacionmultiplicacionDialog;
    private javax.swing.JDialog explicacionsumaDialog;
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
    private javax.swing.JButton nuevascartasBoton;
    private javax.swing.JButton nuevascartasBoton1;
    private javax.swing.JButton nuevascartasBoton2;
    private javax.swing.JButton pag1Boton;
    private javax.swing.JButton pag2Boton;
    private javax.swing.JButton pag2Boton1;
    private javax.swing.JButton pag3Boton;
    private javax.swing.JButton pag3Boton1;
    private javax.swing.JButton pag4Boton;
    private javax.swing.JButton pag4Boton1;
    private javax.swing.JButton pag5Boton;
    private javax.swing.JButton permutacionesBoton;
    private javax.swing.JFrame permutacionesFrame;
    private javax.swing.JButton reglasBoton;
    private javax.swing.JFrame reglasFrame;
    private javax.swing.JLabel relleno;
    private javax.swing.JButton respuestacorrectaBoton;
    private javax.swing.JButton respuestacorrectaBoton1;
    private javax.swing.JButton respuestacorrectaBoton2;
    private javax.swing.JButton ruletacombinatoriasBoton;
    private javax.swing.JFrame ruletacombinatoriasFrame;
    private javax.swing.JButton ruletareglasBoton;
    private javax.swing.JFrame ruletareglasFrame;
    private javax.swing.JButton salirBoton;
    private javax.swing.JButton siguienteBoton3;
    private javax.swing.JButton sumaBoton;
    private javax.swing.JFrame sumaFrame;
    private javax.swing.JButton tablaBoton;
    private javax.swing.JButton teoriaBoton;
    private javax.swing.JFrame teoriaFrame;
    private javax.swing.JButton verificarrespuestaBoton;
    private javax.swing.JButton verificarrespuestaBoton1;
    private javax.swing.JButton verificarrespuestaBoton2;
    // End of variables declaration//GEN-END:variables
}