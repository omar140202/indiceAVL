package IndiceAVL;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Cursor {
	private char nombre[][];
	private int izq[];
	private int der[];
	private char vacio[]= "vacio".toCharArray();
	private int tamano;
	private int cont = 0;
	String ruta = "cursor.txt";

   
	File archivo = new File(ruta);
	BufferedWriter bw;
	FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;

	
    Cursor()throws IOException{
            nombre = new char[20][20];
            izq = new int[20];
            der = new int[20];

            der[0]=1;
            izq[0]=0;
            nombre[0] = vacio;



            for (int i = 1; i < 20; i++) {
                    der[i] = i+1;
                    nombre[i] = vacio;
                    izq[i] = 0;
            }
            der[der.length-1] = 0;

            tamano = 20;
            cargar();
    }
    void cargar() throws IOException {
            try {
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            System.out.println("El fichero de texto ya estaba creado.");
            String linea;
            int arreglo = 0;
            char aux []= new char[20];

            while((linea=br.readLine())!=null) {
                    String listNum[] = linea.split(" ");
                    for(int i =0 ;i<listNum.length;i++){
                            if (arreglo == 0) {
                                    aux = listNum[i].toCharArray();
                                    nombre[i] = aux;
                            }else if (arreglo == 1) {
                                    izq[i]= Integer.parseInt(listNum[i]);
                            }else if (arreglo == 2 ) {
                                    der[i]= Integer.parseInt(listNum[i]);
                            }else {
                                    System.out.println("Algo salio mal");
                            }
                }
                    arreglo++;
            }
        }catch(Exception e){
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(new FileWriter(archivo));

        }
    }
    void actualizar() throws IOException {
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);
            bw  = new BufferedWriter(fw);

            for (int i = 0 ;i < nombre.length ; i++) {
                    if (i != nombre.length-1) {
                            bw.write(String.copyValueOf(nombre[i])+" ");
                    }else {
                            bw.write(String.copyValueOf(nombre[i])+"\n");
                    }	
            }
            for (int i = 0 ;i < nombre.length ; i++) {
                    if (i != nombre.length-1) {
                            bw.write(izq[i]+" ");
                    }else {
                            bw.write(izq[i]+"\n");
                    }	
            }
            for (int i = 0 ;i < nombre.length ; i++) {
                    if (i != nombre.length-1) {
                            bw.write(der[i]+" ");
                    }else {
                            bw.write(izq[i]+"\n");
                    }	
            }
            bw.close();
    }
    void mostrar() {
            for (int i = 0 ; i<nombre.length;i++) {
                    System.out.print("["+i+"|");
                    for (int j =0; j<nombre[i].length ; j++) {
                            System.out.print(nombre[i][j]);
                    }
                    System.out.print("|"+izq[i]+"|"+der[i]+"]");
                    System.out.println();
            }
    }
    int menor(char nombre[], char nombre1[]) {
            int aux = Math.min(nombre.length, nombre1.length);
            for (int i = 0 ; i < aux; i ++) {
                    if (nombre[i]<nombre1[i]) {
                            return 1;
                    }else if(nombre[i] > nombre1[i]) {
                            return 2;
                    }
            }
            if (aux == nombre.length) {
                    return 1;
            }else {
                    return 2;
            }
    }
    int buscarp (int pos) {
            int posp=izq[0];
            int aux = izq[0];
            while (aux != pos) {
                    posp = aux;
                    if (menor(nombre[aux],nombre[pos]) == 1) {
                            aux = der[aux];
                    }else {
                            aux = izq[aux];
                    }
            }
            return posp;
    }
    boolean igual(char nombre[],char nombre1[]) {
            boolean bandera = true;
            try {
                    int aux = Math.max(nombre.length, nombre1.length);
                    for (int i = 0 ; i < aux; i ++) {
                            if (nombre[i]!=nombre1[i]) {
                                    return bandera = false;
                            }
                    }
            }catch(Exception e) {
                    return bandera = false;
            }
            return bandera;
    }

    void eliminar(char nombre2[]) throws IOException {
            int pos = -1;
            for (int i = 0 ; i < nombre.length ; i++) {
                    if (igual(nombre[i],nombre2)) {
                            System.out.println("Dato encontrado");
                            pos = i;
                    }
            }
            if (pos == -1) {
                    System.out.println("Dato no encontrado");
                    return;
            }
            int posp = buscarp(pos);
            if (izq[pos] == 0 && der[pos] == 0) {

                    if (pos == posp) {
                            izq[0] = 0;
                    }else {
                            if (menor(nombre[posp],nombre[pos])==1) {
                                    der[posp] = 0;
                            }else {
                                    izq[posp] = 0;
                            }
                    }
                    nombre[pos] = vacio;
                    der[pos] = der[0];
                    der[0] = pos;
            }else if (der[pos] == 0){
                    if (posp == pos) {
                            izq[0] = izq[pos];
                    }else {
                            if (menor(nombre[posp],nombre[pos])==1) {
                                    der[posp] = izq[pos];
                            }else {
                                    izq[posp] = izq[pos];
                            }
                    }
                    nombre[pos] = vacio;
                    izq[pos] = 0;
                    der[pos] = der[0];
                    der[0] = pos;
            }else {
                    int auxp = remplazar(pos);
                    int pauxp = buscarp(auxp);

                    if (auxp == der[pos]) {
                            der[pos] = der[auxp];
                    }else {
                            izq[pauxp] = der[auxp];
                    }
                    nombre[pos] = nombre[auxp];
                    nombre[auxp] = vacio;
                    izq[auxp] = 0;
                    der[auxp] = der[0];
                    der[0] = auxp;
            }
            cont --;
            actualizar();
    }
    int remplazar(int pos) {
            int aux = der[pos];
            int a = aux;
            while (a != 0 ) {
                    aux =a ;
                    a = izq[a];
            }
            return aux;
    }

    void insertar(char nombre1[]) throws IOException {
            for (int i = 0 ; i < nombre.length ; i++) {
                    if (igual(nombre[i],nombre1)) {
                            System.out.println("Ya existe ese nombre");
                            return;
                    }
            }
            cont++;
            if (cont >= tamano) {
                    System.out.println("El cursor esta lleno, amplielo");
                    cont --;
                    return ;
            }
            if (izq[0] == 0) {
                    izq[0] = 1;
                    nombre[izq[0]] = nombre1;
                    der[0] = der[1];
                    izq[1] = 0;
                    der[1] = 0;		
            } else {
                    int aux;
                    nombre[der[0]] = nombre1;
                    aux = der[0];
                    der[0] = der[aux];
                    der[aux] = 0;
                    int i = izq[0];
                    while (nombre[i] != nombre1) {
                            if (menor(nombre[i],nombre1) == 1) {
                                    if (der[i] == 0) {
                                            der[i] = aux;
                                            break;
                                    }else {
                                            i = der[i];
                                    }
                            }else {
                                    if (izq[i]==0) {
                                            izq[i] =aux;
                                            break;
                                    }else {
                                            i = izq[i];
                                    }
                            }
                    }
            }
            actualizar();
    }
    void inorden(int raiz) {
            if (raiz!= 0){
                    inorden(izq[raiz]);
                    System.out.print(String.valueOf(nombre[raiz])+" ");
                    inorden(der[raiz]);
            }
    }
    void ampliar() {
            tamano = tamano + 10;
            char auxn[][] = new char [tamano][20];
            int auxi[] = new int [tamano];
            int auxd[] = new int [tamano];

            auxd[0]=1;
            auxi[0]=0;
            auxn[0] = vacio;

            for (int i = 1; i < tamano; i++) {
                    auxd[i] = i+1;
                    auxn[i] = vacio;
                    auxi[i] = 0;
            }
            auxd[auxd.length-1] = 0;


            for (int i = 0; i < nombre.length ; i++) {
                    auxn[i] = nombre[i];
                    auxi[i] = izq[i];
                    auxd[i] = der[i];
            }
            auxd[tamano-11] = tamano-10;
            auxd[0] = tamano-10;
            auxd[tamano-11] = 0;

            nombre = new char[tamano][20];
            nombre = auxn;
            izq = new int[tamano];
            izq = auxi;
            der = new int[tamano];
            der = auxd;
    }
    int getRaiz() {
            return izq[0];
    }
    String [] getNombre(){
            String  nombres []= new String [nombre.length];
            for (int i = 0 ; i < nombre.length ; i++){
                    nombres[i] = String.valueOf(nombre[i]);
            }
            return nombres;
    }
    int [] getIzq() {
            return izq;
    }
    int [] getDer() {
            return der;
    }
     public String getRuta() {
    return ruta;
}

public void setRuta(String ruta) {
    this.ruta = ruta;
}



//	public int getCont(int n) {
//		try {
//			if (nombre[n] == vacio)
//	            return 0;
//	        else {
//	            if (izq[n] != 0 && der[n] != 0)
//	                return getCont(izq[n]) + getCont(der[n]) + 1;
//	            return getCont(izq[n]) + getCont(der[n]);
//	        }
//		}catch(Exception e) {
//			return 0;
//		}
//        
//    }

}
