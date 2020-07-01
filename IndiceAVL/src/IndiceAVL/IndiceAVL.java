/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndiceAVL;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Karen
 */
public class IndiceAVL {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws IOException {
    ArbolAVL arbol = new ArbolAVL();
    Cursor materias = new Cursor();
    materias.setRuta("materias.txt");
    Cursor estudiantes = new Cursor();
    estudiantes.setRuta("estudiantes.txt");
    Scanner sc = new Scanner(System.in);
    int p = 0;
    while(p==0) {
            System.out.println("1.Ingresar estudiante");
            System.out.println("2.ingresar materia");
            System.out.println("3.consultar");
            System.out.println("4.salir");
            String s;
            sc = new Scanner(System.in);
            int a=0;
            boolean si = false;
            while(si==false) {
                try {
                            sc = new Scanner(System.in);
                    a = sc.nextInt();	
                    if (a==1 || a==2 || a ==3 || a ==4) {
                            si = true;
                    }else {
                            System.out.println("Dato incorrecto el numero debe ser 1 o 2 o 3");
                    }
                }catch(Exception e) {
                    System.out.println("Dato incorrecto debe ser 1 o 2 o 3");
                }
            }
            if(a==1) {
            System.out.println("ingrese los datos como codigo,nombre,numero de materias");
            sc = new Scanner(System.in);
            s= sc.nextLine();
            String listContenido[] = s.split(",");
            try {
                estudiantes.insertar(s.toCharArray());
                String textoFichero[] = estudiantes.getNombre();                
                for (int i = 0; i < textoFichero.length; i=i+3) {
                    String ContenidoPalabra[] = textoFichero[i].split(",");
                    System.out.println(ContenidoPalabra[0]);
                    arbol.insertar(Integer.parseInt(ContenidoPalabra[0]));
                    System.out.println(textoFichero[i]);
                }

            }catch(Exception e){
                    System.out.println("Datos de ingreso no validos");
            }
            }else if(a==2) {

                    System.out.println("ingrese el codigo de la materia,nombre de la materia" );
                    sc = new Scanner(System.in);
                    s = sc.nextLine();
            try {
                materias.insertar(s.toCharArray());

            }catch(Exception e){
                    System.out.println("Datos de ingreso no validos");
            }
            }else if(a==3) {
                    sc = new Scanner(System.in);
                    System.out.println("ingrese el codigo del estudiante:");
                    s = sc.nextLine();

            try {
                String[] textoFichero = estudiantes.getNombre(); 
                    for (int i = 0; i < textoFichero.length; i++) {
                    String ContenidoPalabra[] = textoFichero[i].split(",");
                    System.out.println(textoFichero[i]);
                }
            }catch(Exception e){
                    System.out.println("Datos de ingreso no validos");
            }


            }else if(a==4){
              p=1;
             }

    }

}

}
    

