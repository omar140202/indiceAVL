
package IndiceAVL;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class IndiceAVL extends JFrame implements ActionListener{
    
    JButton botonCrear = new JButton("Crear Arbol");
    JButton botonIngresoEstudiante = new JButton("Ingresar Estudiante");
    JButton botonIngresoMateria = new JButton("Ingresar Materia");
    JButton botonConsultar = new JButton("Consultar");
    
    JLabel texto1 = new JLabel("Datos Estudiantes.");
    JLabel texto2 = new JLabel("Datos Materias.");
    JLabel texto3 = new JLabel("Codigo Estudiante :");
    JLabel texto4 = new JLabel("Nombre Estudiante:");
    JLabel texto5 = new JLabel("Materias:");
    JLabel texto6 = new JLabel("Codigo Materia: ");
    JLabel texto7 = new JLabel("Nombre Materia: ");
    
    JTextField codEst = new JTextField();
    JTextField nomEst = new JTextField();
    JTextField matEst = new JTextField();
    JTextField codMat = new JTextField();
    JTextField nomMat = new JTextField();
    
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    
    public static void main(String[] args) throws IOException {

        IndiceAVL indiceAVL = new IndiceAVL();
        indiceAVL.setBounds(300, 0, 700, 700);
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
        
        c.add(texto1);
        c.add(texto2);
        c.add(texto3);
        c.add(texto4);
        c.add(texto5);
        c.add(texto6);
        c.add(texto7);
        
        c.add(codEst);
        c.add(nomEst);
        c.add(matEst);
        c.add(codMat);
        c.add(nomMat);
        
        c.add(scrollPane1);
        
        texto1.setBounds(70, 10, 200, 30);
        texto2.setBounds(300, 10, 200, 30);
        texto3.setBounds(5, 50, 200, 30);
        texto4.setBounds(5, 90, 200, 30);
        texto5.setBounds(5, 130, 200, 30);
        texto6.setBounds(250, 50, 200, 30);
        texto7.setBounds(250, 90, 200, 30);
        
        codEst.setBounds(120, 55, 100, 20);
        nomEst.setBounds(120, 95, 100, 20);
        matEst.setBounds(70, 135, 150, 20);
        
        codMat.setBounds(350, 55, 100, 20);
        nomMat.setBounds(350, 95, 100, 20);
        
        botonCrear.setBounds(500, 120, 150, 30);
        botonCrear.addActionListener(this);
        botonCrear.setBackground(Color.CYAN);
        
        botonIngresoEstudiante.setBounds(5, 170, 215, 30);
        botonIngresoEstudiante.addActionListener(this);
        botonIngresoEstudiante.setBackground(Color.GREEN);
        
        botonIngresoMateria.setBounds(250, 170, 200, 30);
        botonIngresoMateria.addActionListener(this);
        botonIngresoMateria.setBackground(Color.YELLOW);
        
        botonConsultar.setBounds(500, 170, 150, 30);
        botonConsultar.addActionListener(this);
        botonConsultar.setBackground(Color.ORANGE);
        
        scrollPane.setBounds(2, 220, 2500, 2500);
        scrollPane.setPreferredSize(new Dimension(2500, 2500));  
        scrollPane.setBackground(Color.LIGHT_GRAY);
        
        scrollPane1.setBounds(2, 220, 680, 430);
        scrollPane1.setPreferredSize(new Dimension(680, 400));
        scrollPane1.setBackground(Color.BLUE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == botonCrear){
            
            
            
        } else if (e.getSource() == botonConsultar){
        
            scrollPane.removeAll();
         
            scrollPane.repaint();
            
            scrollPane1.setViewportView(scrollPane);
            
        }
        
    }

}
    
//        ArbolAVL arbol = new ArbolAVL();
//        Cursor materias = new Cursor();
//        materias.setRuta("materias.txt");
//        Cursor estudiantes = new Cursor();
//        estudiantes.setRuta("estudiantes.txt");
//        Scanner sc = new Scanner(System.in);
//        int p = 0;
//
//        while(p==0) {
//
//            System.out.println("1.Ingresar estudiante");
//            System.out.println("2.ingresar materia");
//            System.out.println("3.consultar");
//            System.out.println("4.salir");
//
//            String s;
//            sc = new Scanner(System.in);
//            int a=0;
//            boolean si = false;
//
//            while(si==false) {
//                try {
//
//                    sc = new Scanner(System.in);
//                    a = sc.nextInt();	
//
//                    if (a==1 || a==2 || a ==3 || a ==4) {
//
//                        si = true;
//
//                    }else {
//
//                        System.out.println("Dato incorrecto el numero debe ser 1 o 2 o 3");
//
//                    }
//
//                }catch(Exception e) {
//
//                    System.out.println("Dato incorrecto debe ser 1 o 2 o 3");
//
//                }
//
//            }
//
//            if(a==1) {
//
//                System.out.println("ingrese los datos como codigo,nombre,numero de materias");        
//                sc = new Scanner(System.in);        
//                s= sc.nextLine();        
//                String listContenido[] = s.split(",");
//
//                try {
//
//                    estudiantes.insertar(s.toCharArray());
//                    String textoFichero[] = estudiantes.getNombre();   
//
//                    for (int i = 0; i < textoFichero.length; i=i+3) {
//
//                        String ContenidoPalabra[] = textoFichero[i].split(",");
//                        System.out.println(ContenidoPalabra[0]);
//                        //arbol.insertar(Integer.parseInt(ContenidoPalabra[0]));
//                        System.out.println(textoFichero[i]);
//
//                    }
//
//            }catch(Exception e){
//
//                System.out.println("Datos de ingreso no validos");
//
//            }
//
//            }else if(a==2) {
//
//                System.out.println("ingrese el codigo de la materia,nombre de la materia" );            
//                sc = new Scanner(System.in);
//
//                s = sc.nextLine();
//
//                try {
//
//                    materias.insertar(s.toCharArray());
//
//                }catch(Exception e){
//
//                    System.out.println("Datos de ingreso no validos");
//
//                }
//
//            }else if(a==3) {
//
//                sc = new Scanner(System.in);
//
//                System.out.println("ingrese el codigo del estudiante:");
//
//                s = sc.nextLine();
//
//            try {
//
//                String[] textoFichero = estudiantes.getNombre(); 
//
//                for (int i = 0; i < textoFichero.length; i++) {
//
//                    String ContenidoPalabra[] = textoFichero[i].split(",");
//                    System.out.println(textoFichero[i]);
//
//                    if(s.equals(ContenidoPalabra[2])){
//
//                        String materiasFichero[] = materias.getNombre();
//
//                        for (int j = 0; j < materiasFichero.length; j++) {
//
//                            String numero[] = materiasFichero[j].split(",");
//                            if(ContenidoPalabra[2].equals(materiasFichero[j])){
//                                System.out.println(materiasFichero[j+1]);;
//                            }
//
//                        }
//
//                    }
//                }
//
//            }catch(Exception e){
//
//                System.out.println("Datos de ingreso no validos");
//
//            }
//            }else if(a==4){
//
//                p=1;
//
//            }
//
//        }


