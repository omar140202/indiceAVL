
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
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class IndiceAVL extends JFrame implements ActionListener{
    
    JButton botonCrear = new JButton("Crear Arbol");
    JButton botonIngresoEstudiante = new JButton("Ingresar Estudiante");
    JButton botonIngresoMateria = new JButton("Ingresar Materia");
    JButton botonConsultar = new JButton("Consultar");
    
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    
    public static void main(String[] args) throws IOException {

        IndiceAVL indiceAVL = new IndiceAVL();
        indiceAVL.setBounds(300, 0, 700, 700);
        indiceAVL.setTitle("Materias Cursores/AVL");
        indiceAVL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        indiceAVL.setVisible(true);   
        
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

    }

    public IndiceAVL(){
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        c.add(botonCrear);
        c.add(botonIngresoEstudiante);
        c.add(botonIngresoMateria);
        c.add(botonConsultar);
        
        c.add(scrollPane1);
        
        botonCrear.setBounds(500, 20, 150, 30);
        botonCrear.addActionListener(this);
        botonCrear.setBackground(Color.CYAN);
        
        botonIngresoEstudiante.setBounds(500, 70, 150, 30);
        botonIngresoEstudiante.addActionListener(this);
        botonIngresoEstudiante.setBackground(Color.GREEN);
        
        botonIngresoMateria.setBounds(500, 120, 150, 30);
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
    

