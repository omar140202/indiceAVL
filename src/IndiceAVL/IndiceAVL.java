
package IndiceAVL;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class IndiceAVL extends JFrame implements ActionListener{
    
    ArbolAVL arbol;
    Cursor materias;
    Alumnos estudiantes;
    
    JButton botonCrear = new JButton("Crear Arbol");
    JButton botonIngresoEstudiante = new JButton("Ingresar Estudiante");
    JButton botonIngresoMateria = new JButton("Ingresar Materia");
    JButton botonConsultar = new JButton("Consultar");
    JButton botonDibujar = new JButton("Dibujar Abol");
    
    JLabel texto1 = new JLabel("Datos Estudiantes.");
    JLabel texto2 = new JLabel("Datos Materias.");
    JLabel texto3 = new JLabel("Codigo Estudiante :");
    JLabel texto4 = new JLabel("Nombre Estudiante:");
    JLabel texto5 = new JLabel("Materias:");
    JLabel texto6 = new JLabel("Codigo Materia: ");
    JLabel texto7 = new JLabel("Nombre Materia: ");
    JLabel texto8 = new JLabel("Didite el codigo del estudiante");
    
    JTextField codEst = new JTextField();
    JTextField nomEst = new JTextField();
    JTextField matEst = new JTextField();
    JTextField codMat = new JTextField();
    JTextField nomMat = new JTextField();
    JTextField campoConsulta = new JTextField();
    
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JScrollPane scrollPane3 = new JScrollPane();
    
    public static void main(String[] args) {

        IndiceAVL indiceAVL = new IndiceAVL();
        indiceAVL.setBounds(300, 0, 1000, 700);
        indiceAVL.setTitle("Materias Cursores/AVL");
        indiceAVL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        indiceAVL.setVisible(true);   

    }

    public IndiceAVL(){
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        c.add(botonCrear);
        c.add(botonIngresoEstudiante);
        c.add(botonIngresoMateria);
        c.add(botonConsultar);
        c.add(botonDibujar);
        
        c.add(texto1);
        c.add(texto2);
        c.add(texto3);
        c.add(texto4);
        c.add(texto5);
        c.add(texto6);
        c.add(texto7);
        c.add(texto8);
        
        c.add(codEst);
        c.add(nomEst);
        c.add(matEst);
        c.add(codMat);
        c.add(nomMat);
        c.add(campoConsulta);
        
        c.add(scrollPane1);
        c.add(scrollPane3);
        
        texto1.setBounds(70, 10, 200, 30);
        texto2.setBounds(400, 10, 200, 30);
        texto3.setBounds(5, 50, 200, 30);
        texto4.setBounds(5, 90, 200, 30);
        texto5.setBounds(5, 130, 200, 30);
        texto6.setBounds(350, 50, 200, 30);
        texto7.setBounds(350, 90, 200, 30);
        texto8.setBounds(730, 105, 250, 30);
        
        codEst.setBounds(120, 55, 100, 20);
        nomEst.setBounds(120, 95, 100, 20);
        matEst.setBounds(70, 135, 150, 20);
        
        codMat.setBounds(450, 55, 100, 20);
        nomMat.setBounds(450, 95, 100, 20);
        
        campoConsulta.setBounds(770,140,100,20);
        
        botonCrear.setBounds(660, 10, 320, 30);
        botonCrear.addActionListener(this);
        botonCrear.setBackground(Color.CYAN);
        
        botonIngresoEstudiante.setBounds(5, 170, 215, 30);
        botonIngresoEstudiante.addActionListener(this);
        botonIngresoEstudiante.setBackground(Color.GREEN);
        
        botonIngresoMateria.setBounds(350, 170, 200, 30);
        botonIngresoMateria.addActionListener(this);
        botonIngresoMateria.setBackground(Color.YELLOW);
        
        botonConsultar.setBounds(660, 170, 320, 30);
        botonConsultar.addActionListener(this);
        botonConsultar.setBackground(Color.ORANGE);
        
        botonDibujar.setBounds(660, 50, 320, 30);
        botonDibujar.addActionListener(this);
        botonDibujar.setBackground(Color.blue);
        
        scrollPane.setBounds(2, 220, 2500, 2500);
        scrollPane.setPreferredSize(new Dimension(2500, 2500));  
        scrollPane.setBackground(Color.LIGHT_GRAY);
        
        scrollPane1.setBounds(2, 220, 650, 430);
        scrollPane1.setPreferredSize(new Dimension(650, 430));
        scrollPane1.setBackground(Color.BLUE);
        
        scrollPane2.setBounds(660, 220, 600, 1000);
        scrollPane2.setPreferredSize(new Dimension(600, 1000));  
        scrollPane2.setBackground(Color.LIGHT_GRAY);
        
        scrollPane3.setBounds(660, 220, 320, 430);
        scrollPane3.setPreferredSize(new Dimension(320, 430));
        scrollPane3.setBackground(Color.BLUE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == botonCrear){
            
            arbol = new ArbolAVL();
            
            try {
                
                materias = new Cursor();
                
            } catch (IOException ex) {
                
                Logger.getLogger(IndiceAVL.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            materias.setRuta("materias.txt");
            
            
            estudiantes.setRuta("estudiantes.txt");
            
        } else if(e.getSource() == botonIngresoEstudiante && !codEst.getText().equals("") && !nomEst.getText().equals("") && !matEst.getText().equals("")){
           
            String s = "";        
            s = codEst.getText() + "," +nomEst.getText() + "," + matEst.getText(); 
            System.out.println(s);
            String listContenido[] = s.split(",");

            try {

                estudiantes.insertar(s.toCharArray());
                String textoFichero[] = estudiantes.getNombre();   

                for (int i = 0; i < textoFichero.length; i=i+3) {

                    String ContenidoPalabra[] = textoFichero[i].split(",");
                    System.out.println(ContenidoPalabra[0]);
                    //arbol.insertar(Integer.parseInt(ContenidoPalabra[0]));
                    System.out.println(textoFichero[i]);

                }

            }catch(IOException e1){

                System.out.println("Datos de ingreso no validos");

            }
            
        } else if(e.getSource() == botonIngresoMateria && !codMat.getText().equals("") && !nomMat.getText().equals("")) {
                try {

                    materias.insertar((codMat.getText() + nomMat.getText()).toCharArray());

                }catch(IOException e2){

                    System.out.println("Datos de ingreso no validos");

                }
            
        } else if (e.getSource() == botonDibujar){
        
            scrollPane.removeAll();
         
            scrollPane.repaint();
            
            scrollPane1.setViewportView(scrollPane);
            
        }else if (e.getSource() == botonConsultar && !campoConsulta.getText().equals("")){

            try {

                String[] textoFichero = estudiantes.getNombre(); 

                for (int i = 0; i < textoFichero.length; i++) {

                    String ContenidoPalabra[] = textoFichero[i].split(",");
                    System.out.println(textoFichero[i]);

                    if(campoConsulta.getText().equals(ContenidoPalabra[2])){

                        String materiasFichero[] = materias.getNombre();

                        for (int j = 0; j < materiasFichero.length; j++) {

                            String numero[] = materiasFichero[j].split(",");
                            if(ContenidoPalabra[2].equals(materiasFichero[j])){
                                System.out.println(materiasFichero[j+1]);;
                            }

                        }

                    }
                }

            }catch(Exception e3){

                System.out.println("Datos de ingreso no validos");

            }
            
            scrollPane2.removeAll();
         
            scrollPane2.repaint();
            
            scrollPane3.setViewportView(scrollPane2);
            
        }
        
    }

}